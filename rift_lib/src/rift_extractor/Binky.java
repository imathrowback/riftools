package rift_extractor;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.telaradb.TelaraDB;
import com.google.common.io.CountingInputStream;
import com.google.common.io.LittleEndianDataInputStream;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes._10018;
import rift_extractor.util.Util;

public class Binky

{
	static TreeSet<String> strs = new TreeSet<>();
	private static boolean useCache = false;

	public static void doVig(final Manifest manifest, final AssetDatabase adb, final ReleaseType release,
			final File outputDirectory)
			throws Exception
	{

		if (!outputDirectory.exists())
			outputDirectory.mkdir();
		System.setProperty("org.jooq.no-logo", "true");
		String bnk = "vo_vignettes.bnk";
		List<HIRCObj> hircsOut1 = new LinkedList<>();

		// we have to download the vo_vignettes.bnk since it doesn't exist in the assets (for some reason?)
		InputStream vigStream = null;

		try
		{
			byte[] vigdata = adb.extractUsingFilename(bnk);
			vigStream = new ByteArrayInputStream(vigdata);
		} catch (Exception ex)
		{
			System.out.println(
					"Error: vo_vignettes.bnk was not located in the local assets. Attempting to download from "
							+ release + " server...");
			if (useCache)
			{
				String cFile = "vig.dat";
				File cFilef = new File(cFile);
				Path cPathf = cFilef.toPath();
				if (!cFilef.exists())
				{
					vigStream = RemotePAK.getLatestAsStream(release, manifest, manifest.getEnglishEntry(bnk),
							true);

					try (FileOutputStream fos = new FileOutputStream(cFile))
					{
						IOUtils.copy(vigStream, fos);
					}
				} else
					vigStream = new FileInputStream(cFilef);
			} else
				vigStream = RemotePAK.getLatestAsStream(release, manifest, manifest.getEnglishEntry(bnk),
						true);
		}

		processBNK(vigStream, null, hircsOut1);

		Map<Integer, List<HIRCObj>> hircMap = new TreeMap<>();
		hircsOut1.forEach(i -> {
			List<HIRCObj> list = hircMap.get(i.id);
			if (list == null)
			{
				list = new LinkedList<>();
				hircMap.put(i.id, list);
			}
			list.add(i);

		});
		//hircsOut1.stream().collect(Collectors.toMap(h -> h.id, h -> h));

		TelaraDB db = new TelaraDB(adb);
		List<Integer> ids = db.getKeys(10017).collect(Collectors.toList());

		int totalCount = ids.size();
		int index = 0;
		int lastP = -1;
		System.out.println("Extracting OGG files to " + outputDirectory);
		for (Integer id : ids)
		{

			int per = (int) (((float) ++index / (float) totalCount) * 100.0f);
			if (lastP != per)
			{
				if ((per % 25) == 0)
					System.out.print(per + "%");
				else if ((per % 5) == 0)
					System.out.print(".");
				lastP = per;
			}

			_10018 obj = ClassUtils.newClass(_10018.class, db.getObject(10017, id));
			//byte[] data = db.getData(10017, id);
			//CObject obj = DatParser.processFileAndObject(new ByteArrayInputStream(data), null);
			String event = obj.WiseEvent;
			int hash = Util.hashFileNameInt(event);
			if (hircMap.containsKey(hash))
			{
				List<HIRCObj> hirclist = hircMap.get(hash);
				for (HIRCObj hircObj : hirclist)
				{
					if (hircObj instanceof DialogueEvent)
					{

					} else if (hircObj instanceof Event)
					{

						Event e = (Event) hircObj;
						List<HIRCObj> actionList = hircMap.get(e.eventActionID);
						for (HIRCObj actionItem : actionList)
						{
							EventAction ea = (EventAction) actionItem;
							List<HIRCObj> soundList = hircMap.get(ea.soundFX);
							if (soundList != null)
							{
								for (HIRCObj soundFXItem : soundList)
								{
									SoundFX sfx = (SoundFX) soundFXItem;
									if (sfx != null)
									{
										String ogg = sfx.oggName + ".ogg";
										if (adb.filenameExists(ogg))
										{

											Path oggp2 = Paths.get(outputDirectory.toString(), event + ".ogg");
											if (!oggp2.toFile().exists())
											{
												//System.out.println("write:" + event + " => " + ogg);
												try
												{
													byte[] data = adb.extractUsingFilename(ogg);
													try (FileOutputStream fos = new FileOutputStream(oggp2.toFile()))
													{
														//System.out.println("Writing " + oggp2);
														IOUtils.copy(new ByteArrayInputStream(data), fos);

													}
												} catch (Exception ex)
												{
													System.out.println("Sound " + event
															+ " was not located in the local assets, attempting to retrieve from server");

													// try again, but download it
													try (FileOutputStream fos = new FileOutputStream(oggp2.toFile()))
													{
														InputStream is = RemotePAK.getLatestAsStream(ReleaseType.LIVE,
																manifest, manifest.getEnglishEntry(ogg), true);
														System.out.println("Success!");
														IOUtils.copy(is, fos);

													} catch (Exception ex2)
													{
														System.out
																.println("Failure, asset unable to be found, skipping");
													}

												}
											}
											//Path oggp = Paths.get(p1, ogg);
											//Path oggp2 = Paths.get(p1, event + ".ogg");
											//if (oggp.toFile().exists())
											//{
											//	oggp.toFile().renameTo(oggp2.toFile());
											//System.out.println("rename '" + oggp + "' => '" + oggp2 + "'");
											//}

										}
									}
								}
							} else
							{
								// System.out.println("==> no sound fx for " + event);
							}
						}
					}
				}
			}
		}
		System.out.println();
	}

