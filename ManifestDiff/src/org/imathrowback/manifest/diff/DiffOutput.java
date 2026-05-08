package org.imathrowback.manifest.diff;

import java.util.List;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.util.Util;

public class DiffOutput
{
	public enum Format
	{
		TEXT,
		JSON,
		HTML
	}

	public static String format(final DiffResult result, final Format format, final boolean header,
			final boolean showPak, final boolean verbose,
			final Manifest manifestA, final Manifest manifestB)
	{
		switch (format)
		{
		case JSON:
			return formatJson(result, manifestA, manifestB);
		case HTML:
			return HtmlFormatter.format(result, showPak, manifestA, manifestB);
		case TEXT:
		default:
			return formatText(result, header, showPak, verbose, manifestA, manifestB);
		}
	}

	private static String formatText(final DiffResult result, final boolean header,
			final boolean showPak, final boolean verbose,
			final Manifest manifestA, final Manifest manifestB)
	{
		StringBuilder sb = new StringBuilder();

		if (header)
			sb.append("change|filename|filenamehash|assetid|lang").append(showPak ? "|pakIndex" : "").append("\n");

		for (DiffEntry entry : result.getDeleted())
			sb.append(formatLine("-", entry, null, showPak, verbose, manifestA));
		for (DiffEntry entry : result.getAdded())
			sb.append(formatLine("+", entry, null, showPak, verbose, manifestB));
		for (DiffEntry entry : result.getChanged())
			sb.append(formatLine("*", entry, entry.getMetadataFlags().toString(), showPak, verbose, manifestA, manifestB));
		for (DiffEntry entry : result.getRenamed())
		{
			String name = formatName(entry);
			if (verbose)
				sb.append("[rename]:").append(formatName(entry.getEntryOld())).append(" -> ").append(name).append("\n");
			else
				sb.append("~|").append(formatName(entry.getEntryOld())).append("->").append(name).append("|")
						.append(Util.bytesToHexString(entry.getEntryNew().filenameHash)).append(":")
						.append(entry.getEntryNew().idStr).append(":").append(entry.getEntryNew().lang)
						.append(getPak(entry.getEntryNew(), showPak, manifestB)).append("\n");
		}
		for (DiffEntry entry : result.getMoved())
			sb.append(formatLine(">", entry, entry.getMetadataFlags().toString(), showPak, verbose, manifestA, manifestB));

		return sb.toString();
	}

	private static String formatLine(final String prefix, final DiffEntry entry, final String meta,
			final boolean showPak, final boolean verbose,
			final Manifest manifest)
	{
		return formatLine(prefix, entry, meta, showPak, verbose, manifest, manifest);
	}

	private static String formatLine(final String prefix, final DiffEntry entry, final String meta,
			final boolean showPak, final boolean verbose,
			final Manifest manifestA, final Manifest manifestB)
	{
		ManifestEntry ne = entry.getEntryNew() != null ? entry.getEntryNew() : entry.getEntryOld();
		String name = formatName(entry);

		if (verbose)
			return "[" + prefix + "]:" + name + "|" + ne + ":" + pakName(manifestB, ne.pakIndex)
					+ (meta != null ? " " + meta : "") + "\n";

		String line = prefix + "|" + name + "|" + Util.bytesToHexString(ne.filenameHash) + ":" + ne.idStr + ":"
				+ ne.lang + getPak(ne, showPak, manifestB);
		if (meta != null && !meta.equals("[]"))
			line += " " + meta;
		return line + "\n";
	}

	private static String formatName(final DiffEntry entry)
	{
		String name = entry.getResolvedFilename();
		if (name.isEmpty())
		{
			ManifestEntry ne = entry.getEntryNew() != null ? entry.getEntryNew() : entry.getEntryOld();
			if (ne != null)
				name = ne.filenameHashStr;
		}
		return name;
	}

	static String formatName(final ManifestEntry entry)
	{
		return org.imathrowback.manifest.NameDB.getNameForHash(entry.filenameHashStr, "");
	}

	private static String getPak(final ManifestEntry entry, final boolean showPak, final Manifest manifest)
	{
		return showPak ? ":" + pakName(manifest, entry.pakIndex) : "";
	}

	private static String pakName(final Manifest manifest, final int pakIndex)
	{
		if (manifest == null || manifest.pakFiles == null || pakIndex < 0 || pakIndex >= manifest.pakFiles.size())
			return String.valueOf(pakIndex);
		return manifest.pakFiles.get(pakIndex).name;
	}

	private static String formatJson(final DiffResult result, final Manifest manifestA, final Manifest manifestB)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");

