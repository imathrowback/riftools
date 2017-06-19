package rift_extractor.nif;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.io.LittleEndianDataInputStream;

public class NiDataStream extends NIFObject
{

	public int streamSize;
	public int streamClone;
	public LinkedList<Pair<Integer, Integer>> streamRegions;
	public byte[] streamData;
	public boolean streamable;
	public int elemStride;

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream dis)
			throws IOException
	{
		super.parse(file, base, dis);
		streamSize = dis.readInt();
		streamClone = dis.readInt();
		int numRegions = dis.readInt();
		streamRegions = new LinkedList<>();
		for (int i = 0; i < numRegions; i++)
		{
			streamRegions.add(Pair.of(dis.readInt(), dis.readInt()));
		}
		int numElements = dis.readInt();
		streamElems = new LinkedList<NifStreamElement>();
		elemStride = 0;
		for (int i = 0; i < numElements; i++)
		{
			int elemData = dis.readInt();
			NifStreamElement elem = new NifStreamElement((elemData & 0xFF0000) >> 16, (elemData & 0xFF00) >> 8,
					elemData & 0xFF, elemStride);
			elemStride += elem.count * elem.size;
			streamElems.add(elem);
		}

		streamData = new byte[streamSize];
		dis.read(streamData);
		streamable = dis.readUnsignedByte() > 0;

	}

}
