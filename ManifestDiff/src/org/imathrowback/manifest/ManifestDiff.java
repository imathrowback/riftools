package org.imathrowback.manifest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.Function;

import org.apache.commons.io.FilenameUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.assets.ManifestPAKFileEntry;
import rift_extractor.detector.DefaultDetector;
import rift_extractor.util.Util;

public class ManifestDiff
{
	public static void main(final String[] args) throws Exception
	{
		try
		{
			new ManifestDiff().doMain(Arrays.asList(args));
		} catch (Exception eX)
		{
			System.err.println("An unhandled exception occurred:" + eX.getMessage());
			eX.printStackTrace();
		}
	}

	@Option(name = "-ignoreMapTextures", usage = "Ignore map textures when extracting", required = false)
	boolean ignoreMapTextures = false;

	@Option(name = "-printVersions", usage = "Print current versions and exit", required = false)
	boolean printVersions = false;

	@Option(name = "-onlyB", usage = "Only download the latest files", required = false)
	boolean onlyB = false;

	@Option(name = "-guessExtensions", usage = "Try to guess file extensions", required = false)
	boolean guessExtensions = false;

	@Option(name = "-printVersion", usage = "Print current version and exit", required = false)
	boolean printVersion = false;

	@Option(name = "-cacheManifest", usage = "Cache the downloaded manifest files", required = false)
	boolean cacheManifest = false;

	@Option(name = "-outdir", usage = "Output directory, will be created if it doesn't exist", required = false)
	File outDir = new File(".");

	@Option(name = "-versionA", usage = "Version A, to check for changes from", required = false)
	String versionA = "";
	@Option(name = "-versionB", usage = "Version B, to check for additions, changes and deletions relative to A", required = false)
	String versionB = "";

	@Option(name = "-diffCurrent", usage = "Automatically try to diff the current version with the previous version, manifest file paths and version selection options are ignored if this option is specified.", required = false)
	boolean diffCurrent = false;

	@Option(name = "-release", usage = "The release to diff (required)", required = true)
	ReleaseType release = ReleaseType.LIVE;

	@Option(name = "-onlyLang", usage = "Only process a single language, english = 1", required = false)
	int onlyLang = -1;

	@Option(name = "-extractAdded", usage = "Extract added entries", required = false)
	boolean extractAdded = false;
	@Option(name = "-extractChanged", usage = "Extract changed entries", required = false)
	boolean extractChanged = false;

	@Option(name = "-manifestA", usage = "RIFT Manifest file to check for changes from, if empty, download remote. ", metaVar = "FILE", required = false)
	File manifestAFile = new File("");

	@Option(name = "-manifestB", usage = "RIFT Manifest file to check for changes to, if empty, download remote", metaVar = "FILE", required = false)
	private File manifestBFile = new File("");

	@Option(name = "-v", usage = "Verbose output", required = false)
	private boolean verbose;

	@Option(name = "-h", usage = "Print header", required = false)
	private boolean header;

	//@Option(name = "-showPak", usage = "Show PAK index", required = false)
	private final boolean showPak = true;

	boolean alwaysDownload(final ManifestEntry e)
	{
		String name = (NameDB.getNameForHash(e.filenameHashStr));
		return (name.contains(".cds") || name.contains(".db"));
	}

