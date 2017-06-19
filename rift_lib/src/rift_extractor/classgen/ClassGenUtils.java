package rift_extractor.classgen;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

import org.imathrowback.datparser.CFloatConvertor;
import org.imathrowback.datparser.CIntConvertor;
import org.imathrowback.datparser.CObjectConverter;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class ClassGenUtils
{
	static Integer superType = 999500;
	static TreeMap<Integer, Integer> superTypeList = new TreeMap<>();

	public static int hasSuperType(final int clazz)
	{
		if (superTypeList.containsKey(clazz))
			return superTypeList.get(clazz);
		return -1;
	}

	public static void registerNewSupertype(final int clazz, final int superType)
	{
		if (superTypeList.containsKey(clazz))
		{
			int existing = superTypeList.get(clazz);
			if (existing != superType)
				throw new IllegalArgumentException("class[" + clazz + "] already assigned supertype " + existing);
			return;
		}
		superTypeList.put(clazz, superType);

		writeSuperType(superType);
	}

	private static void writeSuperType(final int superType)
	{
		String classFile = ClassGen.classDir + getClassName(superType) + ".java";
		try (PrintStream writer = new PrintStream(classFile))
		{
			writer.println("package " + ClassGen.packageName + ";");
			writer.println("import org.imathrowback.datparser.CObject;");
			writer.println("import static rift_extractor.classgen.ClassUtils.*;");
			writer.println("import rift_extractor.classgen.ClassUtils;");
			writer.println("abstract public class _" + superType + " {}");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getSupertype(final int clazz)
	{
		if (superTypeList.containsKey(clazz))
			return superTypeList.get(clazz);
		registerNewSupertype(clazz, superType);
		return superType++;

	}

	public static CObjectConverter getMemberType(final int classCode, final int memberIndex,
			final CObjectConverter defaultConv)
	{
		Map<String, CObjectConverter> map = new TreeMap<>();
		map.put("603:5", new CFloatConvertor());
		map.put("115:39", new CIntConvertor());
		map.put("7703:0", new CIntConvertor());
		map.put("1894:0", new CIntConvertor());
		return map.getOrDefault(classCode + ":" + memberIndex, defaultConv);
	}

	public static String getMemberAnnotation(final int clazzCode, final int memberIndex)
	{
		Map<String, String> map = new TreeMap<>();
		map.put("600:1", "@" + XStreamAsAttribute.class.getName());
		map.put("107:1", "@" + XStreamOmitField.class.getName()); // ignore the umbra block, we don't care
		map.put("306:0", "@" + XStreamAsAttribute.class.getName());
		return map.getOrDefault(clazzCode + ":" + memberIndex, "");
	}

	public static String getMemberName(final int clazzCode, final int memberIndex)
	{
		Map<String, String> map = new TreeMap<>();
		map.put("107:0", "instances");
		map.put("107:1", "umbraDataBlock");
		map.put("600:0", "id");
		map.put("600:1", "name");
		map.put("603:0", "modelReference");
		map.put("603:3", "position");
		map.put("603:4", "rotation");
		map.put("603:5", "scale");
		map.put("603:9", "position2");
		map.put("306:0", "string");
		return map.getOrDefault(clazzCode + ":" + memberIndex, "unk" + memberIndex);
	}

	public static String getClassName(final int typeCode)
	{
		Map<Integer, String> map = new TreeMap<>();
		map.put(306, "CString");
		map.put(107, "MapData");
		map.put(4426, "InstanceDefinition");
		map.put(4479, "SpawnPoint");
		map.put(7703, "ID");
		map.put(628, "HKXAndNIF");
		map.put(600, "ObjectInstance");
		map.put(603, "MapObjectTransform");
		map.put(4427, "InstanceDifficulty");
		return map.getOrDefault(typeCode, "_" + typeCode);
	}

}
