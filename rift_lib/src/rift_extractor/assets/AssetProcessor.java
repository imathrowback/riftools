package rift_extractor.assets;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import com.google.common.io.LittleEndianDataInputStream;

import rift_extractor.util.Util;

public class AssetProcessor
{
	public static AssetDatabase buildDatabase(final Manifest manifest, final String assetDirectory) throws IOException
	{
		System.out.println("Building asset database");
		AssetDatabase assets = new AssetDatabase(manifest);
		File[] assetFiles = new File(assetDirectory).listFiles();
		if (assetFiles == null)
			throw new IllegalArgumentException("Unable to find files in the asset directory: " + assetDirectory);
		Stream.of(assetFiles).parallel().forEach(file -> {

			try
			{
				assets.add(buildAssetFileDatabase(manifest, file));
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		sanityCheck(assets);

		return assets;
	}

	private static void sanityCheck(final AssetDatabase assets)
	{
		Set<String> entrySet = new TreeSet<>();
		assets.getEntries().map(e -> e.strID).forEach(eid -> {
			if (!entrySet.add(eid) && false)
			{
				System.err.println("WARNING, ID ALREADY EXISTS:" + eid);
				assets.getAssetFiles().forEach(af -> {
					if (af.contains(eid))
						System.err.println("\t -> " + af.file + ":" + af.getEntry(eid));
				});
			}
		});

	}

	public static AssetFile buildAssetFileDatabase(final Manifest manifest, final File file) throws IOException
	{
		boolean debug = false;
		AssetFile assetFile = new AssetFile(file);
		if (false)
			if (file.getName().contains("assets.023"))
				debug = true;

		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new FileInputStream(file)))
		{
			byte[] magic = new byte[4];
			dis.readFully(magic);
			//System.out.println(new String(magic));
			int version = dis.readInt();
			int headersize = dis.readInt();
			int maxfiles = dis.readInt();
			int lastEntryIndex = dis.readInt();
			String ss = ("[" + file.getName() + "]: Version:" + version + " headerSize:" + headersize + ", maxFiles:"
					+ maxfiles + ", files:" + lastEntryIndex);
			if (debug)
				System.out.println(ss);
			// System.out.println("\t assets " + files + ", max:" + maxfiles);
			// FIXME: For some reason, using the "files" variable doesnt read the proper amount of actual files, deleted? renamed? moved?
			int actualFiles = 0;
			for (int i = 0; i < maxfiles; i++)
			{
				byte[] entry = new byte[44];
				dis.readFully(entry);

				try (LittleEndianDataInputStream bis = new LittleEndianDataInputStream(new ByteArrayInputStream(entry)))
				{
					byte[] id = new byte[8];
					bis.readFully(id);
					int offset = bis.readInt();
					int size1 = bis.readInt();
					int size2 = bis.readInt();
					int index = bis.readShort();
					int flag = bis.readShort(); //compressed?
					byte[] hash = new byte[20];
					bis.readFully(hash);
					if (offset == 0)
					{
						// entry was deleted? Corrupt? No longer exists?
						if (debug)
							System.out.println(
									"found zero offset entry for data entry " + i + ", entry:"
											+ Util.bytesToHexString(entry) + " @" + offset);
					} else
					{
						String idstr = Util.bytesToHexString(id);
						Set<String> namehashes = manifest.getFilenameHashesForID(idstr);

						AssetEntry entryX = new AssetEntry(id, offset, size1, size2, index, flag, hash, assetFile);
						if (debug)
							System.out.println("[" + i + "]:" + entryX);
						assetFile.addAsset(entryX);
						if (index == lastEntryIndex - 1 && debug)
							System.out.println(ss + ":" + entryX);
						actualFiles++;
					}

				}

			}
			//System.out.println("\tActual files:" + actualFiles);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetFile;
	}

}
