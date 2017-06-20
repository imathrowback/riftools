package rift_extractor.assets;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.tukaani.xz.LZMA2InputStream;

import com.google.common.io.LittleEndianDataInputStream;
import rift_extractor.util.Util;

public class PAKFile
{
	public List<PAKEntry> entries = new LinkedList<>();
	byte[] data;

	//String file;
	public boolean canExtract()
	{
		return data != null;
	}

	public void extract(final String hash, final OutputStream stream) throws IOException
	{
		List<PAKEntry> entries = getEntries(hash).collect(Collectors.toList());
		if (entries.size() != 1)
			throw new IllegalStateException("expected 1 entry for hash[" + hash + "], got " + entries.size());
		PAKEntry e = entries.get(0);
		try (InputStream fis = new ByteArrayInputStream(data))
		{
			fis.skip(e.offset);
			byte[] data = new byte[e.compressedSize];
			int bytes = fis.read(data);
			System.out.println("read:" + bytes);
			if (e.compressedSize != e.uncompressedSize)
			{
				ByteArrayInputStream bis = new ByteArrayInputStream(data);
				// skip one byte, it contains dictionary size and other flags we don't care about.
				int flags = bis.read();
				try (InputStream iis = new LZMA2InputStream(bis, e.uncompressedSize))
				{
					IOUtils.copy(iis, stream);
				}
			} else
				org.apache.commons.io.IOUtils.write(data, stream);
			stream.flush();
		}
	}

	private Stream<PAKEntry> getEntries(final String hash)
	{

		return entries.stream().filter(e -> e.filenameHashStr.equals(hash));
	}

	public PAKFile(final String file) throws IOException
	{
		this(new FileInputStream(file), true);
	}

	public PAKFile(final InputStream is) throws IOException
	{
		this(is, true);
	}

	/**
	 * A PAK file can be in two different states, one that allows extraction of files from the pak file and one that does not. By not allowing extraction
	 * you don't need to read the entire file, you only need to read the header.
	 *
	 * @param is
	 * @param allowExtraction
	 * @throws IOException
	 */
	public PAKFile(final InputStream is, final boolean allowExtraction) throws IOException
	{

		if (allowExtraction)
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			IOUtils.copy(is, bos);
			data = bos.toByteArray();
			process(new ByteArrayInputStream(data));
		} else
		{
			process(is);
		}
	}

	public PAKFile(final PAKHeader header, final InputStream is) throws IOException
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is))
		{
			processEntries(dis, header.numEntries);
		}
	}

	public static PAKHeader readPAKHeader(final InputStream is) throws IOException
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is))
		{
			return new PAKHeader(dis);
		}
	}

	private void process(final InputStream is) throws IOException
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is))
		{
			PAKHeader header = new PAKHeader(dis);
			processEntries(dis, header.numEntries);
		}
	}

	private void processEntries(final LittleEndianDataInputStream dis, final int entries) throws IOException
	{

		for (int i = 0; i < entries; i++)
		{
			//byte[] unk1 = new byte[20];
			//dis.read(unk1);
			int a = dis.readInt();
			int b = dis.readInt();
			int c = dis.readInt();
			//int d = dis.readInt();
			byte[] filenameHash = new byte[4];
			dis.read(filenameHash);

			ArrayUtils.reverse(filenameHash);
			int e = dis.readInt();
			int csize = dis.readInt();
			int size = dis.readInt();
			int unk2 = dis.readInt();
			int offset = dis.readInt();

			byte[] unk3 = new byte[24]; // appears to always be zero?
			dis.read(unk3);
			if (offset != 0)
			{
				//				if (i = 0)

				PAKEntry entry = new PAKEntry();
				entry.compressedSize = csize;
				entry.uncompressedSize = size;
				entry.offset = offset;
				entry.filenameHash = ArrayUtils.clone(filenameHash);
				entry.filenameHashStr = Util.bytesToHexString(filenameHash);
				this.entries.add(entry);
				entry.str = ("[a]" + a + "[b]" + b + "[c]" + c + "[filename]" + Util.bytesToHexString(filenameHash)
						+ "[e]" + e
						+ "[csize]" + csize
						+ ":[size]" + size + ":[unk2]" + unk2 + ":[offset]" + offset + ":[unk]"
						+ Util.bytesToHexString(unk3));
			}
		}

	}

	public boolean containsFilenameHash(final String filenameHashStr)
	{
		return entries.stream().anyMatch(p -> p.filenameHashStr.equals(filenameHashStr));
	}
}