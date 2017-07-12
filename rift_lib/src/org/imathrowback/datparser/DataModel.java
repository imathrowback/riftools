/*
 *
 */
package org.imathrowback.datparser;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author imathrowback
 */
public class DataModel
{
	Map<Long, Clazz> clazzModel = new TreeMap<>();

	public Clazz getClazz(final Long key)
	{
		if (clazzModel.containsKey(key))
			return clazzModel.get(key);
		return null;
	}

	public DataModel(final File modelSource)
	{
		try
		{
			List<String> lines = Files.readAllLines(modelSource.toPath());
			for (int i = 0; i < lines.size(); i++)
			{
				String line = lines.get(i).trim();
				if (line.startsWith("class"))
				{
					Clazz clazz = new Clazz();

					String parts[] = line.split(" ");
					String namePart = parts[1];
					String name = namePart.substring(0, namePart.indexOf("<"));
					long key = Long.parseLong(namePart.substring(namePart.indexOf("<") + 1, namePart.indexOf(">")));
					clazz.name = name;
					clazz.key = key;
					do
					{
						line = lines.get(++i).trim();
						if (line.startsWith("<"))
						{
							int firstAngle = line.indexOf(">") + 1;
							String first = line.substring(1, firstAngle);
							String rest = line.substring(firstAngle);
							String firstParts[] = first.split(",");
							int index = Integer.valueOf(firstParts[0]);
							clazz.fields.put(index, rest);
						}
					} while (!(line.startsWith("}")));

					clazzModel.put(key, clazz);
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
			;
		}
	}
}