	public static void doChatter() throws Exception
	{
		String assetsManifest = "L:\\SteamStuff\\Steam2\\steamapps\\common\\rift\\assets64.manifest";
		String assetsDirectory = "L:\\SteamStuff\\Steam2\\steamapps\\common\\rift\\assets\\";
		Manifest manifest = new Manifest(assetsManifest);
		//AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory);
		List<HIRCObj> hircsOut1 = new LinkedList<>();
		processBNK(new File("vo_chatter.bnkB"), System.out, hircsOut1);
		if (true)
			return;
		Map<Integer, HIRCObj> hircMap = hircsOut1.stream().collect(Collectors.toMap(h -> h.id, h -> h));
		Connection c = DriverManager.getConnection("jdbc:sqlite:" + "t.db");
		TelaraDB db = new TelaraDB(c);
		for (Integer id : db.getKeys(10023).collect(Collectors.toList()))
		{
			byte[] data = db.getData(10023, id);
			CObject obj = DatParser.processFileAndObject(new ByteArrayInputStream(data), null);
			if (obj.hasMember(1))
			{
				String type = (obj.getString(1));
				String eventGreet = "Play_vo_" + type + "_chatter_greeting";
				String event = "Play_vo_" + type + "_chatter_farewell";

				int hash = Util.hashFileNameInt(event);
				if (hircMap.containsKey(hash))
				{
					System.out.println(event);
					DialogueEvent e = (DialogueEvent) hircMap.get(hash);

					/*
					EventAction ea = (EventAction) hircMap.get(e.eventActionID);
					SoundFX sfx = (SoundFX) hircMap.get(ea.soundFX);
					if (sfx != null)
					{
						String ogg = sfx.oggName + ".ogg";
						//if (adb.filenameExists(ogg))
						{
							System.out.println(event + " => " + ogg);
						}
					} else
						System.out.println("No SFX for " + event);
					*/
				} else
					System.out.println("No ID for " + event + ":" + Util.hashFileNameInt(event));
			}

		}
	}

	public static void main(final String args[]) throws Exception
	{
		String assetsManifest = "L:\\SteamStuff\\Steam2\\steamapps\\common\\rift\\assets64.manifest";
		String assetsDirectory = "L:\\SteamStuff\\Steam2\\steamapps\\common\\rift\\assets\\";
		Manifest manifest = new Manifest(assetsManifest);
		AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory);

