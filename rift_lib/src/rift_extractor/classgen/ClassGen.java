package rift_extractor.classgen;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.CObjectConverter;
import org.imathrowback.datparser.DatParser;
import com.sun.jna.Native;
import com.thoughtworks.xstream.XStream;
import rift_extractor.classgen.classes._7630;
import static rift_extractor.classgen.ClassGenUtils.getClassName;

class GenClassDef
{
	List<String> fields = new LinkedList<>();
	public String name;
	public int superType = -1;
	public int classCode;

	public void setField(final int memberIndex, final String clazz)
	{
		String[] ary = fields.toArray(new String[Math.max(memberIndex + 1, fields.size())]);
		String clazzToWrite = clazz;

		if (ary[memberIndex] != null)
		{
			String[] parts = ary[memberIndex].split(" ");
			String existing = parts[0].trim();
			if (existing.endsWith(","))
				existing = (parts[0] + " " + parts[1]).trim();
			// always prefer anything over a boolean
			if (!existing.equals(clazz))
			{
				if (clazz.contains("Boolean"))
					clazzToWrite = existing;
				// Prefer long over anything else
				else if (clazz.contains("Long"))
					clazzToWrite = clazz;
				else if (clazz.contains("Long") && existing.contains("Integer"))
					clazzToWrite = clazz;
				else if (clazz.contains("Float") && existing.contains("Long"))
					clazzToWrite = existing;
				else if (clazz.contains("Integer") && existing.contains("Long"))
					clazzToWrite = existing;
				else if (clazz.contains("Double") && existing.contains("Long"))
					clazzToWrite = existing;
				else
				{
					if (clazz.startsWith("java.util.List") && existing.contains("java.util.List"))
					{
						int clazzType = Integer
								.parseInt(clazz.replace("_", "").substring(clazz.indexOf("<") + 1,
										clazz.indexOf(">") - 1));
						int existingType = Integer.parseInt(
								existing.replace("_", "").substring(existing.indexOf("<") + 1,
										existing.indexOf(">") - 1));

						// if the existing is a subtype, insert the clazz instead
						if (ClassGenUtils.hasSuperType(existingType) == clazzType)
							clazzToWrite = clazz;
						else if (ClassGenUtils.hasSuperType(clazzType) == existingType)
							clazzToWrite = existing;
						else
							System.out.println(
									"[" + name + "][" + memberIndex + "] attempt to put [" + clazz + "] into ["
											+ existing
											+ "]");
						// if the existing is a supertype of clazz, then ignore

					} else
						System.out.println(
								"[" + name + "][" + memberIndex + "] attempt to put [" + clazz + "] into [" + existing
										+ "]");
				}
			}
		}

		/*
		if (name.contains("601"))
			System.out.println("[" + memberIndex + "]: existing:" + ary[memberIndex] + " proposed:" + clazz + " chosen:"
					+ clazzToWrite);
					*/
		//System.out.println("store " + clazzToWrite + " into memberIndex " + memberIndex);
		ary[memberIndex] = (clazzToWrite + " " + ClassGen.getMemberName(classCode, memberIndex) + ";");
		fields = Arrays.asList(ary);
	}

}

public class ClassGen
{
	static String packageName = "rift_extractor.classgen.classes";
	static String classDir = "L:\\workspace\\rift_extractor\\src\\rift_extractor\\classgen\\classes\\";
	static Map<String, GenClassDef> classDefs = new TreeMap<String, GenClassDef>();

