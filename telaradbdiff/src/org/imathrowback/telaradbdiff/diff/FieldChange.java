package org.imathrowback.telaradbdiff.diff;

public class FieldChange
{
	public enum ChangeType
	{
		ADDED,
		REMOVED,
		CHANGED
	}

	private final String path;
	private final String fieldName;
	private final Object oldValue;
	private final Object newValue;
	private final ChangeType changeType;

	public FieldChange(final String path, final String fieldName, final Object oldValue, final Object newValue,
			final ChangeType changeType)
	{
		this.path = path;
		this.fieldName = fieldName;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.changeType = changeType;
	}

	public String getPath() { return path; }
	public String getFieldName() { return fieldName; }
	public Object getOldValue() { return oldValue; }
	public Object getNewValue() { return newValue; }
	public ChangeType getChangeType() { return changeType; }

	@Override
	public String toString()
	{
		switch (changeType)
		{
			case ADDED:
				return "+ " + path + " = " + newValue;
			case REMOVED:
				return "- " + path + " = " + oldValue;
			case CHANGED:
				return "* " + path + ": " + oldValue + " -> " + newValue;
			default:
				return path + ": " + oldValue + " -> " + newValue;
		}
	}
}
