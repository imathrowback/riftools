package rift_extractor.detector;

import java.io.FileOutputStream;

import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetEntry;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.util.Util;

public class SimpleExtract
{
	public static void main(final String args[]) throws Exception
	{
		String riftPath = "L:\\SteamStuff\\Steam2\\steamapps\\common\\rift";
		Manifest manifest = new Manifest(riftPath + "\\" + "assets.manifest");
		AssetDatabase database = AssetProcessor.buildDatabase(manifest, riftPath + "\\assets\\");

		AssetEntry entry = database.getEntryForID(Util.hexStringToBytes("e922efafdd22d065"));
		try (FileOutputStream fos = new FileOutputStream("mac2"))
		{
			fos.write(database.extract(entry));
		}

	}
}
