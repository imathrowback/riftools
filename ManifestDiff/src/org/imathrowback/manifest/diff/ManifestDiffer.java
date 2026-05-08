package org.imathrowback.manifest.diff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.util.Util;

public class ManifestDiffer
{
	public DiffResult diff(final Manifest manifestA, final Manifest manifestB)
	{
		return diff(manifestA, manifestB, new DiffConfig());
	}

	public DiffResult diff(final Manifest manifestA, final Manifest manifestB, final DiffConfig config)
	{
		DiffResult result = new DiffResult();
		result.setTotalOld(manifestA.manifestEntries.size());
		result.setTotalNew(manifestB.manifestEntries.size());

		Map<String, List<ManifestEntry>> mapA = buildEntryMap(manifestA, config);
		Map<String, List<ManifestEntry>> mapB = buildEntryMap(manifestB, config);

		Set<String> keysA = mapA.keySet();
		Set<String> keysB = mapB.keySet();

		Set<String> onlyInA = new HashSet<>(keysA);
		onlyInA.removeAll(keysB);

		Set<String> onlyInB = new HashSet<>(keysB);
		onlyInB.removeAll(keysA);

		Set<String> keysBoth = new HashSet<>(keysA);
		keysBoth.retainAll(keysB);

		if (config.isDetectRenames() && config.getKeyStrategy().supportsRenames())
			detectRenames(config, mapA, mapB, onlyInA, onlyInB, result);

		fuzzyMatchChanges(config, mapA, mapB, onlyInA, onlyInB, result, manifestA, manifestB);

		for (String key : onlyInA)
			for (ManifestEntry entry : mapA.get(key))
				result.addEntry(new DiffEntry(ChangeType.DELETED, entry, null, key, key,
						EnumSet.noneOf(MetadataFlag.class), resolveName(entry)));

		for (String key : onlyInB)
			for (ManifestEntry entry : mapB.get(key))
				result.addEntry(new DiffEntry(ChangeType.ADDED, null, entry, key, key,
						EnumSet.noneOf(MetadataFlag.class), resolveName(entry)));

		for (String key : keysBoth)
			deepCompareKey(config, mapA.get(key), mapB.get(key), key, result,
					manifestA, manifestB);

		return result;
	}

	private Map<String, List<ManifestEntry>> buildEntryMap(final Manifest manifest, final DiffConfig config)
	{
		DiffKeyStrategy strategy = config.getKeyStrategy();

		if (strategy == DiffKeyStrategy.FILENAME_HASH)
		{
			Map<String, List<ManifestEntry>> map = new HashMap<>();
			for (Map.Entry<String, List<ManifestEntry>> kv : manifest.fileNameHashesIDMap.entrySet())
			{
				List<ManifestEntry> filtered = filterByLang(kv.getValue(), config);
				if (!filtered.isEmpty())
					map.put(kv.getKey(), filtered);
			}
			return map;
		}

		Map<String, List<ManifestEntry>> map = new HashMap<>();
		for (ManifestEntry entry : manifest.manifestEntries)
		{
			if (!config.shouldIncludeLang(entry.lang))
				continue;
			String key = strategy.getKey(entry);
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
		}
		return map;
	}

	private List<ManifestEntry> filterByLang(final List<ManifestEntry> entries, final DiffConfig config)
	{
		if (config.getOnlyLang() <= 0)
			return entries;
		List<ManifestEntry> filtered = new ArrayList<>();
		for (ManifestEntry e : entries)
			if (config.shouldIncludeLang(e.lang))
				filtered.add(e);
		return filtered;
	}

