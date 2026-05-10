# Improved Diff Process — Implementation Plan

## 1. Current Problems

| Problem | Detail |
|---|---|
| Single monolithic class | All logic in `ManifestDiff.doMain()` (~350 lines) |
| Only filename-hash as identity key | Can't detect renames, moves, or deduplication |
| O(n*m) trait in changed detection | Inner loop over `bentries` checking `lang` + `shaStr` |
| Language-coupled change detection | Entry with same SHA but different `lang` flagged as changed |
| No rename tracking | Same SHA in added+deleted → should be "renamed" |
| No move tracking | Same SHA+lang, different `pakIndex` — silently ignored (PAK compare is commented out) |
| `alwaysDownload` uses `NameDB` silently | Empty string from unknown hash → `.contains` always false |
| `added` count wrong in verbose | Language filter applied in output only, not in counting |
| No structural metadata diff | PAK index, size, compression changes lost |

## 2. Target Architecture

### New classes in `org.imathrowback.manifest.diff`:

```
┌─────────────────────────────────────────────────────┐
│                   ManifestDiffer                     │
│   Orchestrates: key strategy → passes → formatter   │
├─────────────────────────────────────────────────────┤
│  + diff(Manifest a, Manifest b, DiffConfig): DiffResult │
└──────────┬──────────────────────────┬────────────────┘
           │                          │
     ┌─────▼──────┐           ┌──────▼──────────┐
     │ DiffPass    │           │ DiffResult      │
     │ (3 phases)  │           │ (structured)    │
     └─────┬──────┘           └──────┬──────────┘
           │                         │
     ┌─────▼────────────────────┐    │
     │ DiffKeyStrategy (enum)   │    │
     │  - FILENAME_HASH (cur)   │    │
     │  - ASSET_ID              │    │
     │  - FILENAME_HASH_AND_LANG│    │
     │  - SHA (dedup detection) │    │
     └──────────────────────────┘    │
                                     │
     ┌───────────────────────────────▼──────────┐
     │ DiffEntry / DiffEntrySet                 │
     │ ChangeType: ADDED, DELETED, CHANGED,     │
     │             MOVED, RENAMED, UNCHANGED    │
     │ MetadataChange: PAK_INDEX, SIZE,         │
     │                COMPRESSED_SIZE           │
     └──────────────────────────────────────────┘
```

## 3. Diff Phases (3-pass algorithm, O(n+m))

### Phase 1 — Build symmetric multimaps

```
buildEntryMap(Manifest m) → Map<K, List<ManifestEntry>>
  where K is determined by DiffKeyStrategy
```

`Manifest.fileNameHashesIDMap` already is this map, keyed by `filenameHashStr`. For other strategies, build a new map on the fly.

### Phase 2 — Set operations on keys

```
keysA  = mapA.keySet()   // all unique keys in A
keysB  = mapB.keySet()   // all unique keys in B

onlyInA   = keysA - keysB       → candidates for DELETED / RENAMED_FROM
onlyInB   = keysB - keysA       → candidates for ADDED / RENAMED_TO
inBoth    = keysA ∩ keysB       → candidates for CHANGED / MOVED / UNCHANGED
```

### Phase 3 — Deep compare each bucket

#### For `onlyInA` / `onlyInB` — SHA-based rename detection:

```
build SHA-to-key maps for onlyInA and onlyInB entries
  shaMapA: Map<shaStr, List<K>>  (entries only in A)
  shaMapB: Map<shaStr, List<K>>  (entries only in B)

renameSHA = shaMapA.keySet() ∩ shaMapB.keySet()
  for each sha in renameSHA:
    for each keyA in shaMapA[sha], keyB in shaMapB[sha]:
      RENAMED: keyA → keyB  (same content, different identity key)
    remove from onlyInA / onlyInB

remaining onlyInA  → DELETED
remaining onlyInB  → ADDED
```

#### For `inBoth` — per-key deep compare:

```
for each key in inBoth:
  entriesA = mapA[key]  // could be multiple (different langs, or duplicates)
  entriesB = mapB[key]

  // Group by lang
  byLangA = entriesA grouped by lang
  byLangB = entriesB grouped by lang

  langsOnlyInA = byLangA.keySet() - byLangB.keySet()  → DELETED (lang-specific)
  langsOnlyInB = byLangB.keySet() - byLangA.keySet()  → ADDED (lang-specific)
  langsInBoth  = byLangA.keySet() ∩ byLangB.keySet()

  for each lang in langsInBoth:
    a = byLangA[lang]
    b = byLangB[lang]

    // SHA comparison (primary content identity)
    if a.shaStr equals b.shaStr:
      base = UNCHANGED
    else:
      base = CHANGED

    // PAK index comparison (structural metadata)
    if a.pakIndex != b.pakIndex:
      add MOVED metadata flag

    // Size comparison
    if a.size != b.size or a.compressedSize != b.compressedSize:
      add SIZE_CHANGED metadata flag

    emit entry with base status + metadata flags
```

## 4. Data Model

### `DiffConfig`