		sb.append("  \"stats\": {\n");
		sb.append("    \"totalOld\": ").append(result.getTotalOld()).append(",\n");
		sb.append("    \"totalNew\": ").append(result.getTotalNew()).append(",\n");
		sb.append("    \"added\": ").append(result.getAdded().size()).append(",\n");
		sb.append("    \"deleted\": ").append(result.getDeleted().size()).append(",\n");
		sb.append("    \"changed\": ").append(result.getChanged().size()).append(",\n");
		sb.append("    \"renamed\": ").append(result.getRenamed().size()).append(",\n");
		sb.append("    \"moved\": ").append(result.getMoved().size()).append("\n");
		sb.append("  },\n");

		sb.append("  \"added\": [\n");
		appendJsonEntries(sb, result.getAdded(), manifestB);
		sb.append("  ],\n");

		sb.append("  \"deleted\": [\n");
		appendJsonEntries(sb, result.getDeleted(), manifestA);
		sb.append("  ],\n");

		sb.append("  \"changed\": [\n");
		appendJsonChangedEntries(sb, result.getChanged(), manifestA, manifestB);
		sb.append("  ],\n");

		sb.append("  \"renamed\": [\n");
		appendJsonRenamedEntries(sb, result.getRenamed());
		sb.append("  ],\n");

		sb.append("  \"moved\": [\n");
		appendJsonEntries(sb, result.getMoved(), manifestB);

		sb.append("  ]\n");
		sb.append("}\n");
		return sb.toString();
	}

	private static void appendJsonEntries(final StringBuilder sb, final List<DiffEntry> entries,
			final Manifest manifest)
	{
		boolean first = true;
		for (DiffEntry entry : entries)
		{
			if (!first)
				sb.append(",\n");
			first = false;
			ManifestEntry ne = getDisplayEntry(entry);
			sb.append("    {");
			jsonField(sb, "name", formatName(entry));
			sb.append(", ");
			jsonField(sb, "hash", Util.bytesToHexString(ne.filenameHash));
			sb.append(", ");
			jsonField(sb, "id", ne.idStr);
			sb.append(", \"lang\": ").append(ne.lang);
			sb.append(", \"pak\": \"").append(escapeJson(pakName(manifest, ne.pakIndex))).append("\"");
			sb.append("}");
		}
		if (!first)
			sb.append("\n");
	}

	private static void appendJsonChangedEntries(final StringBuilder sb, final List<DiffEntry> entries,
			final Manifest manifestA, final Manifest manifestB)
	{
		boolean first = true;
		for (DiffEntry entry : entries)
		{
			if (!first)
				sb.append(",\n");
			first = false;
			sb.append("    {");
			jsonField(sb, "name", formatName(entry));
			if (entry.getEntryOld() != null)
			{
				sb.append(", ");
				jsonField(sb, "oldSha", entry.getEntryOld().shaStr);
				sb.append(", \"oldPak\": \"").append(escapeJson(pakName(manifestA, entry.getEntryOld().pakIndex))).append("\"");
			}
			if (entry.getEntryNew() != null)
			{
				sb.append(", ");
				jsonField(sb, "newSha", entry.getEntryNew().shaStr);
				sb.append(", \"newPak\": \"").append(escapeJson(pakName(manifestB, entry.getEntryNew().pakIndex))).append("\"");
			}
			if (!entry.getMetadataFlags().isEmpty())
			{
				sb.append(", \"flags\": [");
				boolean ffirst = true;
				for (MetadataFlag f : entry.getMetadataFlags())
				{
					if (!ffirst)
						sb.append(", ");
					ffirst = false;
					sb.append("\"").append(f.name()).append("\"");
				}
				sb.append("]");
			}
			sb.append("}");
		}
		if (!first)
			sb.append("\n");
	}

	private static void appendJsonRenamedEntries(final StringBuilder sb, final List<DiffEntry> entries)
	{
		boolean first = true;
		for (DiffEntry entry : entries)
		{
			if (!first)
				sb.append(",\n");
			first = false;
			sb.append("    {");
			sb.append("\"oldName\": \"").append(escapeJson(formatName(entry.getEntryOld()))).append("\"");
			sb.append(", \"newName\": \"").append(escapeJson(formatName(entry.getEntryNew()))).append("\"");
			sb.append(", \"sha\": \"").append(entry.getEntryNew().shaStr).append("\"");
			sb.append("}");
		}
		if (!first)
			sb.append("\n");
	}

	private static void jsonField(final StringBuilder sb, final String name, final String value)
	{
		sb.append("\"").append(name).append("\": \"").append(escapeJson(value)).append("\"");
	}

	private static String escapeJson(final String s)
	{
		if (s == null)
			return "";
		return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r")
				.replace("\t", "\\t");
	}

	private static ManifestEntry getDisplayEntry(final DiffEntry entry)
	{
		ManifestEntry ne = entry.getEntryNew();
		if (ne != null)
			return ne;
		return entry.getEntryOld();
	}
}