	private void detectRenames(final DiffConfig config,
			final Map<String, List<ManifestEntry>> mapA,
			final Map<String, List<ManifestEntry>> mapB,
			final Set<String> onlyInA, final Set<String> onlyInB,
			final DiffResult result)
	{
		Map<String, List<ManifestEntry>> shaMapA = groupBySha(flatten(mapA, onlyInA));
		Map<String, List<ManifestEntry>> shaMapB = groupBySha(flatten(mapB, onlyInB));

		Set<String> commonShas = new HashSet<>(shaMapA.keySet());
		commonShas.retainAll(shaMapB.keySet());

		for (String sha : commonShas)
		{
			List<ManifestEntry> entriesA = shaMapA.get(sha);
			List<ManifestEntry> entriesB = shaMapB.get(sha);
			int pairs = Math.min(entriesA.size(), entriesB.size());

			for (int i = 0; i < pairs; i++)
			{
				ManifestEntry a = entriesA.get(i);
				ManifestEntry b = entriesB.get(i);
				String oldKey = config.getKeyStrategy().getKey(a);
				String newKey = config.getKeyStrategy().getKey(b);
				result.addEntry(new DiffEntry(ChangeType.RENAMED, a, b, oldKey, newKey,
						EnumSet.noneOf(MetadataFlag.class), resolveName(b)));

				removeKey(mapA, oldKey, onlyInA);
				removeKey(mapB, newKey, onlyInB);
			}
		}
	}

	private void fuzzyMatchChanges(final DiffConfig config,
			final Map<String, List<ManifestEntry>> mapA,
			final Map<String, List<ManifestEntry>> mapB,
			final Set<String> onlyInA, final Set<String> onlyInB,
			final DiffResult result,
			final Manifest manifestA, final Manifest manifestB)
	{
		Map<String, List<ManifestEntry>> fuzzyMapA = new HashMap<>();
		for (String key : onlyInA)
			for (ManifestEntry e : mapA.get(key))
				fuzzyMapA.computeIfAbsent(
						e.filenameHashStr + ":" + e.lang + ":" + normalizedPakName(manifestA, e.pakIndex),
						k -> new ArrayList<>()).add(e);

		Map<String, List<ManifestEntry>> fuzzyMapB = new HashMap<>();
		for (String key : onlyInB)
			for (ManifestEntry e : mapB.get(key))
				fuzzyMapB.computeIfAbsent(
						e.filenameHashStr + ":" + e.lang + ":" + normalizedPakName(manifestB, e.pakIndex),
						k -> new ArrayList<>()).add(e);

		Set<String> common = new HashSet<>(fuzzyMapA.keySet());
		common.retainAll(fuzzyMapB.keySet());

		for (String fk : common)
		{
			List<ManifestEntry> listA = fuzzyMapA.get(fk);
			List<ManifestEntry> listB = fuzzyMapB.get(fk);
			int pairs = Math.min(listA.size(), listB.size());
			for (int i = 0; i < pairs; i++)
			{
				ManifestEntry a = listA.get(i);
				ManifestEntry b = listB.get(i);
				String oldKey = config.getKeyStrategy().getKey(a);
				String newKey = config.getKeyStrategy().getKey(b);
				result.addEntry(new DiffEntry(ChangeType.CHANGED, a, b, oldKey, newKey,
						EnumSet.noneOf(MetadataFlag.class), resolveName(a)));
				removeEntry(mapA, oldKey, a, onlyInA);
				removeEntry(mapB, newKey, b, onlyInB);
			}
		}
	}

	private void removeKey(final Map<String, List<ManifestEntry>> map, final String key, final Set<String> keySet)
	{
		List<ManifestEntry> entries = map.get(key);
		if (entries == null)
			return;
		entries.remove(0);
		if (entries.isEmpty())
		{
			map.remove(key);
			keySet.remove(key);
		}
	}

	private void removeEntry(final Map<String, List<ManifestEntry>> map, final String key,
			final ManifestEntry entry, final Set<String> keySet)
	{
		List<ManifestEntry> entries = map.get(key);
		if (entries == null)
			return;
		entries.remove(entry);
		if (entries.isEmpty())
		{
			map.remove(key);
			keySet.remove(key);
		}
	}

