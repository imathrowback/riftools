package rift_extractor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import com.google.common.io.LittleEndianDataInputStream;
import Huffman.magleo.HuffmanReader;
import rift_extractor.classgen.classes.TextEntry;
import rift_extractor.util.Leb128;

class CDEntry
{
	public CDEntry(final int key2, final int byteOffsetFromStartOfEntries)
	{
		key = key2;
		offset = byteOffsetFromStartOfEntries;
	}

	int key;
	int offset;
	public byte[] cdata;

	private String str;

	public String getText()
	{
		if (str != null)
			return str;

		try
		{
			CObject obj = DatParser.processFileAndObject(new ByteArrayInputStream(cdata));
			str = "" + obj.get(0).get(1).get(0).convert();
		} catch (Exception ex)
		{
			str = "";
		}
		cdata = null;
		return str;
	}
}

public class EnglishLang
{
	ArrayList<CDEntry> entries;
	Map<Integer, CDEntry> keyMap = new TreeMap<>();

	public String getText(final int key)
	{
		if (keyMap.containsKey(key))
			return keyMap.get(key).getText();
		return null;
	}

	public EnglishLang(final byte[] langdata) throws Exception
	{

		LittleEndianDataInputStream diss = new LittleEndianDataInputStream(new ByteArrayInputStream(langdata));

		long entryCount = diss.readInt();
		byte[] freqData = new byte[1024];
		diss.read(freqData);

		entries = new ArrayList<CDEntry>((int) entryCount);
		for (int i = 0; i < entryCount; i++)
		{
			int key = diss.readInt();
			int byteOffsetFromStartOfEntries = Leb128.readUnsignedLeb128_X(diss).get();
			entries.add(new CDEntry(key, byteOffsetFromStartOfEntries));
		}

		HuffmanReader reader = new HuffmanReader(freqData);

		for (int i = 0; i < entryCount; i++)
		{
			CDEntry entry = entries.get(i);

			int compressedSize = Leb128.readUnsignedLeb128_X(diss).get();
			int decompressedSize = Leb128.readUnsignedLeb128_X(diss).get();
			byte[] data = new byte[compressedSize];
			diss.readFully(data);

			byte[] dataOut = new byte[decompressedSize];
			reader.decompress(data, compressedSize, dataOut, decompressedSize);
			entry.cdata = dataOut;
			keyMap.put(entry.key, entry);
			entries.set(i, null);
		}
		entries = null;

	}

	public String getText(final TextEntry unk28)
	{
		if (unk28 == null)
			return "";
		return getText(unk28.unk0);
	}
}