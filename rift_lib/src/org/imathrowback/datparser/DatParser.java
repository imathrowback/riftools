package org.imathrowback.datparser;

import rift_extractor.util.Leb128;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import com.google.common.io.LittleEndianDataInputStream;

public class DatParser
{

	public static BitResult splitCode(final int in)
	{
		int code = in & 7;
		int data = in >> 3;

		if (code == 7)
		{
			data = in >> 6;
			int v5 = (in >> 3) & 7;
			if (v5 <= 4)
			{
				code = v5 + 8;
				return new BitResult(code, data);
			}
		} else if (code <= 7)
		{
			return new BitResult(code, data);
		}

		return null;
	}

	public static String toLeb128(final int x)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try
		{
			Leb128.writeUnsignedLeb128(bos, x);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Hex.encodeHexString(bos.toByteArray());
	}

	static int[] readCodeThenReadTwice(final LittleEndianDataInputStream dis, final int indent) throws Exception
	{
		int result = Leb128.readUnsignedLeb128_X(dis).get();
		String s = ("READX bytes[" + result + "][" + toLeb128(result) + "] -> " +
				result);
		//log(s, indent);
		if (result == 0)
			return null;

		BitResult a = splitCode(result);
		if (a == null)
			return null;

		BitResult b = splitCode(a.data);

		return new int[] { a.code, b.code, b.data };

	}

	public static BitResult readCodeAndExtract(final LittleEndianDataInputStream dis, final int indent) throws Exception
	{
		int byteX = Leb128.readUnsignedLeb128_X(dis).get();

		log("byteX:" + byteX, indent);
		BitResult result = splitCode(byteX);
		result.b = byteX;
		String s = ("READ bytes[" + byteX + "][" + toLeb128(byteX) + "] -> " +
				result);
		//log(s, indent);
		if (byteX == 0)
			return null;
		return result;
	}

	public static boolean debug = false;

	public static void log(final String s, final int indent)
	{
		String ss = StringUtils.leftPad(s, s.length() + indent, '-');
		//UnkMap.log.println(ss);
		if (debug)
			System.out.println(ss);
		//UnkMap.log.flush();

	}

	static void loge(final String s, final int indent)
	{
		String ss = StringUtils.leftPad(s, s.length() + indent, '-');
		if (debug)
			System.out.println(ss);
		//UnkMap.log.println(ss);
		//UnkMap.log.flush();

	}

	public static long readUnsignedVarLong(final DataInput in, final ByteArrayOutputStream bos) throws IOException
	{
		long value = 0L;
		int i = 0;
		long b;
		while (true)
		{
			int bb = in.readByte();
			if (bos != null)
				bos.write(bb);
			b = bb;
			if ((b & 0x80L) != 0)
			{
				value |= (b & 0x7F) << i;
				i += 7;
				if (i > 63)
				{
					throw new IllegalArgumentException("Variable length quantity is too long");
				}
				continue;
			}
			break;
		}
		return value | (b << i);
	}

	/**
	 * @param in to read bytes from
	 * @return decode value
	 * @throws IOException if {@link DataInput} throws {@link IOException}
	 * @throws IllegalArgumentException if variable-length value does not terminate
	 *             after 9 bytes have been read
	 * @see #writeSignedVarLong(long, DataOutput)
	 */
	public static long readSignedVarLong(final DataInput in, final ByteArrayOutputStream bos) throws IOException
	{
		long raw = readUnsignedVarLong(in, bos);
		// This undoes the trick in writeSignedVarLong()
		long temp = (((raw << 63) >> 63) ^ raw) >> 1;
		// This extra step lets us deal with the largest signed values by treating
		// negative results from read unsigned methods as like unsigned values
		// Must re-flip the top bit if the original read value had it set.
		return temp ^ (raw & (1L << 63));
	}