	public static void main(final String[] args) throws Exception
	{

		String testFile = "C:\\workspace\\rift_extractor\\world_6144_5120.cdr";
		String testFile2 = "C:\\workspace\\rift_extractor\\world_6144_5120.cdr";
		String testFile3 = "C:\\world1\\world_map.cdr";

		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		//stream.toXML(obj, new FileWriter("test1.xml"));
		Collection<File> files = FileUtils.listFiles(
				new File("L:\\telara_db_data\\7631\\"),
				TrueFileFilter.INSTANCE,
				TrueFileFilter.INSTANCE);

		//testFile = "L:\\telara_db_data\\113\\113_762104011";
		if (false)
		{
			for (File f : files)
			{
				try
				{
					doClassDefs(f, DatParser.processFileAndObject(new FileInputStream(f)));
				} catch (Exception ex)
				{
					System.err.println("Unable to process file:" + f + ":" + ex);
					ex.printStackTrace();
					break;
				}
			}

			writeClassDefs();
			return;
		} else
		{
			int i = 0;
			//TreeSet<String> str = new TreeSet<String>();
			List<Object> list = new LinkedList<>();
			for (File f : files)
			{
				//	f = new File(testFile);
				try
				{
					CObject obj = DatParser.processFileAndObject(new FileInputStream(f));
					Object o = ClassUtils.newClass(obj);

					_7630 c = (_7630) o;
					//str.add(c.name + ":" + c.command);
					list.add(c);
					if (false)
					{
						stream = new XStream();
						stream.autodetectAnnotations(true);
						//stream.toXML(o, new FileWriter("e:\\xml\\" + f.getName() + ".xml"));
						//str.add(stream.toXML(c));
					}
				} catch (Exception ex)
				{
					System.out.println("FAILED " + f + ":" + ex.getMessage());
					ex.printStackTrace();
					break;
				}

			}
			stream = new XStream();
			stream.autodetectAnnotations(true);
			stream.toXML(list, new FileOutputStream("colors.xml"));
			//			str.forEach(System.out::println);
			//CObject obj = DatParser.processFileAndObject(new FileInputStream(testFile));
		}

	}

	public static String getMemberName(final int clazzCode, final int memberIndex)
	{
		return ClassGenUtils.getMemberName(clazzCode, memberIndex);
	}

	private static void writeClassDefs() throws FileNotFoundException
	{
		for (GenClassDef def : classDefs.values())
		{
			int classCode = def.classCode;
			String classFile = classDir + getClassName(classCode) + ".java";
			System.out.println("writing class:" + classFile);

			try (PrintStream writer = new PrintStream(classFile))
			{
				writer.println("package " + packageName + ";");
				writer.println("import org.imathrowback.datparser.CObject;");
				writer.println("import static rift_extractor.classgen.ClassUtils.*;");
				writer.println("import rift_extractor.classgen.ClassUtils;");
				writer.println("");
				String superStr = "";
				if (def.superType != -1)
					superStr = "extends " + getClassName(def.superType);
				writer.println("/** " + classCode + " **/");
				writer.println(
						"@com.thoughtworks.xstream.annotations.XStreamAlias(\"" + getClassName(classCode) + "\")");
				writer.println("public class " + getClassName(classCode) + " " + superStr);
				writer.println("{");
				writer.println("\tpublic " + getClassName(classCode) + "(){}");

				for (int i = 0; i < def.fields.size(); i++)
				{
					String field = def.fields.get(i);
					if (field == null)
						// we don't know what type this field is as we never encountered it during deserialization, but we can infer it's existence based on the other known field indicies
						writer.println("\tObject " + getMemberName(classCode, i) + ";");
					else
					{
						String annotation = ClassGenUtils.getMemberAnnotation(classCode, i);
						// if the first member assume it should be an attribute
						if (i == 0 && (field.contains("Long") || field.contains("String")))
							annotation = "@com.thoughtworks.xstream.annotations.XStreamAsAttribute";
						if (!annotation.isEmpty())
						{
							// write the member as public
							writer.println("\t" + annotation);
						}
						writer.println("\tpublic " + field);
					}
				}

				writer.println("");
				writer.println("\tpublic void parse(CObject obj)");
				writer.println("\t{");
				writer.println("\t\tClassUtils.assertType(obj, " + classCode + ");\n");
				for (int i = 0; i < def.fields.size(); i++)
				{
					String cmd = "";
					String field = def.fields.get(i);
					if (field == null)
						field = "Object";
					if (field.contains("Vector3"))
					{
						cmd = getMemberName(classCode, i) + " = ClassUtils.vector3(obj," + i
								+ ");";

					} else if (field.contains("Vector4"))
					{
						cmd = getMemberName(classCode, i) + " = ClassUtils.vector4(obj," + i
								+ ");";

					}

					else if (field.contains("java.util.List<"))
					{
						int si = field.indexOf("<") + 1;
						int se = field.indexOf(">");
						String fieldType = field.substring(si, se);
						cmd = getMemberName(classCode, i) + " = ClassUtils.list(" + fieldType + ".class,obj," + i
								+ ");";
					} else
					{
						//String ft = field.split(" ")[0].trim();
						String[] parts = field.split(" ");
						String ft = parts[0].trim();
						if (ft.endsWith(","))
							ft = (parts[0] + " " + parts[1]);
						ft = ft.trim();

						if (ft.contains("<"))
						{
							ft = ft.substring(0, ft.indexOf("<"));
						}

						//ft = ClassGenUtils.getMemberType(classCode, i, ft);

						cmd = getMemberName(classCode, i) + " = ClassUtils.getFieldMember(" + ft + ".class,obj, " + i
								+ ");";
					}
					writer.println("\t\t" + cmd);
				}

				writer.println("\t}");

				writer.println("}");
			}

		}
	}

