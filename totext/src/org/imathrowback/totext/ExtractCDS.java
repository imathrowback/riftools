package org.imathrowback.totext;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.datparser.classes._7707;
import org.imathrowback.datparser.classes._7709;
import com.google.common.io.LittleEndianDataInputStream;
import Huffman.magleo.HuffmanReader;
import rift_extractor.util.Leb128;

public class ExtractCDS
{
	static class CDEntry
	{
		public CDEntry(final int key2, final int byteOffsetFromStartOfEntries)
		{
			key = key2;
			offset = byteOffsetFromStartOfEntries;
		}

		_7707 obj;
		int key;
		int offset;
	}

	public static void CDStoText(final File file, final File cdstxt) throws Exception
	{
		long size = file.length();
		CountingInputStream cis = new CountingInputStream(new FileInputStream(file));
		LittleEndianDataInputStream diss = new LittleEndianDataInputStream(cis);
		long entryCount = diss.readInt();
		System.out.println("Reading " + file);
		System.out.println("found entries:" + entryCount);
		int t = 0;
		byte[] freqData = new byte[1024];
		diss.read(freqData);

		// now decide LEB128 data
		List<CDEntry> entries = new LinkedList<>();
		for (int i = 0; i < entryCount; i++)
		{
			// this "key" is used as a seed into a random number generator to do... i'm not sure.. possibly some kind of hash table.
			//byte[] key = new byte[4];
			//diss.read(key);

			int key = diss.readInt();
			int byteOffsetFromStartOfEntries = Leb128.readUnsignedLeb128_X(diss).get();
			entries.add(new CDEntry(key, byteOffsetFromStartOfEntries));
			if (i < 15)
			//key == 1790678880 || keyvalue == 1790678880)
			{
				//System.out.println("[" + i + "]: key[" + key + "]:" + byteOffsetFromStartOfEntries);
			}
		}

		HuffmanReader reader = new HuffmanReader(freqData);
		System.out.println("Writing text entries to " + cdstxt);
		//if (true)
		//	return;
		// Read each chunk of data
		try (PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(cdstxt), Charset.forName("UTF-8"))))
		{
			long startOffset = cis.getCount();
			for (int i = 0; i < entryCount; i++)
			//int i = 0;
			{
				CDEntry entry = entries.get(i);

				int compressedSize = Leb128.readUnsignedLeb128_X(diss).get();
				int decompressedSize = Leb128.readUnsignedLeb128_X(diss).get();
				byte[] data = new byte[compressedSize];
				diss.readFully(data);

				byte[] dataOut = new byte[decompressedSize];

				reader.decompress(data, compressedSize, dataOut, decompressedSize);

				CObject obj = DatParser.processFileAndObject(new ByteArrayInputStream(dataOut));
				try
				{
					_7707 c = new _7707();
					c.parse(obj);
					entry.obj = c;
					for (_7709 o : c.map.values())
						writer.println(entry.key + ":" + o.name);
					/*
					for (_7709 o : c.map.values())
					{
						if (o.name != null)
							if (o.name.toLowerCase().contains("snow place to go"))
							{
								XStream xstr = new XStream();
								xstr.processAnnotations(CObject.class);
								xstr.toXML(obj, System.out);
							}
					}
					*/
				} catch (Exception ex)
				{
					/*
					System.out.println("failed parse[" + i + "]");
					XStream xstr = new XStream();
					xstr.processAnnotations(CObject.class);
					xstr.toXML(obj, System.out);
					ex.printStackTrace();
					*/
					return;
				}
			}

		}

		//		XStream xstr = new XStream();
		//		xstr.processAnnotations(CObject.class);
		//		xstr.toXML(obj, System.out);
		System.out.println("done");
	}
}
