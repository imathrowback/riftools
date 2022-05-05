package rift_extractor.classgen;

import java.lang.reflect.Method;
import java.util.*;

import org.imathrowback.datparser.*;

public class ClassUtils
{
	public static <T> T newClass(final Class<T> type, final CObject obj)
	{
		try
		{
			T newInst = type.newInstance();
			Method method = type.getMethod("parse", CObject.class);
			method.invoke(newInst, obj);
			return newInst;
		} catch (InstantiationException ex)
		{
			System.err.println("can't instantiate class:" + type);
			throw new RuntimeException(ex);

		}

		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public static <T> T newClass(final CObject obj)
	{
		try
		{
			if (obj.type == 8)
				return null;
			Class<T> x = (Class<T>) Class.forName(ClassGen.packageName + "." + ClassGenUtils.getClassName(obj.type));
			return newClass(x, obj);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public static void assertType(final CObject obj, final int type)
	{
		if (obj.type != type)
			throw new IllegalArgumentException("expected object " + type + " got " + obj.type);
	}

	public static <T> T[] array(final Class<T> type, final CObject obj)
	{
		List<T> ary = new LinkedList<>();

		for (int i = 0; i < obj.extracode; i++)
		{
			CObject child = obj.get(i);

		}

		return (T[]) ary.toArray();
	}

	public static Vector3 vector3(final CObject parentObj, final int memberIndex)
	{
		try
		{
			for (CObject obj : parentObj.members)
			{
				if (obj.index == memberIndex)
				{
					CFloatConvertor conv = new CFloatConvertor();
					return new Vector3(conv.convert(obj.get(0)), conv.convert(obj.get(1)), conv.convert(obj.get(2)));
				}
			}
			return null;
			//throw new IllegalArgumentException("Not a vector");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public static Vector4 vector4(final CObject parentObj, final int memberIndex)
	{
		try
		{
			for (CObject obj : parentObj.members)
			{
				if (obj.index == memberIndex)
				{
					CFloatConvertor conv = new CFloatConvertor();
					return new Vector4(conv.convert(obj.get(0)), conv.convert(obj.get(1)), conv.convert(obj.get(2)),
							conv.convert(obj.get(3)));
				}
			}
			return null;
			//throw new IllegalArgumentException("Not a vector");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public static <T> List<T> list(final Class<T> type, final CObject parentObj, final int memberIndex)
	{
		List<T> ary = new LinkedList<>();

		for (CObject obj : parentObj.members)
		{
			if (obj.index == memberIndex)
			{
				for (int i = 0; i < obj.extracode; i++)
				{
					CObject child = obj.get(i);
					if (child.type < 13)
					{
						try
						{
							ary.add((T) child.convert());
						} catch (ClassCastException ex)
						{
							System.err.println("Unable to cast " + child + " to type:" + type);
							throw ex;
						}
					} else
					{
						try
						{
							ary.add(newClass(child));
						} catch (Exception ex)
						{
							ary.add(null);
						}
					}

				}
				return ary;
			}

		}
		return null;//Collections.emptyList();
		//throw new IllegalStateException("unable to find field [" + memberIndex + "]");

	}

	public static <T> T getFieldMember(final Class<T> clazz, final CObject obj, final int i)
	{
		for (CObject o : obj.members)
		{
			if (o.index == i)
			{
				Object t = o.convert();

				/*System.out.println(
						"[" + obj.type + "] clazz[" + clazz.getSimpleName() + "], i:" + i + " read actual type:"
								+ t.getClass()
								+ " of type:" + o.type);
								*/
				if (clazz.getSimpleName().startsWith("_") || o.type > 12)
					return newClass(o);
				try
				{
					String toStr = "" + t;

					if (clazz.isAssignableFrom(HashMap.class))
					{
						return map(clazz, o);
					} else if (clazz.isAssignableFrom(Float.class))
					{
						return (T) new CFloatConvertor().convert(o);
					}

					else if (clazz.isAssignableFrom(Integer.class))
					{
						if (o.getConvertor() instanceof CFloatConvertor)
						{
							return (T) new CIntConvertor().convert(o);
						} else
							return (T) Integer.valueOf(Integer.parseInt(toStr));
					} else if (clazz.isAssignableFrom(Boolean.class))
					{
						if (o.getConvertor() instanceof CLongConvertor)
						{
							Long x = (Long) o.convert();
							if (x == 0)
								return (T) Boolean.FALSE;
							else if (x == 1)
								return (T) Boolean.TRUE;
							throw new Exception("Unable to convert LONG [" + x + "] to BOOLEAN");
						}
					} else if (clazz.isAssignableFrom(Long.class))
					{
						if (o.getConvertor() instanceof CBooleanConvertor)
						{
							toStr = (Boolean) t ? "1" : "0";

						} else if (o.getConvertor() instanceof CFloatConvertor)
						{
							toStr = "" + new CIntConvertor().convert(o);
						} else if (o.getConvertor() instanceof CDoubleConvertor)
						{
							toStr = "" + new CIntConvertor().convert(o);
						}
						return (T) Long.valueOf(Long.parseLong(toStr));
					}
				} catch (Exception ex)
				{
					//System.err.println("WARN: Unable to convert o[" + o.type + "][" + o.toString() + "] to " + clazz);
					//ex.printStackTrace();
					//throw ex;
				}
				//System.out.println("return type:" + t.getClass());
				if (t.getClass() == Object.class)
				{
					//System.err.println("WARN: Unable to convert o[" + o.type + "][" + o.toString() + "] to " + clazz);
				}
				return (T) t;
			}
		}
		try
		{
			return clazz.newInstance();
		} catch (Exception ex)
		{
			return null;
		}
	}

	public static <T> T map(final Class<T> clazz, final CObject obj) throws Exception
	{
		Map map = (Map) clazz.newInstance();

		for (int i = 0; i < obj.members.size(); i += 2)
		{
			Object key = obj.get(i).convert();
			Object value = newClass(obj.get(i + 1));
			map.put(key, value);
		}

		return (T) map;
	}

}
