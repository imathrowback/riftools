package org.imathrowback.manifest.diff;

import java.util.List;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.util.Util;

public class HtmlFormatter
{
	private static final String PAK_BASE_URL = "http://rift-update.dyn.triongames.com/ch1-live-streaming-client-patch/content/patchlive";
	public static String format(final DiffResult result, final boolean showPak,
			final Manifest manifestA, final Manifest manifestB,
			final int patchIndexA, final int patchIndexB)
	{
		StringBuilder sb = new StringBuilder();
		emitHead(sb);
		emitBody(sb, result, showPak, manifestA, manifestB, patchIndexA, patchIndexB);
		sb.append("</html>\n");
		return sb.toString();
	}

	private static void emitHead(final StringBuilder sb)
	{
		sb.append("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
		sb.append("<meta charset=\"UTF-8\">\n");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
		sb.append("<title>ManifestDiff Report</title>\n");
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
		sb.append(".card.card-renamed { border-color: #bc8cff; }\n");
		sb.append(".card.card-renamed .num { color: #bc8cff; }\n");
		sb.append(".card.card-moved { border-color: #58a6ff; }\n");
		sb.append(".card.card-moved .num { color: #58a6ff; }\n");
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
		sb.append("user-select: none; position: relative; white-space: nowrap; }\n");
		sb.append("th:hover { color: #c9d1d9; }\n");
		sb.append("th .sort-arrow { margin-left: 4px; opacity: 0.4; }\n");
		sb.append("th.sorted-asc .sort-arrow, th.sorted-desc .sort-arrow { opacity: 1; }\n");
		sb.append("td { padding: 6px 10px; border-bottom: 1px solid #21262d; ");
		sb.append("font-family: 'SFMono-Regular', Consolas, 'Liberation Mono', monospace; font-size: 12px; }\n");
		sb.append("tr:hover td { background: #161b22; }\n");
		sb.append(".row-added td:first-child { border-left: 3px solid #238636; }\n");
		sb.append(".row-deleted td:first-child { border-left: 3px solid #da3633; }\n");
		sb.append(".row-changed td:first-child { border-left: 3px solid #d29922; }\n");
		sb.append(".row-renamed td:first-child { border-left: 3px solid #bc8cff; }\n");
		sb.append(".row-moved td:first-child { border-left: 3px solid #58a6ff; }\n");
		sb.append(".hash { color: #8b949e; font-size: 11px; }\n");
		sb.append(".tag { display: inline-block; padding: 1px 6px; font-size: 10px; font-weight: 600; ");
		sb.append("border-radius: 4px; margin-right: 3px; }\n");
		sb.append(".tag-added { background: #23863622; color: #3fb950; }\n");
		sb.append(".tag-deleted { background: #da363322; color: #f85149; }\n");
		sb.append(".tag-changed { background: #d2992222; color: #d29922; }\n");
		sb.append(".tag-renamed { background: #bc8cff22; color: #bc8cff; }\n");
		sb.append(".tag-moved { background: #58a6ff22; color: #58a6ff; }\n");
		sb.append(".flag { display: inline-block; padding: 0 5px; font-size: 10px; ");
		sb.append("background: #30363d; border-radius: 3px; color: #8b949e; margin-right: 2px; }\n");
		sb.append(".empty { text-align: center; padding: 40px; color: #484f58; font-size: 14px; }\n");
		sb.append(".arrow { color: #484f58; padding: 0 4px; }\n");
		sb.append(".preview-btn { padding: 2px 10px; font-size: 11px; cursor: pointer; ");
		sb.append("background: #238636; color: #fff; border: none; border-radius: 4px; }\n");
		sb.append(".preview-btn:hover { background: #2ea043; }\n");

		sb.append(".modal-overlay { display: none; position: fixed; top: 0; left: 0; right: 0; bottom: 0; ");
		sb.append("background: rgba(0,0,0,0.75); z-index: 1000; justify-content: center; align-items: center; }\n");
		sb.append(".modal-overlay.active { display: flex; }\n");
		sb.append(".modal-content { background: #161b22; border: 1px solid #30363d; border-radius: 8px; ");
		sb.append("max-width: 90vw; max-height: 90vh; overflow: auto; padding: 20px; position: relative; }\n");
		sb.append(".modal-close { position: absolute; top: 8px; right: 12px; color: #8b949e; ");
		sb.append("cursor: pointer; font-size: 22px; line-height: 1; }\n");
		sb.append(".modal-close:hover { color: #f0f6fc; }\n");
		sb.append(".modal-body canvas { display: block; max-width: 100%; height: auto; }\n");
		sb.append(".modal-body pre { color: #8b949e; font-size: 11px; font-family: 'SFMono-Regular', ");
		sb.append("Consolas, 'Liberation Mono', monospace; line-height: 1.4; }\n");

		sb.append("@media (max-width: 768px) { body { padding: 12px; } ");
		sb.append(".cards { grid-template-columns: repeat(3, 1fr); } ");
		sb.append("td, th { padding: 6px; } }\n");
		sb.append("</style>\n");
	}

	private static void emitBody(final StringBuilder sb, final DiffResult result, final boolean showPak,
			final Manifest manifestA, final Manifest manifestB,
			final int patchIndexA, final int patchIndexB)
	{
		sb.append("<body>\n");
		sb.append("<h1>ManifestDiff Report</h1>\n");
		sb.append("<p class=\"subtitle\">");
		sb.append(formatNumber(result.getTotalOld())).append(" entries &rarr; ");
		sb.append(formatNumber(result.getTotalNew())).append(" entries");
		sb.append("</p>\n");

		emitCards(sb, result);
		emitTabs(sb);
		emitPanel(sb, "added", "Added", "ADDED", result.getAdded(), showPak, manifestB, patchIndexB);
		emitPanel(sb, "deleted", "Deleted", "DELETED", result.getDeleted(), showPak, manifestA, patchIndexA);
		emitPanel(sb, "changed", "Changed", "CHANGED", result.getChanged(), showPak, manifestA, manifestB, patchIndexA, patchIndexB);
		emitPanel(sb, "renamed", "Renamed", "RENAMED", result.getRenamed(), showPak, manifestB, patchIndexB);
		emitPanel(sb, "moved", "Moved", "MOVED", result.getMoved(), showPak, manifestA, manifestB, patchIndexA, patchIndexB);
		emitScript(sb, result);
		emitPreviewModal(sb);
		emitPreviewScriptRefs(sb);
		sb.append("</body>\n");
	}

	private static void emitCards(final StringBuilder sb, final DiffResult result)
	{
		sb.append("<div class=\"cards\">\n");
		emitCard(sb, "total", "Total A", formatNumber(result.getTotalOld()));
		emitCard(sb, "total", "Total B", formatNumber(result.getTotalNew()));
		emitCard(sb, "added", "Added", formatNumber(result.getAdded().size()));
		emitCard(sb, "deleted", "Deleted", formatNumber(result.getDeleted().size()));
		emitCard(sb, "changed", "Changed", formatNumber(result.getChanged().size()));
		emitCard(sb, "renamed", "Renamed", formatNumber(result.getRenamed().size()));
		emitCard(sb, "moved", "Moved", formatNumber(result.getMoved().size()));
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
		emitTab(sb, "added", "Added", 0);
		emitTab(sb, "deleted", "Deleted", 0);
		emitTab(sb, "changed", "Changed", 0);
		emitTab(sb, "renamed", "Renamed", 0);
		emitTab(sb, "moved", "Moved", 0);
		sb.append("</div>\n");
	}

	private static void emitTab(final StringBuilder sb, final String id, final String label, final int count)
	{
		sb.append("<button class=\"tab\" data-tab=\"").append(id).append("\">");
		sb.append(label);
		sb.append("</button>\n");
	}

	private static void emitPanel(final StringBuilder sb, final String id, final String title,
			final String changeType, final List<DiffEntry> entries, final boolean showPak,
			final Manifest manifest, final int patchIndex)
	{
		emitPanel(sb, id, title, changeType, entries, showPak, manifest, manifest, patchIndex, patchIndex);
	}

	private static void emitPanel(final StringBuilder sb, final String id, final String title,
			final String changeType, final List<DiffEntry> entries, final boolean showPak,
			final Manifest manifestA, final Manifest manifestB,
			final int patchIndexA, final int patchIndexB)
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
			sb.append("<th onclick=\"sortTable('").append(id).append("', 0)\">Name</th>\n");

			if ("renamed".equals(id))
			{
				sb.append("<th onclick=\"sortTable('").append(id).append("', 1)\">Old Name</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 2)\">Hash</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 3)\">Asset ID</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 4)\">Lang</th>\n");
				if (showPak)
					sb.append("<th onclick=\"sortTable('").append(id).append("', 5)\">PAK</th>\n");
			} else if ("changed".equals(id))
			{
				sb.append("<th onclick=\"sortTable('").append(id).append("', 1)\">Old SHA</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 2)\">New SHA</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 3)\">Hash</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 4)\">Asset ID</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 5)\">Lang</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 6)\">Flags</th>\n");
				if (showPak)
				{
					sb.append("<th onclick=\"sortTable('").append(id).append("', 7)\">Old PAK</th>\n");
					sb.append("<th onclick=\"sortTable('").append(id).append("', 8)\">New PAK</th>\n");
				}
			} else
			{
				sb.append("<th onclick=\"sortTable('").append(id).append("', 1)\">Hash</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 2)\">Asset ID</th>\n");
				sb.append("<th onclick=\"sortTable('").append(id).append("', 3)\">Lang</th>\n");
				if (showPak)
					sb.append("<th onclick=\"sortTable('").append(id).append("', 4)\">PAK</th>\n");
			}
			// Preview column header
			sb.append("<th style=\"cursor:default;width:60px\">Preview</th>\n");
			sb.append("</tr>\n</thead>\n<tbody>\n");

			for (DiffEntry entry : entries)
				emitRow(sb, entry, id, showPak, manifestA, manifestB, patchIndexA, patchIndexB);

			sb.append("</tbody>\n</table>\n");
		}
		sb.append("</div>\n");
	}

	private static void emitRow(final StringBuilder sb, final DiffEntry entry, final String panelId,
			final boolean showPak, final Manifest manifestA, final Manifest manifestB,
			final int patchIndexA, final int patchIndexB)
	{
		ManifestEntry ne = entry.getEntryNew() != null ? entry.getEntryNew() : entry.getEntryOld();
		String name = entry.getResolvedFilename();
		if (name.isEmpty())
			name = ne != null ? ne.filenameHashStr : "???";

		// Determine which manifest and patch index to use for preview
		boolean useOld = "deleted".equals(panelId);
		Manifest previewManifest = useOld ? manifestA : manifestB;
		int previewPatchIndex = useOld ? patchIndexA : patchIndexB;
		ManifestEntry previewEntry = useOld ? entry.getEntryOld() : entry.getEntryNew();
		if (previewEntry == null)
			previewEntry = ne;

		String previewUrl = "";
		String previewOffset = "";
		String previewCSize = "";
		String previewUSize = "";
		String previewFilename = "";
		if (previewPatchIndex >= 0 && previewManifest != null
				&& previewEntry.pakIndex >= 0 && previewEntry.pakIndex < previewManifest.pakFiles.size()
				&& previewEntry.pakOffset > 0)
		{
			String pakName = previewManifest.pakFiles.get(previewEntry.pakIndex).name;
			String idxStr = previewPatchIndex == 0 ? "" : String.valueOf(previewPatchIndex);
			previewUrl = "http://rift-update.dyn.triongames.com/ch1-live-streaming-client-patch/content/patchlive" + idxStr + "/" + pakName;
			previewOffset = String.valueOf(previewEntry.pakOffset);
			previewCSize = String.valueOf(previewEntry.compressedSize);
			previewUSize = String.valueOf(previewEntry.size);
			previewFilename = esc(name);
		}

		sb.append("<tr class=\"row-").append(panelId).append("\"");
		if (!previewUrl.isEmpty())
		{
			sb.append(" data-pak-url=\"").append(esc(previewUrl)).append("\"");
			sb.append(" data-pak-offset=\"").append(previewOffset).append("\"");
			sb.append(" data-pak-csize=\"").append(previewCSize).append("\"");
			sb.append(" data-pak-usize=\"").append(previewUSize).append("\"");
			sb.append(" data-filename=\"").append(previewFilename).append("\"");
		}
		sb.append(">\n");

		if ("renamed".equals(panelId))
		{
			String oldName = resolveName(entry.getEntryOld());
			String newName = resolveName(entry.getEntryNew());
			if (oldName.isEmpty())
				oldName = entry.getEntryOld().filenameHashStr;
			if (newName.isEmpty())
				newName = entry.getEntryNew().filenameHashStr;
			sb.append("<td>").append(esc(newName)).append("</td>\n");
			sb.append("<td>").append(esc(oldName)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(Util.bytesToHexString(ne.filenameHash)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(ne.idStr).append("</td>\n");
			sb.append("<td>").append(ne.lang).append("</td>\n");
			if (showPak)
				sb.append("<td>").append(pakName(manifestB, ne.pakIndex)).append("</td>\n");
		} else if ("changed".equals(panelId))
		{
			String oldSha = entry.getEntryOld() != null ? entry.getEntryOld().shaStr : "-";
			String newSha = entry.getEntryNew() != null ? entry.getEntryNew().shaStr : "-";
			sb.append("<td>").append(esc(name)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(oldSha.substring(0, Math.min(16, oldSha.length()))).append("...</td>\n");
			sb.append("<td class=\"hash\">").append(newSha.substring(0, Math.min(16, newSha.length()))).append("...</td>\n");
			sb.append("<td class=\"hash\">").append(Util.bytesToHexString(ne.filenameHash)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(ne.idStr).append("</td>\n");
			sb.append("<td>").append(ne.lang).append("</td>\n");
			sb.append("<td>");
			for (MetadataFlag f : entry.getMetadataFlags())
			{
				sb.append("<span class=\"flag\">").append(f.name()).append("</span>");
			}
			sb.append("</td>\n");
			if (showPak)
			{
				sb.append("<td>").append(entry.getEntryOld() != null ? pakName(manifestA, entry.getEntryOld().pakIndex) : "-").append("</td>\n");
				sb.append("<td>").append(entry.getEntryNew() != null ? pakName(manifestB, entry.getEntryNew().pakIndex) : "-").append("</td>\n");
			}
		} else if ("moved".equals(panelId))
		{
			String oldPak = entry.getEntryOld() != null ? pakName(manifestA, entry.getEntryOld().pakIndex) : "-";
			String newPak = entry.getEntryNew() != null ? pakName(manifestB, entry.getEntryNew().pakIndex) : "-";
			sb.append("<td>").append(esc(name)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(Util.bytesToHexString(ne.filenameHash)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(ne.idStr).append("</td>\n");
			sb.append("<td>").append(ne.lang).append("</td>\n");
			if (showPak)
			{
				sb.append("<td>").append(oldPak).append(" <span class=\"arrow\">&rarr;</span> ").append(newPak).append("</td>\n");
			}
		} else
		{
			sb.append("<td>").append(esc(name)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(Util.bytesToHexString(ne.filenameHash)).append("</td>\n");
			sb.append("<td class=\"hash\">").append(ne.idStr).append("</td>\n");
			sb.append("<td>").append(ne.lang).append("</td>\n");
			if (showPak)
				sb.append("<td>").append(pakName(manifestA, ne.pakIndex)).append("</td>\n");
		}
		// Preview button cell
		if (!previewUrl.isEmpty())
			sb.append("<td><button class=\"preview-btn\" type=\"button\" style=\"padding:2px 8px;font-size:11px;cursor:pointer;background:#238636;color:#fff;border:none;border-radius:4px;\">Preview</button></td>\n");
		else
			sb.append("<td></td>\n");
		sb.append("</tr>\n");
	}

	private static String pakName(final Manifest manifest, final int pakIndex)
	{
		if (manifest == null || manifest.pakFiles == null || pakIndex < 0 || pakIndex >= manifest.pakFiles.size())
			return String.valueOf(pakIndex);
		return manifest.pakFiles.get(pakIndex).name;
	}

	private static void emitScript(final StringBuilder sb, final DiffResult result)
	{
		sb.append("<script>\n");
		sb.append("var tabCounts = {\n");
		sb.append("  added: ").append(result.getAdded().size()).append(",\n");
		sb.append("  deleted: ").append(result.getDeleted().size()).append(",\n");
		sb.append("  changed: ").append(result.getChanged().size()).append(",\n");
		sb.append("  renamed: ").append(result.getRenamed().size()).append(",\n");
		sb.append("  moved: ").append(result.getMoved().size()).append("\n");
		sb.append("};\n");

		sb.append("var sortState = {};\n");
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

		sb.append("function sortTable(panelId, col) {\n");
		sb.append("  var table = document.getElementById('table-' + panelId);\n");
		sb.append("  if (!table) return;\n");
		sb.append("  var key = panelId + '-' + col;\n");
		sb.append("  var asc = sortState[key] !== true;\n");
		sb.append("  sortState[key] = asc;\n");
		sb.append("  var headers = table.querySelectorAll('thead th');\n");
		sb.append("  headers.forEach(function(h) { h.classList.remove('sorted-asc', 'sorted-desc'); });\n");
		sb.append("  if (asc) headers[col].classList.add('sorted-asc');\n");
		sb.append("  else headers[col].classList.add('sorted-desc');\n");

		sb.append("  var tbody = table.querySelector('tbody');\n");
		sb.append("  var rows = Array.from(tbody.querySelectorAll('tr'));\n");
		sb.append("  rows.sort(function(a, b) {\n");
		sb.append("    var va = a.children[col] ? a.children[col].textContent.trim() : '';\n");
		sb.append("    var vb = b.children[col] ? b.children[col].textContent.trim() : '';\n");
		sb.append("    var na = parseFloat(va), nb = parseFloat(vb);\n");
		sb.append("    if (!isNaN(na) && !isNaN(nb)) return asc ? na - nb : nb - na;\n");
		sb.append("    return asc ? va.localeCompare(vb) : vb.localeCompare(va);\n");
		sb.append("  });\n");
		sb.append("  rows.forEach(function(row) { tbody.appendChild(row); });\n");
		sb.append("}\n");
		sb.append("</script>\n");
	}

	private static void emitPreviewModal(final StringBuilder sb)
	{
		sb.append("<div class=\"modal-overlay\" id=\"preview-modal\">\n");
		sb.append("  <div class=\"modal-content\">\n");
		sb.append("    <span class=\"modal-close\" id=\"modal-close\">&times;</span>\n");
		sb.append("    <div class=\"modal-body\" id=\"modal-body\"></div>\n");
		sb.append("  </div>\n");
		sb.append("</div>\n");
	}

	private static void emitPreviewScriptRefs(final StringBuilder sb)
	{
		sb.append("<script src=\"xzwasm.js\"></script>\n");
		sb.append("<script type=\"module\">\n");
		sb.append("import { LZMA2Decoder, DDSRenderer } from './lzma2-dds-viewer.js';\n");
		sb.append("\n");
		sb.append("function hexDump(data, maxLen) {\n");
		sb.append("  var len = Math.min(data.length, maxLen);\n");
		sb.append("  var out = '';\n");
		sb.append("  for (var i = 0; i < len; i += 16) {\n");
		sb.append("    var hex = '';\n");
		sb.append("    var ascii = '';\n");
		sb.append("    for (var j = 0; j < 16 && i + j < len; j++) {\n");
		sb.append("      hex += data[i + j].toString(16).padStart(2, '0') + ' ';\n");
		sb.append("      var b = data[i + j];\n");
		sb.append("      ascii += b >= 32 && b < 127 ? String.fromCharCode(b) : '.';\n");
		sb.append("    }\n");
		sb.append("    out += i.toString(16).padStart(8, '0') + '  ' + hex.padEnd(48) + '  ' + ascii + '\\n';\n");
		sb.append("  }\n");
		sb.append("  return out;\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("document.addEventListener('click', function(e) {\n");
		sb.append("  var btn = e.target.closest('.preview-btn');\n");
		sb.append("  if (!btn) return;\n");
		sb.append("  var tr = btn.closest('tr');\n");
		sb.append("  var url = tr.dataset.pakUrl;\n");
		sb.append("  var offset = parseInt(tr.dataset.pakOffset);\n");
		sb.append("  var csize = parseInt(tr.dataset.pakCsize);\n");
		sb.append("  var usize = parseInt(tr.dataset.pakUsize);\n");
		sb.append("  var filename = tr.dataset.filename || '';\n");
		sb.append("  var body = document.getElementById('modal-body');\n");
		sb.append("  body.innerHTML = '<p style=\"color:#8b949e\">Loading...</p>';\n");
		sb.append("  document.getElementById('preview-modal').classList.add('active');\n");
		sb.append("\n");
		sb.append("  (async function() {\n");
		sb.append("    try {\n");
		sb.append("      var resp = await fetch(url, { headers: { 'Range': 'bytes=' + offset + '-' + (offset + csize - 1) } });\n");
		sb.append("      if (!resp.ok) throw new Error('HTTP ' + resp.status);\n");
		sb.append("      var raw = new Uint8Array(await resp.arrayBuffer());\n");
		sb.append("      var lzma2Data = raw.slice(1);\n");
		sb.append("      var ddsBuffer = await LZMA2Decoder.decompress(lzma2Data, usize);\n");
		sb.append("      var magic = new Uint32Array(ddsBuffer, 0, 1)[0];\n");
		sb.append("      if (magic === 0x20534444) {\n");
		sb.append("        var canvas = document.createElement('canvas');\n");
		sb.append("        DDSRenderer.render(ddsBuffer, canvas);\n");
		sb.append("        body.innerHTML = '';\n");
		sb.append("        var info = document.createElement('p');\n");
		sb.append("        info.style.cssText = 'color:#8b949e;font-size:12px;margin-bottom:8px;';\n");
		sb.append("        info.textContent = filename + ' (' + canvas.width + 'x' + canvas.height + ')';\n");
		sb.append("        body.appendChild(info);\n");
		sb.append("        body.appendChild(canvas);\n");
		sb.append("      } else {\n");
		sb.append("        var hex = hexDump(new Uint8Array(ddsBuffer), 512);\n");
		sb.append("        body.innerHTML = '<p style=\"color:#d29922;font-size:12px;margin-bottom:8px;\">' + filename + ' (not a DDS image, showing hex dump)</p><pre>' + hex + '</pre>';\n");
		sb.append("      }\n");
		sb.append("    } catch (err) {\n");
		sb.append("      body.innerHTML = '<p style=\"color:#f85149\">Error: ' + err.message + '</p>';\n");
		sb.append("    }\n");
		sb.append("  })();\n");
		sb.append("});\n");
		sb.append("\n");
		sb.append("document.getElementById('modal-close').addEventListener('click', function() {\n");
		sb.append("  document.getElementById('preview-modal').classList.remove('active');\n");
		sb.append("});\n");
		sb.append("document.getElementById('preview-modal').addEventListener('click', function(e) {\n");
		sb.append("  if (e.target === this) this.classList.remove('active');\n");
		sb.append("});\n");
		sb.append("</script>\n");
	}

	private static String resolveName(final ManifestEntry entry)
	{
		return org.imathrowback.manifest.NameDB.getNameForHash(entry.filenameHashStr, "");
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
}
