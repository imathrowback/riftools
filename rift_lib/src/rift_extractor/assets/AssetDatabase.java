package rift_extractor.assets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import rift_extractor.util.Util;

/** An asset database that can map asset ID's with filename hashes */
public class AssetDatabase
{
	List<AssetFile> assets = new LinkedList<>();
	Manifest manifest;
	boolean is64;

	protected AssetDatabase(final Manifest manifest)
	{
		is64 = manifest.getIs64();
		this.manifest = manifest;
	}

	public Manifest getManifest()
	{
		return manifest;
	}

	public List<AssetFile> getAssetFiles()
	{
		return assets;
	}

	synchronized void add(final AssetFile assetFile)
	{
		assets.add(assetFile);
	}

	public Stream<AssetEntry> getEntries()
	{
		Stream<AssetEntry> entries = Stream.empty();
		for (AssetFile file : assets)
		{
			entries = Stream.concat(entries, file.getEntries());
		}
		return entries.sorted(Comparator.comparing(e -> e.strID));

	}

	private AssetFile findAssetFileForID(final byte[] id)
	{
		return findAssetFileForID(Util.bytesToHexString(id));
	}

	private AssetFile findAssetFileForID(final String id)
	{
		if (id == null)
			return null;
		LinkedList<AssetFile> holders = new LinkedList<>();
		for (AssetFile file : assets)
			if (file.contains(id))
				holders.add(file);
		if (holders.isEmpty())
			return null;
		//if (holders.size() > 1)
		//	System.err.println("WARN: More than one asset file found containing id " + id);

		if (holders.size() > 1)
		{
			// we have a 32 and 64 bit one pick the right one
			AssetFile f_32 = holders.stream().filter(f -> !f.is64).findFirst().get();
			AssetFile f_64 = holders.stream().filter(f -> f.is64).findFirst().get();
			if (is64)
				return f_64;
			return f_32;
		}

		return holders.getFirst();
	}

	public AssetFile getAssetFileContainingFilename(final String filename)
	{
		String id = Util.findIDAsStrInManifestForFileName(filename, manifest);
		if (id != null)
		{
			AssetFile assetFile = findAssetFileForID(id);
			return assetFile;
		}
		return null;

	}

	public AssetEntry getEntryForFileNameHash(final String filenameHash)
	{
		String id = manifest.filenameHashToID(filenameHash);
		if (id == null)
			throw new IllegalArgumentException("Filename hash not found: '" + filenameHash + "'");
		AssetFile assetFile = findAssetFileForID(id);
		if (assetFile == null)
			throw new IllegalArgumentException(
					"Filename hash found in manifest but unable to locate ID[" + id + "] in assets: '" + filenameHash
							+ "'");
		return assetFile.getEntry(id);
	}

	public boolean filenameExists(final String filename)
	{
		try
		{
			String id = Util.findIDAsStrInManifestForFileName(filename, manifest);
			return id != null;
		} catch (Exception ex)
		{
			return false;
		}
	}

	public AssetEntry getEntryForFileName(final String filename)
	{
		String id = Util.findIDAsStrInManifestForFileName(filename, manifest);
		if (id == null)
			throw new IllegalArgumentException("Filename hash not found: '" + filename + "'");
		AssetFile assetFile = findAssetFileForID(id);
		if (assetFile == null)
			throw new IllegalArgumentException(
					"Filename hash found in manifest but unable to locate ID[" + id + "] in assets: '" + filename
							+ "'");
		return assetFile.getEntry(id);
	}

	/** Attempt to extract the asset with the given filename */
	public byte[] extractUsingFilename(final String filename)
	{
		return extract(getEntryForFileName(filename));
	}

	/** Attempt to extract the asset with the given filename */
	public void extractToFilename(final String filename, final String outputfilename)
	{
		try (FileOutputStream fos = new FileOutputStream(outputfilename))
		{
			fos.write(extract(getEntryForFileName(filename)));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] extract(final AssetEntry ae)
	{
		return ae.file.extract(ae);
	}

	public byte[] extractPart(final AssetEntry ae, final int size)
	{
		AssetFile af = ae.file;
		if (af != ae.file)
			throw new IllegalStateException("Incorrect af found for asset[" + ae + "]");
		return af.extractPart(ae, size, null, false);
	}

	public void extract(final AssetEntry ae, final OutputStream fos)
	{
		findAssetFileForID(ae.strID).extract(ae, fos);
	}

	public AssetEntry getEntryForID(final byte[] id)
	{
		AssetFile file = findAssetFileForID(id);
		if (file != null)
			return file.getEntry(id);
		return null;
	}

	public AssetFile getAssetFile(final AssetEntry ae)
	{
		return ae.file;
	}

	public boolean containsFilenameHash(final String filenameHash)
	{
		if (manifest.containsHash(filenameHash))
		{
			String id = manifest.filenameHashToID(filenameHash);
			return findAssetFileForID(id) != null;
		}
		return false;
	}

}