package rift_extractor.nif;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.io.LittleEndianDataInputStream;

public class NifMeshStream
{

	int streamLinkID;
	boolean instanced;
	public LinkedList<Integer> submeshRegionMap;
	public LinkedList<Pair<String, Integer>> elementDescs;

	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		streamLinkID = ds.readInt();
		instanced = ds.readUnsignedByte() > 0;
		int numStreamSubmeshRegionMapEntries = ds.readUnsignedShort();
		submeshRegionMap = new LinkedList<Integer>();
		for (int i = 0; i < numStreamSubmeshRegionMapEntries; i++)
			submeshRegionMap.add(ds.readUnsignedShort());
		int numElementDescs = ds.readInt();
		elementDescs = new LinkedList<>();
		for (int i = 0; i < numElementDescs; i++)
		{
			int descNameIndex = ds.readInt();
			String descName = file.getStringFromTable(descNameIndex);
			int descIndex = ds.readInt();
			elementDescs.add(Pair.of(descName, descIndex));
		}
	}
}