```
public class DiffConfig {
  DiffKeyStrategy keyStrategy = FILENAME_HASH;
  int onlyLang = -1;             // -1 = all
  boolean detectRenames = true;
  boolean trackPakMoves = true;
  boolean trackSizeChanges = false;
}
```

### `DiffResult`

```
public class DiffResult {
  Map<ChangeType, List<DiffEntry>> entriesByType;
  int totalOld, totalNew;
  // convenience: getAdded(), getDeleted(), getChanged(), getRenamed(), getMoved()
}
```

### `DiffEntry`

```
public class DiffEntry {
  ChangeType changeType;         // ADDED, DELETED, CHANGED, MOVED, RENAMED, UNCHANGED
  ManifestEntry entryOld;        // null for ADDED
  ManifestEntry entryNew;        // null for DELETED
  String oldKey;                 // identity key in A
  String newKey;                 // identity key in B (different from oldKey for RENAMED)
  Set<MetadataFlag> metadataFlags;
  String resolvedFilename;       // from NameDB
}
```

### `ChangeType` enum

```
public enum ChangeType {
  ADDED,       // key exists only in B
  DELETED,     // key exists only in A
  CHANGED,     // same key, same lang, different SHA
  RENAMED,     // same SHA, different key (rename detection)
  MOVED,       // same SHA+lang, different PAK index
  UNCHANGED    // identical in every compared dimension
}
```

### `MetadataFlag` enum

```
public enum MetadataFlag {
  PAK_INDEX_CHANGED,
  SIZE_CHANGED,
  COMPRESSED_SIZE_CHANGED,
  LANG_ADDED,
  LANG_REMOVED
}
```

## 5. Output Formatter

### Text format (backward-compatible, extended)

Current: `+|filename|hash:assetid:lang|pakIndex`

New (extended with an additional change-type character):

```
+|filename|hash:id:lang|pakIndex           (same as before — ADDED)
-|filename|hash:id:lang|pakIndex           (DELETED)
*|filename|hash:id:lang|pakIndex           (CHANGED)
>|filename|hash:id:lang|pakIndex:oldPak    (MOVED — PAK index changed)
~|oldName->newName|hash:id:lang|pakIndex   (RENAMED)
```

Verbose mode adds per-entry metadata flags in parentheses:

```
+|filename|hash:id:lang|pakIndex (size:12345->0)
```

### JSON format (new, machine-readable)

```
{
  "releaseA": "rift-1-2-2353445-123456789",
  "releaseB": "rift-1-2-2353445-123456790",
  "added":    [{"name":"...", "hash":"...", "id":"...", "lang":1, "pakIndex":3}],
  "deleted":  [...],
  "changed":  [{"name":"...", "oldSha":"...", "newSha":"...", "oldPak":3, "newPak":5}],
  "renamed":  [{"oldName":"...", "newName":"...", "sha":"..."}],
  "moved":    [{"name":"...", "oldPak":3, "newPak":5}],
  "stats":    {"added":5, "deleted":2, "changed":17, "renamed":1, "moved":3}
}
```

Flag: `-format=text` (default), `-format=json`

## 6. Implementation Order

| Step | What | Dependencies |
|---|---|---|
| 1 | Define `ChangeType`, `MetadataFlag`, `DiffEntry`, `DiffResult`, `DiffConfig` | None |
| 2 | Implement `DiffKeyStrategy` enum + multimap builder | Step 1 |
| 3 | Implement `ManifestDiffer` — Phase 1 (build maps) + Phase 2 (set ops) | Steps 1-2 |
| 4 | Implement Phase 3 — deep compare (SHA, lang, PAK, size) | Step 3 |
| 5 | Implement Phase 3 — rename detection (SHA intersection) | Step 3 |
| 6 | Write unit tests for each phase with synthetic manifests | Steps 1-5 |
| 7 | Refactor `ManifestDiff.doMain()` to use `ManifestDiffer` + integrate `-format` | Steps 1-6 |
| 8 | Add `-renameDetection`, `-trackMoves`, `-format` CLI flags | Step 7 |
| 9 | Add JSON formatter | Step 7 |
| 10 | Remove dead code, fix semicolon bug, close streams, use SLF4J | Step 7 |

### Step 1 — Data model classes (no dependencies, ~80 lines total)

### Steps 3-5 — Core algorithm (~200 lines)

### Step 6 — Tests (~150 lines)

### Steps 7-8 — Integration (~100 lines changed in ManifestDiff.java)

## 7. Backward Compatibility

| Concern | Mitigation |
|---|---|
| Default key strategy | `FILENAME_HASH` — identical to current behavior |
| Default flags | `detectRenames=true`, `trackPakMoves=true` — strictly additive |
| Text output | `+|*|-` lines identical; `>|` and `~|` are new (never emitted before) |
| `added` count | Fixed — filter applied before counting, not after |
| Verbose stats | Unchanged keys still reported under UNCHANGED (not printed) |

## 8. Open Questions

1. What happens when one manifest is 64-bit and the other 32-bit? (Currently `manifestA64`/`manifestB64` are independent.)
2. Manifest v2 vs v3 differences — does the `filenameLength` field affect identity?
3. Should `alwaysDownload` behavior be retained as-is, or exposed as a `-alwaysDownloadExt` filter list?
