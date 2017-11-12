package org.imathrowback.riftool.actions;

import java.io.*;
import java.sql.DriverManager;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.Option;

public class ExtractDBStrings extends RiftAction
{
	@Option(name = "-filename", usage = "The filename", required = true)
	File filename;

	public ExtractDBStrings()
	{

	}

	@Override
	public void go()
	{
		String stringsTxt = "db_strings.txt";
		try
		{
			TelaraDB telaraDB = new TelaraDB(DriverManager.getConnection("jdbc:sqlite:" + filename.getPath()));
			Set<Pair<Integer, Integer>> ids = telaraDB.getIdsAndKeys()
					.collect(Collectors.toCollection(() -> new TreeSet<>()));
			try (
					PrintWriter dbStrings = new PrintWriter(
							new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(stringsTxt)),
									"UTF-8")))
			{

				ids.parallelStream().forEach(idB -> {

					try
					{
						byte[] data = telaraDB.getData(idB.getLeft(), idB.getRight());
						CObject obj = DatParser
								.processFileAndObject(
										new ByteArrayInputStream(data),
										null);
						writeStrings(dbStrings, obj);
					} catch (Exception ex)
					{
						System.err.println("Error processing entry:" + idB);
						ex.printStackTrace();
					}
				});
			}
			System.out.println("Wrote data to " + stringsTxt);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	private void writeStrings(final PrintWriter writer, final CObject obj)
	{
		if (obj.type == 6)
			writer.println(obj.convert() + "");
		for (CObject o : obj.members)
			writeStrings(writer, o);
	}
}
