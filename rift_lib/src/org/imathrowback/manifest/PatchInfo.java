package org.imathrowback.manifest;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PatchInfo implements Comparable<PatchInfo>
{
	ReleaseType release;

	public ReleaseType getRelease()
	{
		return release;
	}

	int index;
	String version;
	List<PatchManifestEntry> fileEntries = new LinkedList<>();
	static Comparator<PatchInfo> c = Comparator.comparingLong(PatchInfo::revCommit)
			.thenComparing(PatchInfo::revPatch)
			.thenComparingInt(PatchInfo::getIndex).thenComparing(PatchInfo::getRelease);

	/*
			Comparator.comparingLong(PatchInfo::revMajor)
			.thenComparingLong(PatchInfo::revMinor).thenComparing(PatchInfo::revPatch)
			.thenComparingLong(PatchInfo::revCommit);
	*/
	public PatchInfo(final ReleaseType release, final int index, final String version, final List<String> lines)
	{
		this.release = release;
		this.index = index;
		this.version = version;
		for (String line : lines)
		{
			String parts[] = line.split(":");
			fileEntries.add(new PatchManifestEntry(parts[0], parts[1], Long.valueOf(parts[2])));
		}
	}

	public int getIndex()
	{
		return index;
	}

	public List<PatchManifestEntry> getEntries()
	{
		return fileEntries;
	}

	public Optional<PatchManifestEntry> getEntry(final String name)
	{
		return fileEntries.stream().filter(e -> e.name.equals(name)).findFirst();
	}

	@Override
	public int compareTo(final PatchInfo o)
	{
		return c.compare(this, o);
	}

	public String getVersion()
	{
		return version;
	}

	@Override
	public String toString()
	{
		return version + "@" + index;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatchInfo other = (PatchInfo) obj;
		if (index != other.index)
			return false;
		if (version == null)
		{
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Long revMajor()
	{
		String[] parts = version.split("-");
		return Long.parseLong(parts[parts.length - 5]);
	}

	public Long revMinor()
	{
		String[] parts = version.split("-");
		return Long.parseLong(parts[parts.length - 4]);
	}

	public String revPatch()
	{
		String[] parts = version.split("-");
		return (parts[parts.length - 3]);
	}

	public Long revCommit()
	{
		String[] parts = version.split("-");
		return Long.parseLong(parts[parts.length - 2]);
	}
}