	private static void doClassDefs(final File f, final CObject obj) throws Exception
	{
		doClassDefs(f, obj, -1);
	}

	private static void doClassDefs(final File f, final CObject obj, final int superType) throws Exception
	{
		int classCode = obj.type;
		if (classCode < 13)
		{
			return;
			//throw new RuntimeException("Shouldn't be here with classcode:" + classCode);
		}

		GenClassDef def = classDefs.get(getClassName(classCode));
		if (def == null)
		{
			def = new GenClassDef();
			classDefs.put(getClassName(classCode), def);
		}
		def.classCode = classCode;
		def.name = getClassName(classCode);
		if (superType != -1)
			def.superType = superType;
		for (int i = 0; i < obj.members.size(); i++)
		{
			processMember(f, def, obj.get(i), obj.get(i).index);
		}
	}

	private static void processMember(final File f, final GenClassDef def, final CObject member, final int memberIndex)
			throws Exception
	{
		switch (member.type)
		{
			case 12:
				if (member.members.size() >= 2)
				{
					String keyType = member.get(0).convert().getClass().getName();
					int valueType = member.get(1).type;

					doClassDefs(f, member.get(1));

					def.setField(memberIndex, "java.util.HashMap<" + keyType + "," + getClassName(valueType) + ">");
				} else
				{
					def.setField(memberIndex, "java.util.HashMap<Integer, Object>");
				}
				break;
			case 11: // array of "objects". This appears to be a generic array or at least, one holding supertypes
				int size = member.extracode;
				int cType = member.get(0).type;
				String childType = getClassName(cType);
				if (cType < 13)
					childType = member.get(0).convert().getClass().getName();

				int superType = -1;

				Set<Integer> ttypes = new TreeSet<>();
				for (int x = 0; x < size; x++)
					ttypes.add(member.get(x).type);
				if (ttypes.size() > 1) // we need a supertype
				{
					superType = ClassGenUtils.getSupertype(member.get(0).type);
					childType = getClassName(superType);

					for (int x = 0; x < size; x++)
					{
						if (member.get(x).type > 13)
							ClassGenUtils.registerNewSupertype(member.get(x).type, superType);
					}

				}
				if (childType.contains("Float") && size == 3)
				{
					def.setField(memberIndex, "rift_extractor.classgen.Vector3");
				} else if (childType.contains("Float") && size == 4)
				{
					def.setField(memberIndex, "rift_extractor.classgen.Vector4");

				} else
					def.setField(memberIndex, "java.util.List<" + childType + ">");

				for (int x = 0; x < size; x++)
				{
					if (member.get(x).type > 13)
						doClassDefs(f, member.get(x), superType);
				}
				break;
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:

				CObjectConverter conv = ClassGenUtils.getMemberType(def.classCode, memberIndex, member.getConvertor());
				try
				{
					Object value = conv.convert(member);
					def.setField(memberIndex, value.getClass().getName());
				} catch (EOFException e)
				{

					System.err.println(
							"WARN: Unable to use convertor " + conv.getClass().getSimpleName() + " to convert member["
									+ memberIndex + "][" + member.getConvertor().getClass().getSimpleName()
									+ "] of class " + def.classCode + " due to end of file exception");
					Object value = member.convert();
					def.setField(memberIndex, value.getClass().getName());
				}
				break;
			default:
				def.setField(memberIndex, getClassName(member.type));
				doClassDefs(f, member);
				break;
		}

	}

}
