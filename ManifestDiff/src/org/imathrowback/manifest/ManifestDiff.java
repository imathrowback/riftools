package org.imathrowback.manifest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import org.apache.commons.io.FilenameUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import org.imathrowback.manifest.diff.ChangeType;
import org.imathrowback.manifest.diff.DiffConfig;
import org.imathrowback.manifest.diff.DiffEntry;
import org.imathrowback.manifest.diff.DiffKeyStrategy;
import org.imathrowback.manifest.diff.DiffOutput;
import org.imathrowback.manifest.diff.DiffOutput.Format;
import org.imathrowback.manifest.diff.DiffResult;
import org.imathrowback.manifest.diff.ManifestDiffer;
import org.imathrowback.manifest.diff.MetadataFlag;

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

	@Option(name = "-diffCurrent", usage = "Automatically try to diff the current version with the previous version", required = false)
	boolean diffCurrent = false;

	@Option(name = "-releaseA", usage = "The release to diff", required = false)
	ReleaseType releaseA;

	@Option(name = "-releaseB", usage = "The release to diff for B, optional, will use same as A if left out", required = false)
	ReleaseType releaseB;

	@Option(name = "-onlyLang", usage = "Only process a single language, english = 1", required = false)
	int onlyLang = -1;

	@Option(name = "-extractAdded", usage = "Extract added entries", required = false)
	boolean extractAdded = false;
	@Option(name = "-extractChanged", usage = "Extract changed entries", required = false)
	boolean extractChanged = false;

	@Option(name = "-manifestA", usage = "RIFT Manifest file to check for changes from", metaVar = "FILE", required = false)
	File manifestAFile = new File("");

	@Option(name = "-manifestB", usage = "RIFT Manifest file to check for changes to", metaVar = "FILE", required = false)
	private File manifestBFile = new File("");

	@Option(name = "-v", usage = "Verbose output", required = false)
	private boolean verbose;

	@Option(name = "-patchIndexA", usage = "Patch index for manifest A (for PAK URL construction in HTML preview)", required = false)
	int patchIndexA = -1;

	@Option(name = "-patchIndexB", usage = "Patch index for manifest B (for PAK URL construction in HTML preview)", required = false)
	int patchIndexB = -1;

	@Option(name = "-h", usage = "Print header", required = false)
	private boolean header;

	@Option(name = "-64")
	boolean is64 = true;

	@Option(name = "-keyStrategy", usage = "Diff key strategy: FILENAME_HASH, FILENAME_HASH_AND_LENGTH, FILENAME_HASH_AND_LANG, FILENAME_HASH_AND_LENGTH_AND_ASSET_ID, ASSET_ID, SHA", required = false)
	private DiffKeyStrategy keyStrategy = DiffKeyStrategy.FILENAME_HASH_AND_LENGTH_AND_ASSET_ID;

	@Option(name = "-renameDetection", usage = "Detect renames (same SHA, different key)", required = false)
	private boolean renameDetection = true;

	@Option(name = "-trackMoves", usage = "Track PAK index moves", required = false)
	private boolean trackMoves = true;

	@Option(name = "-format", usage = "Output format: text, json, or html", required = false)
	private String formatStr = "text";

	@Option(name = "-output", usage = "Write output to file instead of stdout", required = false)
	private String outputFile = "";

	boolean alwaysDownload(final ManifestEntry e)
	{
		String name = NameDB.getNameForHash(e.filenameHashStr);
		return (name.contains(".cds") || name.contains(".db"));
	}

	public void doMain(final Collection<String> args) throws Exception
	{
		System.out.println("is64:" + is64);
		CmdLineParser parser = new CmdLineParser(this);
		parser.setUsageWidth(80);
		try
		{
			parser.parseArgument(args);

			boolean localOnly = manifestAFile.exists() && manifestBFile.exists();

			if (outDir.exists() && !outDir.isDirectory())
				throw new CmdLineException(parser, "Specified output directory is not a directory");

			if (localOnly)
			{
				if (extractAdded || extractChanged)
					System.err.println("Warning: extraction not available in local-only mode (requires remote version info)");
			} else if (!diffCurrent)
			{
				if (releaseA == null)
					throw new CmdLineException(parser,
							"Release must be specified if diffCurrent is false");
				if ((extractAdded || extractChanged) && (versionA.isEmpty() || versionB.isEmpty()))
					throw new CmdLineException(parser,
							"To extract files you need to specify the remote versionA and versionB");
				if (versionB.isEmpty() && !manifestBFile.exists() && !printVersions)
					throw new CmdLineException(parser, "Must specify either versionB or manifestB file");
				if (versionA.isEmpty() && !manifestAFile.exists() && !printVersions)
					throw new CmdLineException(parser, "Must specify either versionA or manifestA file");
			}
			if (diffCurrent && (!versionA.isEmpty() || !versionB.isEmpty()))
				throw new CmdLineException(parser, "diffCurrent cannot be used at the same time as version selection");
			if (ignoreMapTextures)
				System.out.println("**** NOT extracting map textures ***");

		} catch (CmdLineException e)
		{
			System.err.println(e.getMessage());
			System.err.println("java ManifestDiff [options...] arguments...");
			parser.printUsage(System.err);
			System.err.println();
			System.err.println("  Example: java ManifestDiff" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}

		Function<ManifestEntry, String> hname = (n) -> NameDB.getNameForHash(n.filenameHashStr, "");
		PatchInfo patchAInfo = null;
		PatchInfo patchBInfo = null;
		ReleaseType releaseTypeA = releaseA;
		ReleaseType releaseTypeB = releaseB;

		boolean localOnly = manifestAFile.exists() && manifestBFile.exists();

		if (localOnly)
		{
			if (verbose)
				System.out.println("Local-only mode: using manifestA=" + manifestAFile + ", manifestB=" + manifestBFile);
		} else if (diffCurrent)
		{
			System.out.println(
					"Attempting to diff current and previous version, note that this may fail if a version was 'unreleased'");
			manifestBFile = new File("");
			manifestAFile = new File("");
			TreeSet<PatchInfo> sortedPatches = new TreeSet<>();

			if (releaseTypeA != null)
				sortedPatches.addAll(RemotePAK.getPatches(releaseTypeA, is64).values());
			else
				for (ReleaseType t : ReleaseType.values())
					sortedPatches.addAll(RemotePAK.getPatches(t, is64).values());

			patchBInfo = sortedPatches.last();
			patchAInfo = sortedPatches.lower(sortedPatches.last());

		} else
		{
			if (releaseB == null)
				releaseB = releaseA;

			Map<Integer, PatchInfo> patchesA = RemotePAK.getPatches(releaseTypeA, is64);
			Map<Integer, PatchInfo> patchesB = RemotePAK.getPatches(releaseTypeB, is64);

			TreeSet<PatchInfo> sortedPatches = new TreeSet<>();
			sortedPatches.addAll(patchesA.values());
			sortedPatches.addAll(patchesB.values());

			if (printVersions || printVersion)
			{
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

			for (PatchInfo p : patchesA.values())
			{
				if (p.version.equals(versionA))
					patchAInfo = p;
				else if (p.version.equals(versionB))
					patchBInfo = p;
			}
			for (PatchInfo p : patchesB.values())
			{
				if (p.version.equals(versionA))
					patchAInfo = p;
				else if (p.version.equals(versionB))
					patchBInfo = p;
			}
		}

		if (!localOnly)
		{
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
			if (releaseTypeA == null)
				releaseTypeA = patchAInfo.release;
			System.out.println("using releaseA:" + releaseTypeA);
			if (releaseTypeB == null)
				releaseTypeB = patchBInfo.release;
			System.out.println("using releaseB:" + releaseTypeB);

			System.out.println(
					"Detected remote patchA release[" + patchAInfo.release + "], index[" + patchAInfo.index
							+ "] as version:" + patchAInfo.version);
			System.out.println(
					"Detected remote patchB release[" + patchBInfo.release + "], index[" + patchBInfo.index
							+ "] as version:" + patchBInfo.version);
		}

		byte[] manifestAData = null;
		byte[] manifestBData = null;
		boolean manifestA64 = true;
		boolean manifestB64 = true;

		if (manifestAFile.exists())
		{
			manifestAData = Files.readAllBytes(manifestAFile.toPath());
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
			manifestAData = RemotePAK.downloadManifest(patchAInfo, cacheA);
		}

		if (manifestBFile.exists())
		{
			manifestBData = Files.readAllBytes(manifestBFile.toPath());
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
			manifestBData = RemotePAK.downloadManifest(patchBInfo, cacheB);
		}

		Manifest manifestA;
		Manifest manifestB;
		try (InputStream isA = new ByteArrayInputStream(manifestAData);
				InputStream isB = new ByteArrayInputStream(manifestBData))
		{
			manifestA = new Manifest(isA, manifestA64);
			manifestB = new Manifest(isB, manifestB64);
		}

		DiffConfig config = new DiffConfig()
				.setKeyStrategy(keyStrategy)
				.setOnlyLang(onlyLang)
				.setDetectRenames(renameDetection)
				.setTrackPakMoves(trackMoves);

		ManifestDiffer differ = new ManifestDiffer();
		DiffResult result = differ.diff(manifestA, manifestB, config);

		if (verbose)
		{
			System.out.println("manifestA.manifestEntries:" + manifestA.manifestEntries.size());
			System.out.println("manifestB.manifestEntries:" + manifestB.manifestEntries.size());
		}
		System.out.println("Added: " + result.getAdded().size());
		System.out.println("Deleted: " + result.getDeleted().size());
		System.out.println("Changed: " + result.getChanged().size());
		System.out.println("Renamed: " + result.getRenamed().size());
		System.out.println("Moved: " + result.getMoved().size());

		Format format;
		if ("json".equalsIgnoreCase(formatStr))
			format = Format.JSON;
		else if ("html".equalsIgnoreCase(formatStr))
			format = Format.HTML;
		else
			format = Format.TEXT;

		String formatted = DiffOutput.format(result, format, header, true, verbose, manifestA, manifestB, patchIndexA, patchIndexB);
		if (!outputFile.isEmpty())
		{
			Path outPath = Paths.get(outputFile);
			Files.write(outPath, formatted.getBytes());
			System.out.println("Report written to " + outPath.toAbsolutePath());
		} else if (format == Format.HTML)
		{
			Path outPath = Paths.get(outDir.toString(), "diff.html");
			Files.write(outPath, formatted.getBytes());
			System.out.println("Report written to " + outPath.toAbsolutePath());
		} else
		{
			System.out.print(formatted);
		}

		Set<String> pakHashesProcessed = new java.util.TreeSet<>();
		Set<ManifestPAKFileEntry> paksToUse = new java.util.TreeSet<>((a, b) -> a.name.compareTo(b.name));

		if (patchAInfo != null && patchBInfo != null)
		{
			for (DiffEntry entry : result.getAdded())
			{
				if (extractAdded && shouldExtract(entry.getEntryNew(), manifestB))
					extractEntry(releaseTypeB, entry.getEntryNew(), manifestB, patchBInfo.index, 'B', hname);

				ManifestPAKFileEntry pEntry = manifestB.pakFiles.get(entry.getEntryNew().pakIndex);
				if (!pakHashesProcessed.contains(pEntry.combHash))
				{
					paksToUse.add(pEntry);
					pakHashesProcessed.add(pEntry.combHash);
				}
			}

			for (DiffEntry entry : result.getChanged())
			{
				if (!extractChanged || !shouldExtract(getDisplayEntry(entry), manifestB))
					continue;

				if (entry.getEntryOld() != null && (!onlyB || alwaysDownload(entry.getEntryOld())))
					extractEntry(releaseTypeA, entry.getEntryOld(), manifestA, patchAInfo.index, 'A', hname);
				if (entry.getEntryNew() != null)
					extractEntry(releaseTypeB, entry.getEntryNew(), manifestB, patchBInfo.index, 'B', hname);
			}

			for (DiffEntry entry : result.getMoved())
			{
				if (extractChanged && shouldExtract(entry.getEntryNew(), manifestB))
					extractEntry(releaseTypeB, entry.getEntryNew(), manifestB, patchBInfo.index, 'B', hname);
			}

			for (DiffEntry entry : result.getChanged())
			{
				ManifestEntry ne = entry.getEntryNew();
				if (ne != null)
					paksToUse.add(manifestB.pakFiles.get(ne.pakIndex));
			}
			for (DiffEntry entry : result.getMoved())
			{
				ManifestEntry ne = entry.getEntryNew();
				if (ne != null)
					paksToUse.add(manifestB.pakFiles.get(ne.pakIndex));
			}
		}

		if (guessExtensions)
		{
			File[] outFiles = outDir.listFiles();
			if (outFiles != null)
			{
				DefaultDetector dd = new DefaultDetector(null);
				for (File f : outFiles)
				{
					if (!f.isFile())
						continue;
					String name = f.getName();
					if (!name.endsWith(".file") && !name.endsWith("B") && !name.endsWith("A"))
						continue;

					byte[] data = Files.readAllBytes(f.toPath());
					String ext = dd.detectExtension(data);
					if (ext != null)
					{
						if (name.endsWith("B") || name.endsWith("A"))
						{
							char last = name.charAt(name.length() - 1);
							String base = FilenameUtils.getBaseName(name);
							String newName = base + "-" + last + "." + ext;
							f.renameTo(Paths.get(outDir.toString(), newName).toFile());
						} else
						{
							String newName = name.replace(".file", "." + ext);
							f.renameTo(Paths.get(outDir.toString(), newName).toFile());
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
			System.out.println(MessageFormat.format("{0} bytes", sum));
		}
	}

	private boolean shouldExtract(final ManifestEntry aEntry, final Manifest manifestA)
	{
		if (ignoreMapTextures)
		{
			String pakName = manifestA.getPAKName(aEntry.pakIndex);
			if (pakName != null && pakName.contains("texture_map"))
				return false;
		}
		return true;
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
				System.out.print("\textracting to:" + filename + " from [" + patchIndex + "]" + pEntry.name + " ");
				if (ptsIndex >= 0)
					RemotePAK.extract(type, manifest, entry, filename, ptsIndex);
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private static ManifestEntry getDisplayEntry(final DiffEntry entry)
	{
		ManifestEntry ne = entry.getEntryNew();
		if (ne != null)
			return ne;
		return entry.getEntryOld();
	}
}
