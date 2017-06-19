package org.imathrowback.manifest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import rift_extractor.PAKFile;
import rift_extractor.PAKFile.PAKEntry;

public class MainTest
{
	public static void main(final String args[]) throws IOException
	{
		PAKFile file = new PAKFile("L:\\downloads\\english_core_0.pak");
		for (PAKEntry entry : file.entries)
		{
			System.out.println("compressed size:" + entry.compressedSize);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			file.extract("70baa82e", bos);
			System.out.println(DigestUtils.sha1Hex(bos.toByteArray()));
		}
		if (true)
			return;
		for (Map.Entry<Integer, PatchInfo> x : RemotePAK.getPatches(ReleaseType.PTS).entrySet())
		{
			//if (x.getKey() == 1)
			{
				System.out.println(x);
				System.out.println(x.getValue().getEntry("assets64.manifest").get());
				//RemotePAK.downloadManifest(ReleaseType.PTS, x.getValue(), new File("assets64.manifest.cache"));

			}
		}
		//RemotePAK.extract(ReleaseType.PTS, 1, "assets64.manifest", "assets64.manifest");
		/*
		*/
	}
}
