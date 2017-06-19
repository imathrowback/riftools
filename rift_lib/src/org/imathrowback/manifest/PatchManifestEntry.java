package org.imathrowback.manifest;

public class PatchManifestEntry
{
	public PatchManifestEntry(final String name, final String hash, final Long size)
	{
		this.name = name;
		this.hash = hash;
		this.size = size;
	}

	public String name;
	public String hash;
	public Long size;

	@Override
	public String toString()
	{
		return name + ":" + hash + ":" + size;
	}
}
