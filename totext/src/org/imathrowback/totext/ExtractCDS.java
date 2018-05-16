package org.imathrowback.totext;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
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

	public static void CDStoText(final File file, final File cdstxt, final String delim, final boolean convertNewLines)
			throws Exception
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
		List<CDEntry> entries = new ArrayList<>();
		for (int i = 0; i < entryCount; i++)
		{
			int key = diss.readInt();
			int byteOffsetFromStartOfEntries = Leb128.readUnsignedLeb128_X(diss).get();
			entries.add(new CDEntry(key, byteOffsetFromStartOfEntries));
		}
		int writeCount = 0;
		HuffmanReader reader = new HuffmanReader(freqData);
		System.out.println("Writing text entries to " + cdstxt);
		// Read each chunk of data
		try (PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(cdstxt), Charset.forName("UTF-8"))))
		{

			for (int i = 0; i < entryCount; i++)
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
					writeCount++;
					for (_7709 o : c.map.values())
					{
						String text = o.name;
						if (convertNewLines)
							text = text.replaceAll("\n", " ").replaceAll("\r", " ");
						writer.println(entry.key + delim + text);
					}
				} catch (Exception ex)
				{
					System.err.println("Unable to process 7707 for entry[" + i + "] ->" + ex.getMessage());
					File tfile = File.createTempFile("failed", ".dat");
					try (FileOutputStream fos = new FileOutputStream(tfile))
					{
						IOUtils.write(dataOut, fos);
					}
					System.err.println("wrote debug data to " + tfile);
					//throw ex;
				}
			}

		}
		System.out.println("done, wrote " + writeCount);
	}
}
