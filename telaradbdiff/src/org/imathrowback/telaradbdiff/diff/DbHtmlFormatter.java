package org.imathrowback.telaradbdiff.diff;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.imathrowback.datparser.CFileTimeConvertor;
import org.imathrowback.datparser.CObject;
import org.imathrowback.telaradbdiff.diff.FieldChange.ChangeType;

public class DbHtmlFormatter
{
	public static String format(final DbDiffResult result)
	{
		StringBuilder sb = new StringBuilder();
		emitHead(sb);
		emitBody(sb, result);
		sb.append("</html>\n");
		return sb.toString();
	}

	private static void emitHead(final StringBuilder sb)
	{
		sb.append("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
		sb.append("<meta charset=\"UTF-8\">\n");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
		sb.append("<title>TelaraDB Diff Report</title>\n");
		emitStyles(sb);
		sb.append("</head>\n");
	}

	private static void emitStyles(final StringBuilder sb)
	{
		sb.append("<style>\n");
		sb.append("* { margin: 0; padding: 0; box-sizing: border-box; }\n");
		sb.append("body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; ");
		sb.append("background: #0d1117; color: #c9d1d9; padding: 24px; }\n");
		sb.append("h1 { font-size: 24px; font-weight: 600; margin-bottom: 4px; color: #f0f6fc; }\n");
		sb.append(".subtitle { color: #8b949e; font-size: 13px; margin-bottom: 24px; }\n");

		sb.append(".cards { display: grid; grid-template-columns: repeat(auto-fit, minmax(140px, 1fr)); ");
		sb.append("gap: 12px; margin-bottom: 28px; }\n");
		sb.append(".card { background: #161b22; border: 1px solid #30363d; border-radius: 8px; ");
		sb.append("padding: 16px; text-align: center; }\n");
		sb.append(".card .num { font-size: 28px; font-weight: 700; line-height: 1.2; }\n");
		sb.append(".card .label { font-size: 12px; color: #8b949e; text-transform: uppercase; ");
		sb.append("letter-spacing: 0.5px; margin-top: 4px; }\n");
		sb.append(".card.card-added { border-color: #238636; }\n");
		sb.append(".card.card-added .num { color: #3fb950; }\n");
		sb.append(".card.card-deleted { border-color: #da3633; }\n");
		sb.append(".card.card-deleted .num { color: #f85149; }\n");
		sb.append(".card.card-changed { border-color: #d29922; }\n");
		sb.append(".card.card-changed .num { color: #d29922; }\n");
		sb.append(".card.card-total { border-color: #30363d; }\n");
		sb.append(".card.card-total .num { color: #f0f6fc; }\n");

		sb.append(".tabs { display: flex; gap: 4px; margin-bottom: 16px; ");
		sb.append("border-bottom: 1px solid #30363d; padding-bottom: 0; flex-wrap: wrap; }\n");
		sb.append(".tab { padding: 8px 18px; font-size: 13px; font-weight: 500; cursor: pointer; ");
		sb.append("border: 1px solid transparent; border-bottom: none; border-radius: 6px 6px 0 0; ");
		sb.append("color: #8b949e; background: transparent; transition: all .15s; }\n");
		sb.append(".tab:hover { color: #c9d1d9; background: #161b22; }\n");
		sb.append(".tab.active { color: #f0f6fc; background: #161b22; border-color: #30363d; ");
		sb.append("margin-bottom: -1px; }\n");
		sb.append(".tab .badge { display: inline-block; margin-left: 6px; padding: 0 7px; ");
		sb.append("font-size: 11px; font-weight: 600; border-radius: 10px; line-height: 18px; }\n");
		sb.append(".tab-panel { display: none; }\n");
		sb.append(".tab-panel.active { display: block; }\n");

		sb.append(".search { margin-bottom: 12px; }\n");
		sb.append(".search input { width: 100%; padding: 8px 12px; font-size: 14px; ");
		sb.append("background: #0d1117; border: 1px solid #30363d; border-radius: 6px; ");
		sb.append("color: #c9d1d9; outline: none; }\n");
		sb.append(".search input:focus { border-color: #58a6ff; }\n");

		sb.append("table { width: 100%; border-collapse: collapse; font-size: 13px; }\n");
		sb.append("th { background: #161b22; padding: 8px 10px; text-align: left; font-weight: 600; ");
		sb.append("color: #8b949e; border-bottom: 1px solid #30363d; cursor: pointer; ");
		sb.append("user-select: none; white-space: nowrap; }\n");
		sb.append("th:hover { color: #c9d1d9; }\n");
		sb.append("td { padding: 6px 10px; border-bottom: 1px solid #21262d; ");
		sb.append("font-family: 'SFMono-Regular', Consolas, 'Liberation Mono', monospace; font-size: 12px; }\n");
		sb.append("tr:hover td { background: #161b22; }\n");
		sb.append(".row-added td:first-child { border-left: 3px solid #238636; }\n");
		sb.append(".row-deleted td:first-child { border-left: 3px solid #da3633; }\n");
		sb.append(".row-changed td:first-child { border-left: 3px solid #d29922; }\n");
		sb.append(".empty { text-align: center; padding: 40px; color: #484f58; font-size: 14px; }\n");

		sb.append(".fc { font-size: 12px; color: #c9d1d9; padding: 2px 0; }\n");
		sb.append(".fc-path { color: #8b949e; }\n");
		sb.append(".fc-old { color: #f85149; }\n");
		sb.append(".fc-new { color: #3fb950; }\n");
		sb.append(".fc-arrow { color: #484f58; padding: 0 6px; }\n");
		sb.append(".fc-added { color: #3fb950; }\n");
		sb.append(".fc-removed { color: #f85149; }\n");
		sb.append(".fc-changed { color: #d29922; }\n");

		sb.append(".entry-toggle { cursor: pointer; user-select: none; }\n");
		sb.append(".entry-toggle:hover { color: #58a6ff; }\n");
		sb.append(".entry-details { display: none; padding: 8px 0 8px 16px; }\n");
		sb.append(".entry-details.open { display: block; }\n");

		sb.append(".tag { display: inline-block; padding: 1px 6px; font-size: 10px; font-weight: 600; ");
		sb.append("border-radius: 4px; margin-right: 3px; }\n");
		sb.append(".tag-added { background: #23863622; color: #3fb950; }\n");
		sb.append(".tag-deleted { background: #da363322; color: #f85149; }\n");
		sb.append(".tag-changed { background: #d2992222; color: #d29922; }\n");

		sb.append(".field-table { width: 100%; margin-top: 4px; }\n");
		sb.append(".field-table td { padding: 3px 8px; border: none; font-size: 12px; }\n");
		sb.append(".field-table tr:hover td { background: #0d1117; }\n");
		sb.append(".obj-node { padding: 1px 0; font-family: 'SFMono-Regular', Consolas, 'Liberation Mono', monospace; font-size: 11px; line-height: 1.5; }\n");
		sb.append(".obj-type { color: #58a6ff; }\n");
		sb.append(".obj-val { color: #c9d1d9; }\n");
		sb.append(".obj-array { color: #484f58; font-style: italic; font-size: 10px; }\n");
		sb.append(".obj-label { color: #8b949e; font-size: 11px; font-weight: 600; text-transform: uppercase; letter-spacing: 0.5px; margin: 8px 0 4px 0; }\n");
		sb.append(".obj-null { color: #484f58; font-style: italic; }\n");
		sb.append(".id-num { color: #8b949e; font-weight: normal; }\n");
		sb.append(".diff-removed { background: #da363311; }\n");
		sb.append(".diff-removed .obj-type { text-decoration: line-through; color: #f85149; }\n");
		sb.append(".diff-added { background: #23863611; }\n");
		sb.append(".diff-added .obj-type { color: #3fb950; }\n");
		sb.append(".diff-changed { background: #d2992211; }\n");
		sb.append(".diff-changed .obj-type { color: #d29922; }\n");
		sb.append(".diff-old-inline { color: #f85149; text-decoration: line-through; margin-right: 4px; }\n");
		sb.append(".diff-new-inline { color: #3fb950; }\n");
		sb.append(".diff-arrow { color: #484f58; margin: 0 6px; }\n");
		sb.append(".diff-prefix { font-weight: bold; margin-right: 4px; }\n");
		sb.append(".obj-tuple { color: #c9d1d9; }\n");
		sb.append(".obj-date-hint { color: #58a6ff; font-style: italic; font-size: 10px; }\n");

		sb.append("@media (max-width: 768px) { body { padding: 12px; } ");
		sb.append(".cards { grid-template-columns: repeat(3, 1fr); } ");
		sb.append("td, th { padding: 6px; } }\n");
		sb.append("</style>\n");
	}

	private static void emitBody(final StringBuilder sb, final DbDiffResult result)
	{
		sb.append("<body>\n");
		sb.append("<h1>TelaraDB Diff Report</h1>\n");
		sb.append("<p class=\"subtitle\">");
		sb.append(formatNumber(result.getTotalOld())).append(" entries &rarr; ");
		sb.append(formatNumber(result.getTotalNew())).append(" entries");
		sb.append("</p>\n");

		emitCards(sb, result);
		emitTabs(sb);
		emitPanel(sb, "added", "Added", result.getAdded());
		emitPanel(sb, "deleted", "Deleted", result.getDeleted());
		emitChangedPanel(sb, result.getChanged());
		emitScript(sb, result);
		sb.append("</body>\n");
	}

	private static void emitCards(final StringBuilder sb, final DbDiffResult result)
	{
		sb.append("<div class=\"cards\">\n");
		emitCard(sb, "total", "Total A", formatNumber(result.getTotalOld()));
		emitCard(sb, "total", "Total B", formatNumber(result.getTotalNew()));
		emitCard(sb, "added", "Added", formatNumber(result.getAdded().size()));
		emitCard(sb, "deleted", "Deleted", formatNumber(result.getDeleted().size()));
		emitCard(sb, "changed", "Changed", formatNumber(result.getChanged().size()));
		sb.append("</div>\n");
	}

	private static void emitCard(final StringBuilder sb, final String cls, final String label, final String num)
	{
		sb.append("<div class=\"card card-").append(cls).append("\">");
		sb.append("<div class=\"num\">").append(num).append("</div>");
		sb.append("<div class=\"label\">").append(label).append("</div>");
		sb.append("</div>\n");
	}

	private static void emitTabs(final StringBuilder sb)
	{
		sb.append("<div class=\"tabs\" id=\"tabs\">\n");
		emitTab(sb, "added", "Added");
		emitTab(sb, "deleted", "Deleted");
		emitTab(sb, "changed", "Changed");
		sb.append("</div>\n");
	}

	private static void emitTab(final StringBuilder sb, final String id, final String label)
	{
		sb.append("<button class=\"tab\" data-tab=\"").append(id).append("\">");
		sb.append(label);
		sb.append("</button>\n");
	}

	private static void emitPanel(final StringBuilder sb, final String id, final String title,
			final List<DbDiffEntry> entries)
	{
		sb.append("<div class=\"tab-panel\" id=\"panel-").append(id).append("\">\n");
		sb.append("<div class=\"search\"><input type=\"text\" id=\"search-").append(id);
		sb.append("\" placeholder=\"Filter ").append(title.toLowerCase()).append(" entries...\" ");
		sb.append("oninput=\"filterTable('").append(id).append("', this.value)\"></div>\n");

		if (entries.isEmpty())
		{
			sb.append("<div class=\"empty\">No ").append(title.toLowerCase()).append(" entries</div>\n");
		} else
		{
			sb.append("<table id=\"table-").append(id).append("\">\n<thead>\n<tr>\n");
			sb.append("<th>ID</th>\n<th>Key</th>\n<th>Object</th>\n");
			sb.append("</tr>\n</thead>\n<tbody>\n");

			for (DbDiffEntry e : entries)
			{
				String cls = id.equals("added") ? "added" : "deleted";
				CObject obj = id.equals("added") ? e.getObjectNew() : e.getObjectOld();
				String clsName = obj != null && obj.clazzName != null ? obj.clazzName : "";

				sb.append("<tr class=\"row-").append(cls).append("\">\n");
				sb.append("<td class=\"entry-toggle\" onclick=\"toggleEntry(this)\">");
				if (!clsName.isEmpty())
					sb.append(esc(clsName)).append(" <span class=\"id-num\">(").append(e.getId()).append(")</span>");
				else
					sb.append(e.getId());
				sb.append("</td>\n");
				sb.append("<td>").append(e.getKey()).append("</td>\n");
				sb.append("<td><span class=\"tag tag-").append(cls).append("\">")
						.append(id.equals("added") ? "new" : "removed").append("</span></td>\n");
				sb.append("</tr>\n");

				if (obj != null)
				{
					sb.append("<tr class=\"row-").append(cls).append("\">\n");
					sb.append("<td colspan=\"3\" style=\"padding: 0;\">\n");
					sb.append("<div class=\"entry-details\">\n");
					emitCObject(sb, obj, 0);
					sb.append("</div>\n");
					sb.append("</td>\n");
					sb.append("</tr>\n");
				}
			}

			sb.append("</tbody>\n</table>\n");
		}
		sb.append("</div>\n");
	}

	private static void emitChangedPanel(final StringBuilder sb, final List<DbDiffEntry> entries)
	{
		sb.append("<div class=\"tab-panel\" id=\"panel-changed\">\n");
		sb.append("<div class=\"search\"><input type=\"text\" id=\"search-changed");
		sb.append("\" placeholder=\"Filter changed entries...\" ");
		sb.append("oninput=\"filterTable('changed', this.value)\"></div>\n");

		if (entries.isEmpty())
		{
			sb.append("<div class=\"empty\">No changed entries</div>\n");
		} else
		{
			sb.append("<table id=\"table-changed\">\n<thead>\n<tr>\n");
			sb.append("<th>ID</th>\n<th>Key</th>\n<th>Changes</th>\n");
			sb.append("</tr>\n</thead>\n<tbody>\n");

			for (DbDiffEntry e : entries)
			{
				CObject objN = e.getObjectNew();
				String clsName = objN != null && objN.clazzName != null ? objN.clazzName : "";

				sb.append("<tr class=\"row-changed\">\n");
				sb.append("<td class=\"entry-toggle\" onclick=\"toggleEntry(this)\">");
				if (!clsName.isEmpty())
					sb.append(esc(clsName)).append(" <span class=\"id-num\">(").append(e.getId()).append(")</span>");
				else
					sb.append(e.getId());
				sb.append("</td>\n");
				sb.append("<td>").append(e.getKey()).append("</td>\n");
				sb.append("<td><span class=\"tag tag-changed\">").append(e.getFieldChanges().size()).append(" changes</span></td>\n");
				sb.append("</tr>\n");

				sb.append("<tr class=\"row-changed\">\n");
				sb.append("<td colspan=\"3\" style=\"padding: 0;\">\n");
				sb.append("<div class=\"entry-details\">\n");
				sb.append("<div class=\"obj-label\">Diff tree (changes inline):</div>\n");
				emitDiffTree(sb, e);
				sb.append("</div>\n");
				sb.append("</td>\n");
				sb.append("</tr>\n");
			}

			sb.append("</tbody>\n</table>\n");
		}
		sb.append("</div>\n");
	}

	private static void emitDiffTree(final StringBuilder sb, final DbDiffEntry entry)
	{
		Map<String, FieldChange> changeMap = new HashMap<>();
		for (FieldChange fc : entry.getFieldChanges())
			changeMap.put(fc.getPath(), fc);

		CObject objA = entry.getObjectOld();
		CObject objB = entry.getObjectNew();

		Set<Integer> allIndices = new TreeSet<>();
		Map<Integer, CObject> membersA = objA != null && objA.members != null
				? indexByExtraCode(objA.members) : new TreeMap<>();
		Map<Integer, CObject> membersB = objB != null && objB.members != null
				? indexByExtraCode(objB.members) : new TreeMap<>();
		allIndices.addAll(membersA.keySet());
		allIndices.addAll(membersB.keySet());

		for (int idx : allIndices)
		{
			String path = "[" + idx + "]";
			emitDiffNode(sb, membersA.get(idx), membersB.get(idx), 1, changeMap, path);
		}
	}

	private static void emitDiffNode(final StringBuilder sb,
			final CObject objA, final CObject objB, final int depth,
			final Map<String, FieldChange> changeMap, final String path)
	{
		FieldChange change = changeMap.get(path);
		CObject displayObj = objB != null ? objB : objA;
		if (displayObj == null)
			return;

		boolean existsInA = objA != null;
		boolean existsInB = objB != null;
		String diffClass = "";

		if (change != null)
		{
			switch (change.getChangeType())
			{
				case CHANGED: diffClass = "diff-changed"; break;
				case ADDED:   diffClass = "diff-added";   break;
				case REMOVED: diffClass = "diff-removed"; break;
			}
		} else if (!existsInA && existsInB)
			diffClass = "diff-added";
		else if (existsInA && !existsInB)
			diffClass = "diff-removed";

		String label = "[" + displayObj.index + "]";
		if (displayObj.clazzName != null)
			label += " " + displayObj.clazzName + " (type=" + displayObj.type + ")";
		else
			label += " type=" + displayObj.type;

		sb.append("<div class=\"obj-node ").append(diffClass).append("\" style=\"margin-left: ").append(depth * 16).append("px\">");
		sb.append("<span class=\"obj-type\">").append(esc(label)).append("</span>");

		boolean isType11Tuple = displayObj.type != null && displayObj.type == 11
				&& displayObj.members != null && !displayObj.members.isEmpty()
				&& allSimpleValues(displayObj.members);

		if (isType11Tuple)
		{
			if (change != null && change.getChangeType() == FieldChange.ChangeType.CHANGED)
			{
				sb.append(" = <span class=\"diff-old-inline\">");
				emitTuple(sb, objA != null ? objA : displayObj);
				sb.append("</span>");
				sb.append("<span class=\"diff-arrow\">&rarr;</span>");
				sb.append("<span class=\"diff-new-inline\">");
				emitTuple(sb, displayObj);
				sb.append("</span>");
			} else
			{
				sb.append(" = <span class=\"obj-tuple\">");
				emitTuple(sb, displayObj);
				sb.append("</span>");
			}
		} else
		{
			if (change != null)
			{
				switch (change.getChangeType())
				{
					case CHANGED:
						sb.append(" = <span class=\"diff-old-inline\">").append(esc(valueStr(change.getOldValue()))).append("</span>");
						if (change.getOldValue() instanceof Double)
						{
							String h = formatSuspectedDate((Double) change.getOldValue());
							if (h != null)
								sb.append(" <span class=\"obj-date-hint\">").append(h).append("</span>");
						}
						sb.append("<span class=\"diff-arrow\">&rarr;</span>");
						sb.append("<span class=\"diff-new-inline\">").append(esc(valueStr(change.getNewValue()))).append("</span>");
						if (change.getNewValue() instanceof Double)
						{
							String h = formatSuspectedDate((Double) change.getNewValue());
							if (h != null)
								sb.append(" <span class=\"obj-date-hint\">").append(h).append("</span>");
						}
						break;
					case ADDED:
						sb.append(" = <span class=\"diff-new-inline\">").append(esc(valueStr(change.getNewValue()))).append("</span>");
						break;
					case REMOVED:
						sb.append(" = <span class=\"diff-old-inline\">").append(esc(valueStr(change.getOldValue()))).append("</span>");
						break;
				}
			} else if (existsInB)
			{
				Object val = getObjValue(displayObj);
				if (val != null)
					sb.append(" = <span class=\"obj-val\">").append(esc(truncate(val.toString(), 120))).append("</span>");

				if (val instanceof Double)
				{
					String hint = formatSuspectedDate((Double) val);
					if (hint != null)
						sb.append(" <span class=\"obj-date-hint\">").append(hint).append("</span>");
				}
			}

			if (!isType11Tuple && isArrayType(displayObj))
			{
				int n = displayObj.members != null ? displayObj.members.size() : 0;
				sb.append(" <span class=\"obj-array\">[").append(n).append(" elements]</span>");
			}
		}

		sb.append("</div>\n");

		if (isType11Tuple || isArrayType(displayObj))
			return;

		Set<Integer> childIndices = new TreeSet<>();
		Map<Integer, CObject> childMapA = objA != null && objA.members != null
				? indexByExtraCode(objA.members) : new TreeMap<>();
		Map<Integer, CObject> childMapB = objB != null && objB.members != null
				? indexByExtraCode(objB.members) : new TreeMap<>();
		childIndices.addAll(childMapA.keySet());
		childIndices.addAll(childMapB.keySet());

		for (int childIdx : childIndices)
		{
			String childPath = path + ".[" + childIdx + "]";
			emitDiffNode(sb, childMapA.get(childIdx), childMapB.get(childIdx),
					depth + 1, changeMap, childPath);
		}
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

	private static String valueStr(final Object v)
	{
		if (v == null)
			return "-";
		return v.toString();
	}

	private static boolean isArrayType(final CObject obj)
	{
		if (obj == null || obj.type == null)
			return false;
		int t = obj.type;
		return t == 9 || t == 10 || t == 11 || t == 12;
	}

	private static Object getObjValue(final CObject obj)
	{
		if (obj.longValue != null)
			return obj.longValue;
		if (obj.intValue != null)
			return obj.intValue;
		if (obj.stringValue != null)
			return obj.stringValue;
		if (obj.objData instanceof String || obj.objData instanceof Number)
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
		return null;
	}

	private static void emitCObject(final StringBuilder sb, final CObject obj, final int depth)
	{
		if (obj == null)
		{
			sb.append("<div class=\"obj-null\">null</div>\n");
			return;
		}

		String idxStr = "[" + obj.index + "] ";

		String label;
		if (obj.clazzName != null)
			label = idxStr + obj.clazzName + " (type=" + obj.type + ")";
		else
			label = idxStr + "type=" + obj.type;

		sb.append("<div class=\"obj-node\" style=\"margin-left: ").append(depth * 16).append("px\">");
		sb.append("<span class=\"obj-type\">").append(esc(label)).append("</span>");

		boolean isType11Tuple = obj.type != null && obj.type == 11
				&& obj.members != null && !obj.members.isEmpty()
				&& allSimpleValues(obj.members);

		if (isType11Tuple)
		{
			sb.append(" = <span class=\"obj-tuple\">");
			emitTuple(sb, obj);
			sb.append("</span>");
		} else
		{
			Object val = getObjValue(obj);
			if (val != null)
				sb.append(" = <span class=\"obj-val\">").append(esc(truncate(val.toString(), 120))).append("</span>");

			if (val instanceof Double)
			{
				String hint = formatSuspectedDate((Double) val);
				if (hint != null)
					sb.append(" <span class=\"obj-date-hint\">").append(hint).append("</span>");
			}

			if (isArrayType(obj))
			{
				int n = obj.members != null ? obj.members.size() : 0;
				sb.append(" <span class=\"obj-array\">[").append(n).append(" elements]</span>");
			}
		}

		sb.append("</div>\n");

		if (!isType11Tuple && obj.members != null && !obj.members.isEmpty() && !isArrayType(obj))
		{
			for (CObject child : obj.members)
			{
				emitCObject(sb, child, depth + 1);
			}
		}
	}

	private static String truncate(final String s, final int max)
	{
		if (s == null)
			return "";
		if (s.length() <= max)
			return s;
		return s.substring(0, max) + "...";
	}

	private static void emitScript(final StringBuilder sb, final DbDiffResult result)
	{
		sb.append("<script>\n");
		sb.append("document.querySelectorAll('.tab').forEach(function(tab) {\n");
		sb.append("  tab.addEventListener('click', function() {\n");
		sb.append("    document.querySelectorAll('.tab').forEach(function(t) { t.classList.remove('active'); });\n");
		sb.append("    document.querySelectorAll('.tab-panel').forEach(function(p) { p.classList.remove('active'); });\n");
		sb.append("    tab.classList.add('active');\n");
		sb.append("    document.getElementById('panel-' + tab.dataset.tab).classList.add('active');\n");
		sb.append("  });\n");
		sb.append("});\n");

		sb.append("var firstTab = document.querySelector('.tab');\n");
		sb.append("if (firstTab) { firstTab.classList.add('active'); }\n");
		sb.append("var firstPanel = document.querySelector('.tab-panel');\n");
		sb.append("if (firstPanel) { firstPanel.classList.add('active'); }\n");

		sb.append("function toggleEntry(el) {\n");
		sb.append("  var tr = el.parentElement;\n");
		sb.append("  var detailTr = tr.nextElementSibling;\n");
		sb.append("  if (detailTr) {\n");
		sb.append("    var details = detailTr.querySelector('.entry-details');\n");
		sb.append("    if (details) { details.classList.toggle('open'); }\n");
		sb.append("  }\n");
		sb.append("}\n");

		sb.append("function filterTable(panelId, query) {\n");
		sb.append("  var table = document.getElementById('table-' + panelId);\n");
		sb.append("  if (!table) return;\n");
		sb.append("  var rows = table.querySelectorAll('tbody tr');\n");
		sb.append("  var q = query.toLowerCase();\n");
		sb.append("  rows.forEach(function(row) {\n");
		sb.append("    var match = false;\n");
		sb.append("    row.querySelectorAll('td').forEach(function(td) {\n");
		sb.append("      if (td.textContent.toLowerCase().indexOf(q) !== -1) match = true;\n");
		sb.append("    });\n");
		sb.append("    row.style.display = match || q === '' ? '' : 'none';\n");
		sb.append("  });\n");
		sb.append("}\n");
		sb.append("</script>\n");
	}

	private static String esc(final String s)
	{
		if (s == null)
			return "";
		return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
				.replace("\"", "&quot;").replace("'", "&#39;");
	}

	private static String formatNumber(final int n)
	{
		return String.format("%,d", n);
	}

	private static String formatSuspectedDate(final Double d)
	{
		if (d == null)
			return null;
		double abs = Math.abs(d);
		if (abs > 1.0e18 || abs < 1.0e-20)
		{
			try
			{
				long raw = Double.doubleToLongBits(d);
				Date date = CFileTimeConvertor.getDate(raw);
				long t = date.getTime();
				if (t > -12000000000000L && t < 8000000000000L)
					return String.format("date? %tF %<tT", date);
			} catch (Exception e)
			{
			}
		}
		return null;
	}

	private static boolean allSimpleValues(final List<CObject> members)
	{
		if (members == null || members.isEmpty())
			return false;
		for (CObject m : members)
		{
			if (m.members != null && !m.members.isEmpty())
				return false;
			Object v = getObjValue(m);
			if (v == null)
				return false;
		}
		return true;
	}

	private static void emitTuple(final StringBuilder sb, final CObject obj)
	{
		sb.append("(");
		boolean first = true;
		for (CObject child : obj.members)
		{
			if (!first)
				sb.append(", ");
			first = false;
			Object val = getObjValue(child);
			if (val instanceof Double)
			{
				String hint = formatSuspectedDate((Double) val);
				if (hint != null)
				{
					sb.append("<span class=\"diff-old-inline\">").append(esc(truncate(val.toString(), 80))).append("</span>");
					sb.append(" ").append(hint);
				} else
				{
					sb.append(esc(truncate(val.toString(), 80)));
				}
			} else if (val instanceof String)
				sb.append("\"").append(esc(truncate((String) val, 80))).append("\"");
			else if (val != null)
				sb.append(esc(truncate(val.toString(), 80)));
			else
				sb.append("?");
		}
		sb.append(")");
	}
}
