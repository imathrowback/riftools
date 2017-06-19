package org.imathrowback.manifest;

import java.io.*;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamException;
import org.apache.commons.net.io.CopyStreamListener;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.tukaani.xz.LZMA2InputStream;

import com.google.common.io.Files;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.assets.PAKFileEntry;

public class RemotePAK
{

	/** TODO, get these from the GlyphLibrary.xml file */
	static String BASE_URL[] = { "http://rift-update.dyn.triongames.com/ch1-live-streaming-client-patch",
			"http://update2.triongames.com/ch1-live-streaming-client-patch" };
	static String VERSIONS_NAME[] = { "public/ch1-live.txt", "public/ch1-pts.txt" };
	static String CONTENT_URL[] = { "content/patchlive0", "content/patchpts0" };
	static String VERSIONS_MANIFEST = "recovery64/recovery64.manifest";

	public static String getBaseUrl(final ReleaseType type)
	{
		return BASE_URL[type.ordinal()];
	}

	public static String getContentUrl(final ReleaseType type)
	{
		return CONTENT_URL[type.ordinal()];
	}

	public static String getVersionUrl(final ReleaseType type)
	{
		return VERSIONS_NAME[type.ordinal()];
	}

	private static InputStream getURLAsStream(final String url) throws IOException
	{
		try (CloseableHttpClient client = HttpClients.createDefault())
		{

			HttpGet get = new HttpGet(url);
			try (CloseableHttpResponse response = client.execute(get))
			{
				HttpEntity httpEntity = response.getEntity();
				try (InputStream httpInputStream = httpEntity.getContent())
				{
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					IOUtils.copy(httpInputStream, bos);
					return new ByteArrayInputStream(bos.toByteArray());
				}
			}
		}
	}

	public static Map<Integer, PatchInfo> getPatches(final ReleaseType type) throws IOException
	{
		//PatchInfo currentInfo = getCurrentPatch(type);
		Map<Integer, TreeSet<PatchInfo>> patches = new TreeMap<>();

		// find the previous patch
		for (int i = 1; i < 5; i++)
		{
			String url = getBaseUrl(type) + "/" + getContentUrl(type) + i + "/" + VERSIONS_MANIFEST;
			try (InputStream input = getURLAsStream(url))
			{

				TreeSet<PatchInfo> p = new TreeSet<PatchInfo>();
				List<String> lines = IOUtils.readLines(input, "UTF-8");

				for (int li = 0; li < lines.size(); li++)
				{
					String line = lines.get(li).trim();
					if (line.startsWith("version"))
					{
						String version = line.split(" ")[1];
						List<String> pLines = new LinkedList<>();
						do
						{
							line = lines.get(++li).trim();
							if (line.equals("f"))
								break;
							else
								pLines.add(line);
						} while (!line.equals("f"));
						p.add(new PatchInfo(i, version, pLines));
					} else
					{
						if (line.contains("File not found"))
							throw new FileNotFoundException();
						throw new IllegalStateException("Unexpected line in manifest:" + line);
					}
				}
				patches.put(i, p);

			} catch (FileNotFoundException ex)
			{
				// ignore this, we don't care
				//System.err.println("failed:" + url);
				break;
			}
		}

		Map<Integer, PatchInfo> currentPatches = new TreeMap<>();
		for (int i = 1; i < 5; i++)
		{
			if (patches.containsKey(i))
			{
				TreeSet<PatchInfo> p = patches.get(i);
				//System.out.println("[" + i + "]: found patches:" + p);
				currentPatches.put(i, p.last());
			}
		}
		return currentPatches;
	}

	public static PatchInfo getCurrentPatch(final ReleaseType releaseType) throws IOException
	{
		Map<Integer, PatchInfo> patches = RemotePAK.getPatches(releaseType);

		TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
		sortedPatches.addAll(patches.values());

		return sortedPatches.last();
	}

	public static PatchInfo[] getCurrentPatches(final ReleaseType releaseType) throws IOException
	{
		Map<Integer, PatchInfo> patches = RemotePAK.getPatches(releaseType);

		TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
		sortedPatches.addAll(patches.values());

		return new PatchInfo[] { sortedPatches.lower(sortedPatches.last()), sortedPatches.last() };
	}

