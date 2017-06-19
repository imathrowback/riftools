package rift_extractor;

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
	public class PAKEntry
	{
		public int offset;
		public int compressedSize;
		public int uncompressedSize;
		public byte[] filenameHash;
		public String filenameHashStr;
	}

	public List<PAKEntry> entries = new LinkedList<>();
	byte[] data;
	//String file;

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
		this(new FileInputStream(file));
	}

	public PAKFile(final InputStream is) throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		IOUtils.copy(is, bos);
		data = bos.toByteArray();
		process();
	}

	private void process() throws IOException
	{
		LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data));

		int version = dis.readInt();
		int pakfileSize = dis.readInt();
		int headerSize = dis.readInt();
		int entrySize = dis.readInt();

		int entries = entrySize / 60;

		System.out.println(version);
		System.out.println(pakfileSize);
		System.out.println(headerSize);
		System.out.println(entrySize);
		System.out.println(entries);

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
				System.out
						.println("[a]" + a + "[b]" + b + "[c]" + c + "[d]" + Util.bytesToHexString(filenameHash)
								+ "[e]" + e
								+ "[csize]" + csize
								+ ":[size]" + size + ":[unk2]" + unk2 + ":[offset]" + offset + ":[unk]"
								+ Util.bytesToHexString(unk3));

				PAKEntry entry = new PAKEntry();
				entry.compressedSize = csize;
				entry.uncompressedSize = size;
				entry.offset = offset;
				entry.filenameHash = ArrayUtils.clone(filenameHash);
				entry.filenameHashStr = Util.bytesToHexString(filenameHash);
				this.entries.add(entry);
			}
		}

	}
}