	public static boolean handleCode(final CObject parent, final LittleEndianDataInputStream dis, final int datacode,
			final int extraData,
			final int indent)
			throws Exception
	{
		//parent.index = codedata;
		switch (datacode)
		{
			case 0:
				log("handleCode:" + datacode + ", possibly boolean 0", indent);
				parent.addMember(new CObject(0, new byte[] { 0x0 }, extraData, new CBooleanConvertor()));
				return true;
			case 1:
				log("handleCode:" + datacode + ", possibly boolean 1", indent);
				if (parent.type != null && (parent.type == 127))
					parent.addMember(new CObject(1, new byte[] { 0x1 }, extraData, new CLongConvertor()));
				else
					parent.addMember(new CObject(1, new byte[] { 0x1 }, extraData, new CBooleanConvertor()));
				return true;
			case 2:
			{
				// Variable length encoded long
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				long x = readUnsignedVarLong(new DataInputStream(dis), bos);
				parent.addMember(new CObject(2, bos.toByteArray(), extraData, new CUnsignedVarLongConvertor()));
				log("handleCode:" + datacode + ", unsigned long: " + x, indent);
				return true;
			}
			case 3:
			{
				// Variable length encoded long
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				long x = readSignedVarLong(new DataInputStream(dis), bos);
				parent.addMember(new CObject(3, bos.toByteArray(), extraData, new CSignedVarLongConvertor()));
				log("handleCode:" + datacode + ", signed long: " + x, indent);
				return true;
			}
			case 4:
			{
				// 4 bytes, int maybe?
				log("handleCode:" + datacode + ", int?", indent);
				byte[] d = new byte[4];
				dis.read(d);
				parent.addMember(new CObject(4, d, extraData, ClassDefaults.getConv(parent.type, 4)));
				return true;
			}
			case 5:
				// 8 bytes, double maybe?

				log("handleCode:" + datacode + ", long?", indent);
				byte[] d = new byte[8];
				dis.read(d);

				if (parent.type != null && (parent.type == 4086))
				{

					parent.addMember(new CObject(5, d, extraData, new CFileTimeConvertor()));
					//parent.addMember(readFileTime(diss));
				} else
				{
					parent.addMember(new CObject(5, d, extraData, ClassDefaults.getConv(parent.type, 5)));
				}
				return true;

			case 6:
				log("handleCode:" + datacode + ", string/data?", indent);
				// string or data
				int strLength = Leb128.readUnsignedLeb128_X(dis).get();
				byte[] data = new byte[strLength];
				dis.read(data);
				String newString = new String(data);

				parent.addMember(new CObject(6, data, extraData, new CStringConvertor()));
				/*
				//for (int i = 0; i < newString.length(); i++)
				//if (!Character.isJavaLetterOrDigit(newString.charAt(i)))
				if (newString.length() > 100 && false)
				{
					log("string: ####BINARY DATA BLOB####", indent + 1);
					FileUtils.writeByteArrayToFile(new File("blob.data"), data);
					parent.addMember("####BINARY DATA BLOB (" + strLength + " bytes)####");
					return true;
				}
				log("string:" + newString, indent + 1)
				//parent.addMember(newString);
				parent.addMember(new Code6(newString));
				*/
				return true;
			case 10:

				//System.err.println("CASE 10>>>>");
				//System.exit(1);
			case 9:
			{
				CObject obj = new CObject(datacode, null, extraData, null);
				parent.addMember(obj);
				obj.parent = parent;

				if (datacode == 10)
				{
					// NEW OBJECT
					int objclass = Leb128.readUnsignedLeb128_X(dis).get();
					obj.type = objclass;
					if (objclass > 0xFFFF || objclass == 0)
					{
						loge("bad value code 10 - objClass:" + objclass, indent);
						//return false;
					}
				}
				log("handleCode:" + datacode + ", array: " + obj.type, indent + 1);
				// array?
				BitResult rr;
				int x = 0;
				do
				{
					rr = readCodeAndExtract(dis, indent + 2);
					if (rr == null)
					{
						//loge("WARN: rr null for code [" + datacode + "][" + x + "], assume it is a boolean", indent);
						// KLUDGE - Treat as a boolean
						rr = new BitResult(0, 0);
						//break;
					}
					if (rr.code == 8)
					{
						log("end object, read [" + x + "], objects", indent + 1);
						return true;
					}
					log("handle code[" + rr.code + "]", indent + 1);
					x++;
				} while (handleCode(obj, dis, rr.code, rr.data, indent + 2));
				loge("overun while code [" + datacode + "]:" + rr, indent + 1);
				System.err.flush();
				System.out.flush();
				//Thread.dumpStack();
				//System.exit(1);
				return false;
			}
			case 11:
			{
				// array?
				log("handlecode:" + datacode + ", get data", indent + 1);
				BitResult r = readCodeAndExtract(dis, indent + 1);
				if (r == null)
				{
					loge("bad bitresult code 11", indent + 1);
					return false;
				}
				log("bitresult:" + r, indent + 1);
				int count = r.data;
				if (count == 0)
					return true;
				int i = 0;
				CObject obj = new CObject(datacode, null, count, null);
				obj.index = extraData;
				parent.addMember(obj);

				//if (count == 24)
				//	System.exit(1);
				int codeOfChildren = r.code;
				//obj.type = codeOfChildren;
				log("array size: " + count + " of type[" + codeOfChildren + "]", indent + 1);
				while (handleCode(obj, dis, codeOfChildren, i, indent + 2))
				{
					log("code 11: handled  item[" + i + " of " + count + "], childcode[" + codeOfChildren + "]",
							indent + 1);
					if (++i >= count)
						return true;
				}
				loge("overun while code 11 [i == " + i + ", count=" + count, indent + 1);
				System.err.flush();
				System.out.flush();
				System.err.println("ERROR: OVERUN");
				return false;

			}
			case 12:
			{
				log("handleCode:" + datacode + ", array3?", indent);
				int[] result = readCodeThenReadTwice(dis, indent + 1);

				int count = result[2];
				if (count == 0)
					return true;
				CObject obj = new CObject(datacode, null, count, null);
				obj.index = extraData;
				parent.addMember(obj);
				log("handle multidimension array?: " + Arrays.toString(result), indent + 1);
				int i = 0;
				int ii = 0;
				while (handleCode(obj, dis, result[0], ii++, indent + 1)
						&& handleCode(obj, dis, result[1], ii++, indent + 1))
				{
					if (++i >= count)
						return true;
				}
				loge("overun while code 12", indent + 1);
				System.err.flush();
				System.out.flush();
				System.err.println("overun while code 12");
				return false;
			}
			case 8:
				log("handleCode:" + datacode + ", end of object", indent);

				// END OF OBJECT
				return false;
			default:
				loge("unk code:" + datacode, indent);
				System.exit(1);
		}

		loge("exit case", indent);
		System.err.flush();
		System.out.flush();
		System.exit(1);
		return false;
	}