	public static byte[] downloadManifest(final ReleaseType type, final PatchInfo patchInfo, final File cache)
			throws IOException
	{

		if (cache != null)
		{
			if (cache.exists())
			{
				return java.nio.file.Files.readAllBytes(cache.toPath());
				/*
				try (FileInputStream fis = new FileInputStream(cache))
				{
					//String sha1 = Util.bytesToHexString(DigestUtils.sha1(fis));
					//System.out.println(sha1);
					//System.out.println("patch expected:" + patchInfo.getEntry("assets64.manifest"));
					return new byte[0];
				}
				*/
			}
		}

		String url = getBaseUrl(type) + "/" + getContentUrl(type) + patchInfo.index
				+ "/recovery64/assets64.manifest";
		System.out.print("downloading manifest:" + url + "  ");

		try (CloseableHttpClient client = HttpClients.createDefault())
		{

			HttpGet get = new HttpGet(url);
			try (CloseableHttpResponse response = client.execute(get))
			{
				HttpEntity httpEntity = response.getEntity();
				try (InputStream httpInputStream = httpEntity.getContent())
				{

					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					copyWithProgress(httpEntity.getContentLength(), httpInputStream, bos);
					System.out.println("done...");
					if (cache != null)
						Files.write(bos.toByteArray(), cache);
					return bos.toByteArray();
				}
			}
		}
	}

	/**
	 * Download a file from the current release.
	 *
	 * @param releaseType The release type
	 * @param patch Patch 'A' or 'B'
	 * @param filename The filename of the file to extract
	 * @param outputDir The directory to place the file
	 * @throws IOException
	 */
	public static void download(final ReleaseType releaseType, final char patch, final String filename,
			final String outputDir) throws IOException
	{
		PatchInfo[] currentPatches = getCurrentPatches(releaseType);
		PatchInfo currentPatch = currentPatches[0];
		if (patch == 'A')
			currentPatch = currentPatches[0];
		else if (patch == 'B')
			currentPatch = currentPatches[1];
		else
			throw new IllegalArgumentException("Invalid patch " + patch + " specified, must be 'A' or 'B'");
		Manifest manifest = new Manifest(new ByteArrayInputStream(downloadManifest(releaseType, currentPatch,
				Paths.get(outputDir, "assets64.manifest" + patch).toFile())), true);

		ManifestEntry entry = manifest.getEnglishEntry(filename);
		extract(releaseType, manifest, entry, Paths.get(outputDir, filename + patch).toString(), currentPatch.index);

	}

	public static void extract(final ReleaseType type, final Manifest manifest, final ManifestEntry e,
			final String filename,
			final int pindex)
			throws IOException
	{

		int pakIndex = e.pakIndex;
		PAKFileEntry pakFile = manifest.getPAK(pakIndex);

		//System.out.println(e);
		//System.out.println(pakFile);
		String url = getBaseUrl(type) + "/" + getContentUrl(type) + pindex + "/"
				+ pakFile.name;
		//System.out.println(url);

		int startBytes = e.pakOffset;
		int endBytes = (e.pakOffset + e.compressedSize) - 1;

		try (CloseableHttpClient client = HttpClients.createDefault())
		{
			HttpGet get = new HttpGet(url);
			get.addHeader("Range", "bytes=" + startBytes + "-" + endBytes + "");
			try (CloseableHttpResponse response = client.execute(get))
			{
				HttpEntity httpEntity = response.getEntity();
				ByteArrayOutputStream bos = new ByteArrayOutputStream();

				try (InputStream httpInputStream = httpEntity.getContent())
				{
					copyWithProgress(e.compressedSize, httpInputStream, bos);
				}

				try (InputStream fis = new ByteArrayInputStream(bos.toByteArray()))
				{
					try (FileOutputStream fos = new FileOutputStream(filename))
					{
						if (e.size != e.compressedSize)
						{
							fis.skip(1);
							try (LZMA2InputStream in = new LZMA2InputStream(fis, e.size * 2))
							{
								IOUtils.copy(in, fos);
							}
						} else
						{
							IOUtils.copy(fis, fos);
						}
					}
				}

			}
		}
	}

	public static void copyWithProgress(final long totalCount, final InputStream is, final OutputStream os)
			throws CopyStreamException
	{

		org.apache.commons.net.io.Util.copyStream(is, os, 8092, totalCount, new CopyStreamListener() {
			int lastP = -1;

			@Override
			public void bytesTransferred(final long totalBytesTransferred, final int bytesTransferred,
					final long streamSize)
			{
				int per = (int) (((float) totalBytesTransferred / (float) streamSize) * 100.0f);
				if (lastP != per)
				{
					if ((per % 25) == 0)
						System.out.print(per + "%");
					else if ((per % 5) == 0)
						System.out.print(".");
					lastP = per;
				}
			}

			@Override
			public void bytesTransferred(final CopyStreamEvent event)
			{
			}
		}, true);
		System.out.println("");
	}
}
