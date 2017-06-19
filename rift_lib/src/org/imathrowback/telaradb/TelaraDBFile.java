package org.imathrowback.telaradb;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateParameters;
import org.apache.commons.lang3.tuple.Pair;
import com.google.common.io.LittleEndianDataInputStream;

public class TelaraDBFile implements TelaraDBInterface
{
	public class entry
	{
		public Long key;
		public Long id;
		public String name;
		public byte[] decompressedData;
	}

	Map<Long, Map<Long, entry>> entryMap = new TreeMap<>();

	public TelaraDBFile(String file)
	{

		try
		{
			byte[] data = java.nio.file.Files.readAllBytes(new File(file).toPath());
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			DeflateParameters params = new DeflateParameters();
			params.setWithZlibHeader(false);
			try (DeflateCompressorInputStream iis = new DeflateCompressorInputStream(bis, params))
			{
				try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new BufferedInputStream(iis)))
				{
					String checksum = readString(dis);
					int count = dis.readInt();
					for (int i = 0; i < count; i++)
					{
						entry e = new entry();
						e.id = dis.readLong();
						e.key = dis.readLong();
						e.name = readString(dis);
						int size = dis.readInt();
						e.decompressedData = new byte[size];
						dis.read(e.decompressedData);
						if (!entryMap.containsKey(e.id))
							entryMap.put(e.id, new TreeMap<>());
						Map<Long, entry> ds = entryMap.get(e.id);
						ds.put(e.key, e);
					}
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public static String readString(final LittleEndianDataInputStream raf) throws IOException
	{
		int length = read7BitEncodedInt(raf);
		byte[] buf = new byte[length];
		for (int i = 0; i < length; i++)
		{
			buf[i] = raf.readByte();
		}
		return new String(buf);

	}

	private static int read7BitEncodedInt(final LittleEndianDataInputStream raf) throws IOException
	{
		int i = 0;
		int j = 0;
		while (j != 35)
		{
			byte b = raf.readByte();
			i |= (b & 127) << (j & 31);
			j += 7;
			if ((b & 128) != 0)
			{
				continue;
			} else
			{
				return i;
			}
		}
		throw new IOException("Improper 7BitEncodedInt Read.");
	}

	@Override
	public Stream<Pair<Integer, Integer>> getIdsAndKeys()
	{
		java.util.stream.Stream.Builder<Pair<Integer, Integer>> entries = Stream.builder();
		for (Entry<Long, Map<Long, entry>> ds : entryMap.entrySet())
			for (Entry<Long, entry> entry : ds.getValue().entrySet())
				entries.add(Pair.of(entry.getValue().id.intValue(), entry.getValue().key.intValue()));
		return entries.build();
	}

	@Override
	public byte[] getData(final Integer datasetid, final Integer key)
	{
		return entryMap.get(datasetid.longValue()).get(key.longValue()).decompressedData;
	}

}