	public static CObject processFileAndObject(final InputStream is) throws Exception
	{
		return processFileAndObject(is, null);
	}

	public static CObject processFileAndObject(final byte[] data)
	{
		try
		{
			return processFileAndObject(new ByteArrayInputStream(data), null);
		} catch (Exception ex)
		{
			return null;
		}
	}

	public static CObject processFileAndObject(final InputStream is, final DataModel dataModel)
			throws Exception
	{
		return processFileAndObject(is, dataModel, -1);
	}

	public static boolean checkForObject(final InputStream is, final int expectedCode) throws Exception
	{
		LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is);

		Optional<Integer> res = Leb128.readUnsignedLeb128_X(dis);
		if (res.isPresent())
			return (expectedCode == res.get());
		return false;
	}

	public static CObject processFileAndObject(final InputStream is, final DataModel dataModel, final int expectedCode)
			throws Exception
	{
		LittleEndianDataInputStream dis = new LittleEndianDataInputStream(is);

		int code1 = Leb128.readUnsignedLeb128_X(dis).get();
		DatParser.log("class code:[" + DatParser.toLeb128(code1) + "]" + code1, 0);
		if (expectedCode > 0 && expectedCode != code1)
			return null;

		CObject root = new CObject(code1, null, code1, null);
		root.type = code1;
		boolean r;
		int i = 0;
		do
		{
			BitResult result = DatParser.readCodeAndExtract(dis, 0);
			/** handle special case enum */
			if (result == null && code1 == 8 && i == 0)
			{
				if (result == null)
					result = new BitResult(0, 0);
			}
			/** handle special case boolean */
			else if (result == null && i == 0)
			{
				if (result == null)
					result = new BitResult(0, 0);
			} else if (result == null)
				throw new IllegalStateException("Unable to process result, class code:" + code1);
			DatParser.log("do member " + (++i) + ": with code:" + result, 0);

			r = DatParser.handleCode(root, dis, result.code, result.data, 1);
		} while (r);

		if (dataModel != null)
			guessNames(root, dataModel);

		return root;
	}

	private static void guessNames(final CObject node, final DataModel dataModel)
	{
		Map<Integer, String> fields = new TreeMap<>();
		Clazz clazz = dataModel.getClazz(node.type.longValue());
		if (clazz != null && node.type > 20)
		{
			node.clazzName = clazz.name;
			fields = clazz.fields;
		}

		for (CObject o : node.members)
		{
			guessNames(o, dataModel);
			if (fields.containsKey(o.index))
				o.clazzName = fields.get(o.index);
		}
	}
}