	private void deepCompareKey(final DiffConfig config, final List<ManifestEntry> entriesA,
			final List<ManifestEntry> entriesB, final String key, final DiffResult result,
			final Manifest manifestA, final Manifest manifestB)
	{
		Map<Integer, ManifestEntry> byLangA = new HashMap<>();
		for (ManifestEntry e : entriesA)
			byLangA.put(e.lang, e);

		Set<Integer> matchedLangs = new HashSet<>();

		for (ManifestEntry bEntry : entriesB)
		{
			ManifestEntry aEntry = byLangA.get(bEntry.lang);
			if (aEntry == null)
				continue;

			matchedLangs.add(bEntry.lang);

			if (aEntry.shaStr.equals(bEntry.shaStr))
			{
				Set<MetadataFlag> flags = EnumSet.noneOf(MetadataFlag.class);
				ChangeType ct = ChangeType.UNCHANGED;

				if (config.isTrackPakMoves() && !normalizedPakName(manifestA, aEntry.pakIndex).equals(normalizedPakName(manifestB, bEntry.pakIndex)))
				{
					ct = ChangeType.MOVED;
					flags.add(MetadataFlag.PAK_CHANGED);
				}
				if (config.isTrackSizeChanges())
				{
					if (aEntry.size != bEntry.size)
						flags.add(MetadataFlag.SIZE_CHANGED);
					if (aEntry.compressedSize != bEntry.compressedSize)
						flags.add(MetadataFlag.COMPRESSED_SIZE_CHANGED);
					if (ct == ChangeType.UNCHANGED && !flags.isEmpty())
						ct = ChangeType.MOVED;
				}
				result.addEntry(new DiffEntry(ct, aEntry, bEntry, key, key, flags, resolveName(aEntry)));
			}
			else
			{
				Set<MetadataFlag> flags = EnumSet.noneOf(MetadataFlag.class);
				if (config.isTrackPakMoves() && !normalizedPakName(manifestA, aEntry.pakIndex).equals(normalizedPakName(manifestB, bEntry.pakIndex)))
					flags.add(MetadataFlag.PAK_CHANGED);
				if (config.isTrackSizeChanges())
				{
					if (aEntry.size != bEntry.size)
						flags.add(MetadataFlag.SIZE_CHANGED);
					if (aEntry.compressedSize != bEntry.compressedSize)
						flags.add(MetadataFlag.COMPRESSED_SIZE_CHANGED);
				}
				result.addEntry(new DiffEntry(ChangeType.CHANGED, aEntry, bEntry, key, key, flags, resolveName(aEntry)));
			}
		}

		for (ManifestEntry aEntry : entriesA)
		{
			if (!matchedLangs.contains(aEntry.lang))
			{
				result.addEntry(new DiffEntry(ChangeType.CHANGED, aEntry, null, key, key,
						EnumSet.of(MetadataFlag.LANG_REMOVED), resolveName(aEntry)));
			}
		}
		for (ManifestEntry bEntry : entriesB)
		{
			if (!matchedLangs.contains(bEntry.lang))
			{
				result.addEntry(new DiffEntry(ChangeType.CHANGED, null, bEntry, key, key,
						EnumSet.of(MetadataFlag.LANG_ADDED), resolveName(bEntry)));
			}
		}
	}

	private static List<ManifestEntry> flatten(final Map<String, List<ManifestEntry>> map, final Set<String> keys)
	{
		List<ManifestEntry> all = new ArrayList<>();
		for (String key : keys)
		{
			List<ManifestEntry> entries = map.get(key);
			if (entries != null)
				all.addAll(entries);
		}
		return all;
	}

	private static Map<String, List<ManifestEntry>> groupBySha(final List<ManifestEntry> entries)
	{
		Map<String, List<ManifestEntry>> map = new HashMap<>();
		for (ManifestEntry e : entries)
			map.computeIfAbsent(e.shaStr, k -> new ArrayList<>()).add(e);
		return map;
	}

	private static String resolveName(final ManifestEntry entry)
	{
		return org.imathrowback.manifest.NameDB.getNameForHash(entry.filenameHashStr, "");
	}

	private static String pakName(final Manifest manifest, final int pakIndex)
	{
		if (manifest == null || manifest.pakFiles == null || pakIndex < 0 || pakIndex >= manifest.pakFiles.size())
			return String.valueOf(pakIndex);
		return manifest.pakFiles.get(pakIndex).name;
	}

	private static String normalizedPakName(final Manifest manifest, final int pakIndex)
	{
		String name = pakName(manifest, pakIndex);
		return name.replaceAll("_\\d+(?=\\.)", "");
	}
}
