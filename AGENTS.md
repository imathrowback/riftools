# Lessons

- **If you find yourself decompiling Java bytecode, stop and ask for help.** You've gone off the rails. The source code is right there — read it instead. If the output doesn't match what the source says, there's probably a simpler explanation (stale build, wrong classpath, etc.) that a human can spot in seconds.
- **Before decompiling class files or running `strings` on `.class` files, check for a stale jar on the classpath.** If a build output doesn't match source, the most likely cause is an older jar being loaded first. Check `find ... -name "*.jar"` results in the right order.
- **Build and run workflow**: Run `./build.sh` from the project root (`~/riftools`). This invokes Gradle to build all modules. Built JARs are at:
  - `RiftTools/build/libs/RiftTool-1.0.jar` — main CLI
  - `ManifestDiff/build/libs/ManifestDiff-1.0.jar` — standalone manifest diff
  - `telaradbdiff/build/libs/telaradbdiff-1.0.jar` — standalone DB diff
  - `totext/build/libs/totext-1.0.jar` — standalone ToTextMode
  - `mapgen/build/libs/mapgen-1.0.jar` — standalone MapGen

- **Running RiftTool**: Use the full absolute path: `java -jar ~/riftools/RiftTools/build/libs/RiftTool-1.0.jar <args>`. Run without args to see usage. Available actions include `PRINTVERSIONS`, `GETVERSION`, `DOWNLOADFILE`, `EXTRACT`, etc.

- **TelaraDBDiff vs ManifestDiff**: ManifestDiff diffs `.manifest` files (asset manifests, TWAM format) — takes `-manifestA`/`-manifestB`. TelaraDBDiff diffs SQLite database files (`.db`/`.cds`) — takes `-dbA`/`-dbB`. They are completely separate tools for different data layers.

- **Downloading files for TelaraDBDiff**: Use `java -jar RiftTools/build/libs/RiftTool-1.0.jar -action DOWNLOADFILE -pIndex N -release LIVE -filename <name> -outfilename <path>`. Do NOT pass `-lang 0` — that restricts to lang=0 entries which may not match English (lang=1). Omit the `-lang` flag entirely (defaults to `-1` = any language). Key files to download:
  - `telara.db` — the actual game database (property class data)
  - `lang_english.cds` — localization database for TextEntry ID-to-string lookups (NOT the game db itself)
  - `rift_datamodel.txt` — pre-generated class model mapping class IDs to field names (lives at `/tmp/rift_datamodel.txt`)

- **TelaraDBDiff invocation**: `java -jar telaradbdiff/build/libs/telaradbdiff-1.0.jar -dbA <fileA> -dbB <fileB> -dbResolve /tmp/rift_datamodel.txt [-langA <cdsA> -langB <cdsB>] -outdir <dir> -format html -output <path>`
  - Or via the main CLI: `java -jar RiftTools/build/libs/RiftTool-1.0.jar -action TELARADBDIFF -dbA <fileA> ...` (if the action exists)`
  - Both TelaraDBDiff and ManifestDiff now emit summary lines to stdout (`Added: N`, `Deleted: N`, `Changed: N`, etc.) regardless of output format — parseable by external tools.
  - TelaraDBDiff now loads and displays the actual object data for deleted entries (not just the ID).

- **ToTextMode invocation**: `java -jar totext/build/libs/totext-1.0.jar -fileType CDS -file <input.cds> -output <output.txt>`. Converts `.cds` localization databases to text format for text-level diffs.

- **sitegen/ subproject**: Python 3 script at `~/riftools/sitegen/sitegen.py` for generating a static HTML patch diff site. Usage:
  ```
  python sitegen/sitegen.py <start> <end> <destdir> --datamodel /path/to/rift_datamodel.txt
  ```
  - `<start>` and `<end>` are patch indexes (e.g. `25 29` generates 25v26, 26v27, 27v28, 28v29)
  - Files are cached in `~/.riftools_cache/`
  - For each pair, generates: `telaradb.html` (TelaraDBDiff), `manifest.html` (ManifestDiff), `langdiff.html` (text diff of lang_english.cds via ToTextMode + Python difflib)
  - Produces `index.html` with a summary table showing all change counts per pair across all three diff types`
