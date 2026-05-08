package org.imathrowback.manifest.diff;

import java.util.EnumSet;
import java.util.Set;

import rift_extractor.assets.ManifestEntry;

public class DiffEntry
{
	private final ChangeType changeType;
	private final ManifestEntry entryOld;
	private final ManifestEntry entryNew;
	private final String oldKey;
	private final String newKey;
	private final Set<MetadataFlag> metadataFlags;
	private final String resolvedFilename;

	public DiffEntry(final ChangeType changeType, final ManifestEntry entryOld, final ManifestEntry entryNew,
			final String oldKey, final String newKey, final Set<MetadataFlag> metadataFlags,
			final String resolvedFilename)
	{
		this.changeType = changeType;
		this.entryOld = entryOld;
		this.entryNew = entryNew;
		this.oldKey = oldKey;
		this.newKey = newKey;
		this.metadataFlags = metadataFlags != null ? metadataFlags : EnumSet.noneOf(MetadataFlag.class);
		this.resolvedFilename = resolvedFilename;
	}

	public ChangeType getChangeType()
	{
		return changeType;
	}

	public ManifestEntry getEntryOld()
	{
		return entryOld;
	}

	public ManifestEntry getEntryNew()
	{
		return entryNew;
	}

	public String getOldKey()
	{
		return oldKey;
	}

	public String getNewKey()
	{
		return newKey;
	}

	public Set<MetadataFlag> getMetadataFlags()
	{
		return metadataFlags;
	}

	public String getResolvedFilename()
	{
		return resolvedFilename;
	}

	public boolean hasFlag(final MetadataFlag flag)
	{
		return metadataFlags.contains(flag);
	}
}
