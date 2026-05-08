package org.imathrowback.telaradbdiff.diff;

import java.util.Collections;
import java.util.List;

import org.imathrowback.datparser.CObject;

public class DbDiffEntry
{
	public enum ChangeType
	{
		ADDED,
		DELETED,
		CHANGED
	}

	private final int id;
	private final int key;
	private final ChangeType changeType;
	private final CObject objectOld;
	private final CObject objectNew;
	private final List<FieldChange> fieldChanges;
	private final byte[] rawData;

	public DbDiffEntry(final int id, final int key, final ChangeType changeType,
			final CObject objectOld, final CObject objectNew,
			final List<FieldChange> fieldChanges, final byte[] rawData)
	{
		this.id = id;
		this.key = key;
		this.changeType = changeType;
		this.objectOld = objectOld;
		this.objectNew = objectNew;
		this.fieldChanges = fieldChanges != null ? fieldChanges : Collections.emptyList();
		this.rawData = rawData;
	}

	public int getId() { return id; }
	public int getKey() { return key; }
	public ChangeType getChangeType() { return changeType; }
	public CObject getObjectOld() { return objectOld; }
	public CObject getObjectNew() { return objectNew; }
	public List<FieldChange> getFieldChanges() { return fieldChanges; }
	public byte[] getRawData() { return rawData; }

	@Override
	public String toString()
	{
		return changeType + " " + id + "_" + key;
	}
}
