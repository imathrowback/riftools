package org.imathrowback.telaradbdiff.diff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.imathrowback.datparser.CObject;

public class CObjectDiffer
{
	private static boolean isArray(final CObject obj)
	{
		int t = obj.type != null ? obj.type : -1;
		return t == 9 || t == 10 || t == 11 || t == 12;
	}

	private static Object getValue(final CObject obj)
	{
		if (obj.longValue != null)
			return obj.longValue;
		if (obj.intValue != null)
			return obj.intValue;
		if (obj.stringValue != null)
			return obj.stringValue;
		if (obj.objData != null)
			return obj.objData;
		if (obj.members != null && !obj.members.isEmpty())
			return null;
		try
		{
			Object v = obj.convert();
			if (v != null && !v.equals(""))
				return v;
		} catch (Exception e)
		{
		}
		return "?";
	}

	private static String getFieldName(final CObject obj)
	{
		if (obj.clazzName != null && !obj.clazzName.isEmpty())
			return obj.clazzName;
		if (obj.index > 0)
			return "field[" + obj.index + "]";
		return null;
	}

	private static String nodeLabel(final CObject obj)
	{
		return "[" + obj.index + "]";
	}

	public static List<FieldChange> diff(final CObject a, final CObject b)
	{
		return diff(a, b, "");
	}

	private static List<FieldChange> diff(final CObject a, final CObject b, final String prefix)
	{
		List<FieldChange> changes = new ArrayList<>();

		if (a == null && b == null)
			return changes;

		if (a == null)
		{
			String p = prefix.isEmpty() ? nodeLabel(b) : prefix + "." + nodeLabel(b);
			changes.add(new FieldChange(p, getFieldName(b), null, getValue(b), FieldChange.ChangeType.ADDED));
			return changes;
		}

		if (b == null)
		{
			String p = prefix.isEmpty() ? nodeLabel(a) : prefix + "." + nodeLabel(a);
			changes.add(new FieldChange(p, getFieldName(a), getValue(a), null, FieldChange.ChangeType.REMOVED));
			return changes;
		}

		if (isArray(a) || isArray(b))
		{
			boolean eq = arraysEqual(a, b);
			if (!eq)
			{
				String p = prefix.isEmpty() ? "(root)" : prefix;
				changes.add(new FieldChange(p, null, "array", "(changed)", FieldChange.ChangeType.CHANGED));
			}
			return changes;
		}

		if (isLeaf(a) && isLeaf(b))
		{
			Object va = getValue(a);
			Object vb = getValue(b);
			if (!safeEquals(va, vb) || !safeEquals(a.type, b.type))
			{
				String p = prefix.isEmpty() ? nodeLabel(a) : prefix;
				changes.add(new FieldChange(p, getFieldName(a), va, vb, FieldChange.ChangeType.CHANGED));
			}
			return changes;
		}

		Map<Integer, CObject> membersA = indexByExtraCode(a.members);
		Map<Integer, CObject> membersB = indexByExtraCode(b.members);

		for (Map.Entry<Integer, CObject> e : membersB.entrySet())
		{
			int idx = e.getKey();
			CObject childB = e.getValue();
			CObject childA = membersA.get(idx);

			String childPrefix = prefix.isEmpty() ? nodeLabel(childB) : prefix + "." + nodeLabel(childB);

			if (childA == null)
			{
				changes.add(new FieldChange(childPrefix, getFieldName(childB), null, getValue(childB),
						FieldChange.ChangeType.ADDED));
			} else
			{
				changes.addAll(diff(childA, childB, childPrefix));
			}
		}

		for (Map.Entry<Integer, CObject> e : membersA.entrySet())
		{
			int idx = e.getKey();
			if (!membersB.containsKey(idx))
			{
				CObject childA = e.getValue();
				String childPrefix = prefix.isEmpty() ? nodeLabel(childA) : prefix + "." + nodeLabel(childA);
				changes.add(new FieldChange(childPrefix, getFieldName(childA), getValue(childA), null,
						FieldChange.ChangeType.REMOVED));
			}
		}

		return changes;
	}

	private static boolean isLeaf(final CObject obj)
	{
		if (obj == null)
			return true;
		if (obj.members == null || obj.members.isEmpty())
			return true;
		if (obj.longValue != null || obj.intValue != null || obj.stringValue != null)
			return true;
		return false;
	}

	private static Map<Integer, CObject> indexByExtraCode(final List<CObject> members)
	{
		Map<Integer, CObject> map = new TreeMap<>();
		if (members == null)
			return map;
		for (CObject m : members)
		{
			int key = m.index;
			while (map.containsKey(key))
				key++;
			map.put(key, m);
		}
		return map;
	}

	private static boolean arraysEqual(final CObject a, final CObject b)
	{
		if (a == b)
			return true;
		if (a == null || b == null)
			return false;
		if (a.members == null && b.members == null)
			return true;
		if (a.members == null || b.members == null)
			return false;
		if (a.members.size() != b.members.size())
			return false;
		if (!safeEquals(a.type, b.type))
			return false;
		if (!safeEquals(a.extracode, b.extracode))
			return false;
		for (int i = 0; i < a.members.size(); i++)
		{
			Object va = getValue(a.members.get(i));
			Object vb = getValue(b.members.get(i));
			if (!safeEquals(va, vb))
				return false;
		}
		return true;
	}

	private static boolean safeEquals(final Object a, final Object b)
	{
		if (a == b)
			return true;
		if (a == null || b == null)
			return false;
		return a.equals(b);
	}
}