		doVig(manifest, adb, ReleaseType.LIVE, new File("w:\\rift_stuff\\vig_ogg\\"));
		//doChatter();
		return;

	}

	private static void processBNK(final File file, final PrintStream pw, final List<HIRCObj> hircsOut) throws Exception
	{
		processBNK(new FileInputStream(file), pw, hircsOut);
	}

	private static void processBNK(final InputStream source, final PrintStream pw, final List<HIRCObj> hircsOut)
			throws Exception
	{
		try (CountingInputStream is = new CountingInputStream(source))
		{

			try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is))
			{
				do
				{
					long pos = is.getCount();
					byte[] header = new byte[4];
					dis.read(header);
					int size = dis.readInt();

					byte[] data = new byte[size];
					int sizeRead = dis.read(data);
					String headerName = new String(header);
					if (pw != null)
						pw.println("==" + headerName + "==> " + pos);
					switch (headerName)
					{
						case "BKHD": // BankHeader
							readBKHD(data, pw);
							break;
						case "STID": // BankIDs
							readSTID(data, pw);
							break;
						case "HIRC": // objects (Structure\Hierarchy)
							List<HIRCObj> hircs = readHIRC(data, pw);
							if (hircsOut != null)
								hircsOut.addAll(hircs);
							break;
						default:
					}
				} while (dis.available() > 0);
			}
		}
	}

	private static void readBKHD(final byte[] data, final PrintStream pw) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data)))
		{
		}
	}

	static class HIRCObj
	{
		public int id;

		public HIRCObj(final int id)
		{
			this.id = id;
		}
	}

	static class Event extends HIRCObj
	{
		public int eventActionID;

		public Event(final int id)
		{
			super(id);
		}

		@Override
		public String toString()
		{
			return "ID:" + id + ", EventID:" + eventActionID;
		}
	}

	static class EventAction extends HIRCObj
	{
		public int soundFX;

		public EventAction(final int id)
		{
			super(id);
		}
	}

	static class SoundFX extends HIRCObj
	{
		public int oggName;

		public SoundFX(final int id)
		{
			super(id);
		}
	}

	static class DialogueEvent extends HIRCObj
	{
		public DialogueEvent(final int id)
		{
			super(id);
		}
	}

	private static List<HIRCObj> readHIRC(final byte[] data, final PrintStream pw) throws Exception
	{
		List<HIRCObj> hircs = new LinkedList<>();
		//if (true)
		//return;
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data)))
		{
			int dCount = 0;
			//int slength = dis.readInt();
			int numObjects = dis.readInt();
			if (pw != null)
				pw.println("Num objects:" + numObjects);
			for (int i = 0; i < numObjects; i++)
			{
				int type = dis.read();
				int length = dis.readInt();
				int id = dis.readInt();
				byte[] data2 = new byte[length - 4];
				dis.read(data2);
				if (pw != null)
					pw.println(type + "," + length + ", " + id);
				switch (type)
				{
					case 2:
						if (pw != null)
							pw.println(">Sound SFX/Sound Voice - " + id);
						SoundFX sfx = new SoundFX(id);
						parseSoundVoice(data2, sfx);
						hircs.add(sfx);
						break;
					case 3:
						if (pw != null)
							pw.println(">Event Action - " + id);
						EventAction ea = new EventAction(id);
						parseEventAction(data2, ea);
						hircs.add(ea);

						break;
					case 4:
						if (pw != null)
							pw.println(">Event - " + id);
						Event e = new Event(id);
						parseEvent(data2, e);
						hircs.add(e);

						break;
					case 15:
						if (pw != null)
							pw.println(">Dialogue Event");
						DialogueEvent de = new DialogueEvent(id);
						parseDialogueEvent(data2, de);
						hircs.add(de);
						dCount++;
						break;
					case 5:
						if (pw != null)
							pw.println(">Random Container or Sequence Container");
						break;

					case 14:
						if (pw != null)
							pw.println(">Attenuation");
						break;
					default:
						if (pw != null)
							pw.println("> unknown type: " + type);
				}
				//if (dCount > 5)
				//	return;

				//System.out.println("");
			}
		}
		return hircs;
	}

	private static void parseEventAction(final byte[] data2, final EventAction ea) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data2)))
		{
			dis.readInt();
			//pw.println("\t" + dis.readInt() + "-> SOUNDFX/VOICE");
			ea.soundFX = (dis.readInt());
		}
	}

	private static void parseEvent(final byte[] data2, final Event e) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data2)))
		{
			int eventCount = dis.readInt();
			for (int i = 0; i < eventCount; i++)
			{
				e.eventActionID = dis.readInt();
			}
		}
	}

	private static void parseDialogueEvent(final byte[] data2, final DialogueEvent de) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data2)))
		{
			/*
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			System.out.println("\t" + dis.readInt());
			*/
		}

	}

	private static void parseSoundVoice(final byte[] data2, final SoundFX sfx) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data2)))
		{
			dis.readInt();
			dis.readInt();

			int oggID = dis.readInt();
			//String str = dis.readInt() + ".ogg";
			//Binky.strs.add(str);
			sfx.oggName = oggID;
			//sfx.println("\t" + str);
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			//System.out.println("\t" + dis.readInt());
			/*			System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						System.out.println("\t" + dis.readInt());
						*/
		}
	}

	private static void readSTID(final byte[] data, final PrintStream pw) throws Exception
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(data)))
		{
			int v = dis.readInt();
			//System.out.println(v);
			int soundBanks = dis.readInt();
			for (int i = 0; i < soundBanks; i++)
			{
				int soundId = dis.readInt();
				int strLength = dis.read();
				byte[] string = new byte[strLength];
				dis.read(string);
				strs.add(new String(string));
			}
		}

	}
}
