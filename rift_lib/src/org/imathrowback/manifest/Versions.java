package org.imathrowback.manifest;

import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

public class Versions
{
	public static PatchInfo getVersion(final int index, final boolean _is64) throws IOException
	{
		TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
		for (ReleaseType t : ReleaseType.values())
			sortedPatches.addAll(RemotePAK.getPatches(t, _is64).values());

		if (index == 1)
			return sortedPatches.last();
		else
			return sortedPatches.lower(sortedPatches.last());
	}

	public static void printVersions(final boolean _is64) throws Exception
	{
		System.out.println("64 bit:" + _is64);
		TreeMap<Integer, PatchInfo> patches = RemotePAK.getPatches(ReleaseType.LIVE, _is64);
		System.out.println("LIVE Patch depot:" + patches);
		System.out.println("LIVE Patch:" + RemotePAK.getCurrentPatch(patches).getVersion());
		patches = RemotePAK.getPatches(ReleaseType.PTS, _is64);
		System.out.println("PTS Patch depot:" + patches);
		System.out.println("PTS Patch:" + RemotePAK.getCurrentPatch(patches).getVersion());

	}

	public static void main(final String args[]) throws Exception
	{
		printVersions(true);
		printVersions(false);

	}
}
