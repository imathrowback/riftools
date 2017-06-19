package rift_extractor.nif;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.google.common.io.LittleEndianDataInputStream;

public class NIFFile
{
	int fileVer;
	int endian;
	int userVersion;
	int numObjects;
	String header;
	List<NIFObject> objects = new LinkedList<>();
	List<String> stringTable = new LinkedList<>();
	List<Integer> groupSizes = new LinkedList<>();
	private final List<NiMesh> nifMeshes = new LinkedList<>();

	long NIF_INVALID_LINK_ID = 0xFFFFFFFF;
	private final List<NiSourceTexture> nifTextures = new LinkedList<>();;

	public List<String> getStringTable()
	{
		return stringTable;
	}

	private NIFFile()
	{

	}

	public NIFFile(final InputStream is) throws IOException
	{
		parseFile(is);
	}

	public List<? extends NIFObject> getObjects()
	{
		return Collections.unmodifiableList(objects);
	}

	public String getStringFromTable(final int i)
	{
		return stringTable.get(i);
	}

	public static List<String> getNIFStrings(final InputStream is) throws IOException
	{
		NIFFile simpleFile = new NIFFile();
		return simpleFile.getStringsOnly(is);
	}

	/**
	 * This method reads only enough to get the strings and leaves the rest of the class in an inconsistent state.
	 *
	 * @param is
	 * @return
	 * @throws IOException
	 */
	private List<String> getStringsOnly(final InputStream is) throws IOException
	{
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new BufferedInputStream(is)))
		{
			readHeader(dis);
			if (numObjects > 10000)
				throw new IllegalArgumentException("too many strings [" + numObjects + "] in the header?");
			for (int i = 0; i < numObjects; i++)
				objects.add(new NIFObject());
			loadTypeNames(dis);
			loadObjectSizes(dis);
			loadStringTable(dis);
			return stringTable;
		}
	}

	private void parseFile(final InputStream is) throws IOException
	{
		// Read header

		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new BufferedInputStream(is)))
		{
			readHeader(dis);
			for (int i = 0; i < numObjects; i++)
				objects.add(new NIFObject());
			//readMetaData(dis);
			loadTypeNames(dis);
			loadObjectSizes(dis);
			loadStringTable(dis);
			loadObjectGroups(dis);
			loadObjects(dis);
			//setParents();
		}

	}

	private void setParents()
	{
		int NIF_INVALID_LINK_ID = 0xFFFFFFFF;
		// only for "NiNode"
		for (NIFObject obj : objects)
		{
			if (obj instanceof NiNode)
			{
				NiNode node = (NiNode) obj;
				for (Integer id : node.childLinks)
				{
					if (id != NIF_INVALID_LINK_ID)
					{
						NIFObject childObj = objects.get(id);
						if (childObj instanceof NiNode)
						{
							if (childObj.parentIndex != -1)
								System.err.println("Node parented by more than one");
							childObj.parentIndex = node.index;
						}
					}
				}
			}
		}

	}

	private void loadObjects(final LittleEndianDataInputStream dis) throws IOException
	{
		for (int i = 0; i < numObjects; i++)
		{
			NIFObject obj = objects.get(i);
			obj.index = i;
			String typeName = obj.typeName;
			int size = obj.nifSize;
			byte[] data = new byte[size];

			try
			{
				dis.readFully(data);
				LittleEndianDataInputStream ds = new LittleEndianDataInputStream(
						new BufferedInputStream(new ByteArrayInputStream(data)));
				if (typeName.startsWith("NiDataStream"))
				{
					NiDataStream newObj = new NiDataStream();
					newObj.parse(this, obj, ds);
					objects.set(i, newObj);
				} else
				{

					Class<? extends NIFObject> clazz = getClazz("rift_extractor.nif." + typeName);
					if (clazz != null)
					{
						NIFObject newObj = clazz.newInstance();
						newObj.parse(this, obj, ds);
						objects.set(i, newObj);
					}
				}
			} catch (Exception ex)
			{
				String s = "Unhandled nif type:" + typeName + " due to exception. " + ("data size:" + obj.nifSize);
				ex.printStackTrace();
				throw new RuntimeException(s, ex);
			}
		}
		// set parents!
		for (NIFObject object : objects)
		{
			if (object instanceof NiNode)
			{
				NiNode node = (NiNode) object;
				for (Integer childID : node.childLinks)
				{
					if (childID != NIF_INVALID_LINK_ID)
					{
						if (objects.get(childID).parentIndex != -1)
						{
							System.err.println("WARNING: Node is parented by more than one other node.");
						}
						objects.get(childID).parentIndex = object.index;
					}
				}
			}
		}

	}

	static Map<String, Class<? extends NIFObject>> clazzMap = new TreeMap<>();

	static synchronized private Class<? extends NIFObject> getClazz(final String name) throws ClassNotFoundException
	{
		if (clazzMap.containsKey(name))
			return clazzMap.get(name);
		try
		{
			Class<? extends NIFObject> x = (Class<? extends NIFObject>) Class.forName(name);
			clazzMap.put(name, x);
			return x;
		} catch (Exception ex)
		{
			clazzMap.put(name, null);
			System.err.println("Unhandled nif type: " + name);
			return null;
		}
	}

	String loadString(final LittleEndianDataInputStream ds) throws IOException
	{
		int index = ds.readInt();
		if (index >= 0)
			return stringTable.get(index);
		return "";
	}

	private void loadObjectGroups(final LittleEndianDataInputStream dis) throws IOException
	{
		groupSizes.add(0);
		int numGroups = dis.readInt();
		for (int i = 0; i < numGroups; i++)
		{
			groupSizes.add(dis.readInt());
		}

	}

	private void loadStringTable(final LittleEndianDataInputStream dis) throws IOException
	{
		int numStrings = dis.readInt();
		int maxStringSize = dis.readInt();

		for (int i = 0; i < numStrings; i++)
		{
			int strLen = dis.readInt();
			if (strLen > 0)
				stringTable.add(readString(dis, strLen));
			else
				stringTable.add("");
		}

	}

	private void loadObjectSizes(final LittleEndianDataInputStream dis) throws IOException
	{
		for (int i = 0; i < numObjects; i++)
		{
			objects.get(i).nifSize = dis.readInt();
		}

	}

	private String readString(final LittleEndianDataInputStream dis, final int strLen) throws IOException
	{
		byte[] string = new byte[strLen];
		dis.readFully(string);
		return new String(string);
	}

	private void loadTypeNames(final LittleEndianDataInputStream dis) throws IOException
	{
		int numTypes = dis.readUnsignedShort();
		if (numTypes <= 0)
			throw new IllegalStateException("No type entries");
		List<String> types = new LinkedList<>();

		for (int i = 0; i < numTypes; i++)
		{
			int strLen = dis.readInt();
			if (strLen > 1024)
				throw new IllegalStateException("Too long string entry?");

			types.add(readString(dis, strLen));
		}

		//System.out.println(types);
		for (int i = 0; i < numObjects; i++)
		{
			int typeIndex = dis.readUnsignedShort();
			typeIndex &= ~32768;
			if (typeIndex > types.size())
				throw new IllegalStateException("TypeIndex out of bounds");

			objects.get(i).typeName = types.get(typeIndex);
		}

	}

	private void readMetaData(final LittleEndianDataInputStream dis) throws IOException
	{
		// TODO Auto-generated method stub

	}

	private void readHeader(final LittleEndianDataInputStream dis) throws IOException
	{
		header = readHeaderString(dis);
		if (!header.contains("Gamebryo"))
			throw new IllegalStateException("not a gamebryo file");
		fileVer = dis.readInt();
		endian = dis.readUnsignedByte();
		// TODO: handle endianess
		userVersion = dis.readInt();
		numObjects = dis.readInt();

		if (false)
			System.out.println("NIF version:" + ((fileVer >> 24) & 255) + "." + ((fileVer >> 16) & 255) + "."
					+ ((fileVer >> 8) & 255) + "." + (fileVer & 255));

	}

	private String readHeaderString(final LittleEndianDataInputStream dis) throws IOException
	{
		StringBuffer buffer = new StringBuffer();
		while (dis.available() > 0)
		{
			int ch = dis.readUnsignedByte();
			if (ch != 0x0A)
				buffer.append((char) ch);
			else
				break;
		}
		return buffer.toString();
	}

	public List<NiMesh> getMeshes()
	{
		return nifMeshes;
	}

	public void addMesh(final NiMesh niMesh)
	{
		nifMeshes.add(niMesh);

	}

	public void addTexture(final NiSourceTexture niSourceTexture)
	{
		nifTextures.add(niSourceTexture);

	}

	public <T extends NIFObject> T getObject(final int id)
	{
		return (T) getObjects().get(id);
	}
}
