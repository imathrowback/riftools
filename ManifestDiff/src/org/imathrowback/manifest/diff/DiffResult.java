package org.imathrowback.manifest.diff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DiffResult
{
	private final Map<ChangeType, List<DiffEntry>> entriesByType;
	private int totalOld;
	private int totalNew;

	public DiffResult()
	{
		entriesByType = new EnumMap<>(ChangeType.class);
		for (ChangeType ct : ChangeType.values())
			entriesByType.put(ct, new ArrayList<>());
	}

	public void addEntry(final DiffEntry entry)
	{
		entriesByType.get(entry.getChangeType()).add(entry);
	}

	public void addAll(final List<DiffEntry> entries)
	{
		for (DiffEntry e : entries)
			addEntry(e);
	}

	public List<DiffEntry> getEntries(final ChangeType type)
	{
		return entriesByType.get(type);
	}

	public List<DiffEntry> getAdded()
	{
		return getEntries(ChangeType.ADDED);
	}

	public List<DiffEntry> getDeleted()
	{
		return getEntries(ChangeType.DELETED);
	}

	public List<DiffEntry> getChanged()
	{
		return getEntries(ChangeType.CHANGED);
	}

	public List<DiffEntry> getRenamed()
	{
		return getEntries(ChangeType.RENAMED);
	}

	public List<DiffEntry> getMoved()
	{
		return getEntries(ChangeType.MOVED);
	}

	public List<DiffEntry> getUnchanged()
	{
		return getEntries(ChangeType.UNCHANGED);
	}

	public List<DiffEntry> getAllEntries()
	{
		List<DiffEntry> all = new ArrayList<>();
		for (List<DiffEntry> list : entriesByType.values())
			all.addAll(list);
		return all;
	}

	public int getTotalOld()
	{
		return totalOld;
	}

	public void setTotalOld(final int totalOld)
	{
		this.totalOld = totalOld;
	}

	public int getTotalNew()
	{
		return totalNew;
	}

	public void setTotalNew(final int totalNew)
	{
		this.totalNew = totalNew;
	}

	public Map<ChangeType, List<DiffEntry>> getEntriesByType()
	{
		return Collections.unmodifiableMap(entriesByType);
	}
}
