package org.imathrowback.telaradbdiff.diff;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.imathrowback.telaradbdiff.diff.DbDiffEntry.ChangeType;

public class DbDiffResult
{
	private final Map<ChangeType, List<DbDiffEntry>> entriesByType;
	private int totalOld;
	private int totalNew;

	public DbDiffResult()
	{
		entriesByType = new EnumMap<>(ChangeType.class);
		for (ChangeType ct : ChangeType.values())
			entriesByType.put(ct, new ArrayList<>());
	}

	public void addEntry(final DbDiffEntry entry)
	{
		entriesByType.get(entry.getChangeType()).add(entry);
	}

	public void addAll(final List<DbDiffEntry> entries)
	{
		for (DbDiffEntry e : entries)
			addEntry(e);
	}

	public List<DbDiffEntry> getEntries(final ChangeType type)
	{
		return entriesByType.get(type);
	}

	public List<DbDiffEntry> getAdded() { return getEntries(ChangeType.ADDED); }
	public List<DbDiffEntry> getDeleted() { return getEntries(ChangeType.DELETED); }
	public List<DbDiffEntry> getChanged() { return getEntries(ChangeType.CHANGED); }

	public int getTotalOld() { return totalOld; }
	public void setTotalOld(final int totalOld) { this.totalOld = totalOld; }

	public int getTotalNew() { return totalNew; }
	public void setTotalNew(final int totalNew) { this.totalNew = totalNew; }

	public Map<ChangeType, List<DbDiffEntry>> getEntriesByType()
	{
		return entriesByType;
	}
}