	public void doMain(final Collection<String> args) throws Exception
	{
		//Systme.out.println(Arrays.toString(a))
		CmdLineParser parser = new CmdLineParser(this);
		parser.setUsageWidth(80);
		try
		{

			// parse the arguments.
			parser.parseArgument(args);
			//if (arguments.isEmpty())
			//	throw new CmdLineException(parser, "No argument is given ");
			if (outDir.exists() && !outDir.isDirectory())
				throw new CmdLineException(parser, "Specified output directory is not a directory");
			if (!diffCurrent)
			{
				if ((extractAdded || extractChanged) && (versionA.isEmpty() || versionB.isEmpty()))
					throw new CmdLineException(parser,
							"To extract files you need to specify the remote versionA and versionB, local extraction is not yet supported");
				if (versionB.isEmpty() && !manifestBFile.exists() && !printVersions)
					throw new CmdLineException(parser, "Must specify either versionB or manifestB file");
				if (versionA.isEmpty() && !manifestAFile.exists() && !printVersions)
					throw new CmdLineException(parser, "Must specify either versionA or manifesA file");
			}
			if (diffCurrent && (!versionA.isEmpty() || !versionB.isEmpty()))
				throw new CmdLineException(parser, "diffCurrent cannot be used at the same time as version selection");
			if (ignoreMapTextures)
				System.out.println("**** NOT extracting map textures ***");

		} catch (CmdLineException e)
		{
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java ManifestDiff [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java ManifestDiff" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}

		Function<ManifestEntry, String> hname = (n) -> NameDB.getNameForHash(n.filenameHashStr, "");

		ReleaseType releaseType = release;
		Map<Integer, PatchInfo> patches = RemotePAK.getPatches(releaseType);

		PatchInfo patchAInfo = null;
		PatchInfo patchBInfo = null;

		if (printVersions || printVersion)
		{
			TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
			sortedPatches.addAll(patches.values());

			patchBInfo = sortedPatches.last();
			patchAInfo = sortedPatches.lower(sortedPatches.last());

			for (PatchInfo p : sortedPatches)
			{
				if (printVersion)
				{
					System.out.println(p.version);
					return;
				} else if (p.version.equals(patchBInfo.version))
					System.out.println(p + "*");
				else
					System.out.println(p);
			}
			return;
		}
		System.out.println("using release:" + releaseType);

		for (PatchInfo p : patches.values())
		{
			if (p.version.equals(versionA))
				patchAInfo = p;
			else if (p.version.equals(versionB))
				patchBInfo = p;
		}

		if (diffCurrent)
		{
			System.out.println(
					"Attempting to diff current and previous version, note that this may fail if a version was 'unreleased', in this case you will have to manually set versions to compare.");
			manifestBFile = new File("");
			manifestAFile = new File("");

			TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
			sortedPatches.addAll(patches.values());

			patchBInfo = sortedPatches.last();
			patchAInfo = sortedPatches.lower(sortedPatches.last());

		}
		if (patchAInfo == null)
		{
			System.err.println("Unable to find patchA " + versionA + ":" + manifestAFile);
			return;
		}
		if (patchBInfo == null)
		{
			System.err.println("Unable to find patchB " + versionB + ":" + manifestBFile);
			return;
		}
		System.out.println(
				"Detected remote patchA index[" + patchAInfo.index + "] as version:" + patchAInfo.version);
		System.out.println(
				"Detected remote patchB index[" + patchBInfo.index + "] as version:" + patchBInfo.version);

		InputStream manifestAStream = null;
		InputStream manifestBStream = null;
		boolean manifestA64 = true;
		boolean manifestB64 = true;

		if (manifestAFile.exists())
		{
			manifestAStream = new FileInputStream(manifestAFile.getPath());
			manifestA64 = manifestAFile.getName().contains("64");
			if (verbose)
				System.out.println("using local manifest A: " + manifestAFile);
		} else
		{
			if (verbose)
				System.out.println("Local manifest A not specified, using remote version.");

			File cacheA = null;
			if (cacheManifest)
				cacheA = Paths.get(outDir.toString(), "assets64.manifestA").toFile();

			byte[] data = RemotePAK.downloadManifest(releaseType, patchAInfo, cacheA);
			manifestAStream = new ByteArrayInputStream(data);

		}
		if (manifestBFile.exists())
		{
			manifestBStream = new FileInputStream(manifestBFile.getPath());
			manifestB64 = manifestBFile.getName().contains("64");
			if (verbose)
				System.out.println("using local manifest B: " + manifestBFile);
		} else
		{

			if (verbose)
				System.out.println("Local manifest B not specified, using remote version.");

			File cacheB = null;
			if (cacheManifest)
				cacheB = Paths.get(outDir.toString(), "assets64.manifestB").toFile();

			byte[] data = RemotePAK.downloadManifest(releaseType, patchBInfo, cacheB);
			manifestBStream = new ByteArrayInputStream(data);
		}

		Manifest manifestA = new Manifest(manifestAStream, manifestA64);
		Manifest manifestB = new Manifest(manifestBStream, manifestB64);

		List<ManifestEntry> nothing = new LinkedList<>();
		List<ManifestEntry> added = new LinkedList<>();
		List<ManifestEntry> deleted = new LinkedList<>();
		List<ManifestEntry> changed = new LinkedList<>();

		for (ManifestEntry aEntry : manifestA.manifestEntries)
		{
			if (onlyLang > 0 && aEntry.lang > 0 && aEntry.lang != onlyLang)
				continue;

			// check if the name for the entry from manifestA exists in manifestB
			List<ManifestEntry> bentries = findEntrysWithName(aEntry, manifestB);
			if (bentries.isEmpty())
			{
				// no? then it was deleted entirely
				deleted.add(aEntry);
			} else
			{
				// it exists, now check if the hashes and language match
				boolean matches = false;
				for (ManifestEntry bEntry : bentries)
				{
					if (bEntry.lang == aEntry.lang)
					{
						//if (manifestB.getPAKName(bEntry.pakIndex).equals(manifestA.getPAKName(aEntry.pakIndex)))
						{
							if (bEntry.shaStr.equals(aEntry.shaStr))
							{
								matches = true;
							}
						}
					}
				}
				if (!matches)
				{
					changed.add(aEntry);
					if (extractChanged && shouldExtract(aEntry, manifestA))
					{
						if (!onlyB || alwaysDownload(aEntry))
							extractEntry(releaseType, aEntry, manifestA, patchAInfo.index, 'A', hname);
						for (ManifestEntry bEntry : bentries)
							extractEntry(releaseType, bEntry, manifestB, patchBInfo.index, 'B', hname);
					}

				}
			}
		}
		for (ManifestEntry bEntry : manifestB.manifestEntries)
		{
			List<ManifestEntry> entries = findEntrysWithName(bEntry, manifestA);
			if (entries.isEmpty())
				added.add(bEntry);

		}
		if (verbose)
		{
			System.out.println("manifestA.manifestEntries:" + manifestA.manifestEntries.size());
			System.out.println("manifestB.manifestEntries:" + manifestB.manifestEntries.size());
			System.out.println("deleted from B: " + deleted.size());
			System.out.println("added to B: " + added.size());
			System.out.println("changed in B: " + changed.size());
		}
		if (header)
			System.out.println("change|filename|filenamehash|assetid|lang" + (showPak ? "|pakIndex" : ""));
		Set<String> pakHashesProcessed = new TreeSet<>();
		Set<ManifestPAKFileEntry> paksToUse = new TreeSet<>((a, b) -> a.name.compareTo(b.name));
		for (ManifestEntry del : deleted)
		{
			if (verbose)
				System.out.println("[del]:" + hname.apply(del) + "|" + del + ":" + del.pakIndex);
			else
				System.out.println(
						"-|" + hname.apply(del) + "|" + Util.bytesToHexString(del.filenameHash) + ":" + del.idStr + ":"
								+ del.lang
								+ getPak(del));
		}
		for (ManifestEntry add : added)
		{
			if (onlyLang > 0 && add.lang > 0 && add.lang != onlyLang)
				continue;

			if (verbose)
				System.out.println("[add]:" + hname.apply(add) + "|" + add + ":" + add.pakIndex);
			else
				System.out.println(
						"+|" + hname.apply(add) + "|" + Util.bytesToHexString(add.filenameHash) + ":" + add.idStr
								+ ":"
								+ add.lang
								+ getPak(add));
			ManifestPAKFileEntry pEntry = manifestB.pakFiles.get(add.pakIndex);

			// extract the added file
			if (extractAdded && shouldExtract(add, manifestB))
				extractEntry(releaseType, add, manifestB, patchBInfo.index, 'B', hname);

			if (!pakHashesProcessed.contains(pEntry.combHash))
			{
				paksToUse.add(pEntry);
				pakHashesProcessed.add(pEntry.combHash);
			}

		}
		for (ManifestEntry change : changed)
		{
			if (onlyLang > 0 && change.lang > 0 && change.lang != onlyLang)
				continue;

			if (verbose)
				System.out.println("[change]:" + hname.apply(change) + "|" + change + ":" + change.pakIndex);
			else
				System.out.println(
						"*|" + hname.apply(change) + "|" + Util.bytesToHexString(change.filenameHash) + ":"
								+ change.idStr + ":" + change.lang
								+ getPak(change));
			paksToUse.add(manifestB.pakFiles.get(change.pakIndex));
		}

		if (guessExtensions)
		{
			DefaultDetector dd = new DefaultDetector(null);
			for (File f : outDir.listFiles())
			{
				if (f.getName().endsWith(".file") || f.getName().endsWith("B") || f.getName().endsWith("A"))
					;
				{
					byte[] data = Files.readAllBytes(f.toPath());
					String ext = dd.detectExtension(data);
					if (ext != null)
					{
						if (f.getName().endsWith("B") || f.getName().endsWith("A"))
						{
							char last = f.getName().charAt(f.getName().length() - 1);
							String fext = FilenameUtils.getExtension(f.getName());
							String base = FilenameUtils.getBaseName(f.getName());
							fext = fext.substring(0, fext.length());

							String newName = base + "-" + last + "." + fext;
							Path newPath = Paths.get(outDir.toString(), newName);
							f.renameTo(newPath.toFile());
						} else
						{
							String newName = f.getName().replace(".file", "." + ext);
							Path newPath = Paths.get(outDir.toString(), newName);
							f.renameTo(newPath.toFile());
						}

					}

				}
			}
		}

		if (verbose)
		{
			for (ManifestPAKFileEntry en : paksToUse)
				System.out.println(en);

			long sum = paksToUse.stream().mapToLong(p -> p.getSize()).sum();
			System.out.println("Total download size: " + MessageFormat.format("{0} bytes", sum));
		}
	}

	private boolean shouldExtract(final ManifestEntry aEntry, final Manifest manifestA)
	{
		boolean doExtract = true;
		String pakName = manifestA.getPAKName(aEntry.pakIndex);
		if (ignoreMapTextures && pakName.contains("texture_map"))
			return false;

		return doExtract;
	}

	private void extractEntry(final ReleaseType type, final ManifestEntry entry, final Manifest manifest,
			final int ptsIndex, final char patchIndex, final Function<ManifestEntry, String> hname)
	{
		ManifestPAKFileEntry pEntry = manifest.getPAK(entry.pakIndex);
		int lang = entry.lang;

		try
		{
			String filename1 = entry.filenameHashStr + "-" + entry.idStr + "-" + patchIndex + ".file";
			if (lang != 0 && lang != 1)
				filename1 = "lang" + lang + "_" + filename1;
			if (!outDir.exists())
				outDir.mkdir();
			String filename = Paths.get(outDir.toString(), filename1).toString();
			String guessname = hname.apply(entry);
			if (!guessname.isEmpty())
			{
				if (onlyB && !alwaysDownload(entry))
					filename = Paths.get(outDir.toString(), guessname).toString();
				else
					filename = Paths.get(outDir.toString(), guessname + patchIndex).toString();
			}

			if (new File(filename).exists() && new File(filename).length() > 0)
				System.out.println(
						"\tskipping extraction, file[" + filename + "] from " + pEntry.name
								+ " already exists");
			else
			{
				//if (verbose)
				System.out.print("\textracting to:" + filename + " from [" + patchIndex + "]" + pEntry.name + " ");
				if (ptsIndex >= 0)
				{
					RemotePAK.extract(type, manifest, entry, filename, ptsIndex);
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private String getPak(final ManifestEntry del)
	{
		if (showPak)
			return ":" + del.pakIndex;

		else
			return "";
	}

	private static List<ManifestEntry> findEntrysWithName(final ManifestEntry entry, final Manifest manifest)
	{
		Map<String, List<ManifestEntry>> filenameMap = manifest.fileNameHashesIDMap;
		if (!filenameMap.containsKey(entry.filenameHashStr))
			return Collections.emptyList();
		;
		List<ManifestEntry> entries = filenameMap.get(entry.filenameHashStr);
		return entries;
	}
}
