package org.imathrowback.telaradbdiff.diff;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DbDiffOutput
{
	public enum Format
	{
		TEXT,
		HTML
	}

	public static String format(final DbDiffResult result, final Format format)
	{
		switch (format)
		{
			case HTML:
				return DbHtmlFormatter.format(result);
			case TEXT:
			default:
				return formatText(result);
		}
	}

	private static String formatText(final DbDiffResult result)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("=== TelaraDB Diff Report ===\n");
		sb.append("Total A: ").append(result.getTotalOld()).append("\n");
		sb.append("Total B: ").append(result.getTotalNew()).append("\n");
		sb.append("Added:   ").append(result.getAdded().size()).append("\n");
		sb.append("Deleted: ").append(result.getDeleted().size()).append("\n");
		sb.append("Changed: ").append(result.getChanged().size()).append("\n\n");

		if (!result.getDeleted().isEmpty())
		{
			sb.append("--- Deleted ---\n");
			for (DbDiffEntry e : result.getDeleted())
				sb.append("  - ").append(e.getId()).append("_").append(e.getKey()).append("\n");
			sb.append("\n");
		}

		if (!result.getAdded().isEmpty())
		{
			sb.append("--- Added ---\n");
			for (DbDiffEntry e : result.getAdded())
				sb.append("  + ").append(e.getId()).append("_").append(e.getKey()).append("\n");
			sb.append("\n");
		}

		if (!result.getChanged().isEmpty())
		{
			sb.append("--- Changed ---\n");
			for (DbDiffEntry e : result.getChanged())
			{
				sb.append("  * ").append(e.getId()).append("_").append(e.getKey()).append("\n");
				for (FieldChange fc : e.getFieldChanges())
				{
					sb.append("      ").append(fc.toString()).append("\n");
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void writeReport(final DbDiffResult result, final Format format, final File outFile)
			throws Exception
	{
		String report = format(result, format);
		Files.write(Paths.get(outFile.toURI()), report.getBytes("UTF-8"));
	}
}
