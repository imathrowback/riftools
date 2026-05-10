#!/usr/bin/env python3
import argparse
import difflib
import re
import shutil
import subprocess
import sys
from pathlib import Path

ROOT_DIR = Path(__file__).resolve().parent.parent
RIFTTOOLS_DIR = ROOT_DIR / "RiftTools"
RIFTTOOL_JAR = RIFTTOOLS_DIR / "build" / "libs" / "RiftTool-1.0.jar"
TELARADB_JAR = ROOT_DIR / "telaradbdiff" / "build" / "libs" / "telaradbdiff-1.0.jar"
MANIFEST_DIFF_JAR = ROOT_DIR / "ManifestDiff" / "build" / "libs" / "ManifestDiff-1.0.jar"
TOTEXT_JAR = ROOT_DIR / "totext" / "build" / "libs" / "totext-1.0.jar"
CACHE_DIR = Path.home() / ".riftools_cache"
SITEGEN_DIR = Path(__file__).resolve().parent

REQUIRED_FILES = ["telara.db", "lang_english.cds", "assets64.manifest"]

LANG_FLAGS = {
    "telara.db": [],
    "lang_english.cds": ["-lang", "1"],
    "assets64.manifest": [],
}


def log(msg):
    print(msg, file=sys.stderr)


def cache_path(pindex, filename):
    return CACHE_DIR / f"{pindex}_{filename}"


def ensure_jar():
    required_jars = [(RIFTTOOL_JAR, "RiftTool"), (TELARADB_JAR, "TelaraDBDiff"),
                     (MANIFEST_DIFF_JAR, "ManifestDiff"), (TOTEXT_JAR, "ToTextMode")]
    missing = [name for path, name in required_jars if not path.exists()]
    if missing:
        log(f"ERROR: Missing JARs: {', '.join(missing)}")
        log(f"Check: {RIFTTOOLS_DIR / 'build' / 'libs'}")
        log("Run ./build.sh from the project root first.")
        sys.exit(1)


def download_file(pindex, filename):
    dest = cache_path(pindex, filename)
    if dest.exists():
        return dest
    CACHE_DIR.mkdir(parents=True, exist_ok=True)
    log(f"  Downloading {filename} for patch {pindex}...")
    args = [
        "java", "-jar", str(RIFTTOOL_JAR),
        "-action", "DOWNLOADFILE",
        "-release", "LIVE",
        "-pIndex", str(pindex),
        "-filename", filename,
        "-outfilename", str(dest),
    ] + LANG_FLAGS.get(filename, [])
    result = subprocess.run(args, capture_output=True, text=True)
    if result.returncode != 0:
        log(f"  WARNING: Failed to download {filename} for patch {pindex}: {result.stderr.strip()}")
        return None
    if not dest.exists() or dest.stat().st_size == 0:
        log(f"  WARNING: Downloaded {filename} for patch {pindex} is empty/missing")
        return None
    return dest


def parse_summary(stdout):
    counts = {}
    for line in stdout.splitlines():
        m = re.match(r"(Added|Deleted|Changed|Renamed|Moved|Total A|Total B):\s*(\d+)", line)
        if m:
            key = m.group(1).lower().replace(" ", "_")
            counts[key] = int(m.group(2))
    return counts


def run_telaradb_diff(db_a, db_b, lang_a, lang_b, datamodel_path, out_html):
    out_html.parent.mkdir(parents=True, exist_ok=True)
    args = [
        "java", "-jar", str(TELARADB_JAR),
        "-dbA", str(db_a),
        "-dbB", str(db_b),
        "-dbResolve", str(datamodel_path),
        "-langA", str(lang_a),
        "-langB", str(lang_b),
        "-outdir", str(out_html.parent),
        "-format", "html",
        "-output", str(out_html),
    ]
    result = subprocess.run(args, capture_output=True, text=True, timeout=600)
    if result.returncode != 0:
        log(f"  WARNING: TelaraDBDiff failed: {result.stderr.strip()}")
        return {}
    return parse_summary(result.stdout)


def run_manifest_diff(manifest_a, manifest_b, out_html, patch_index_a, patch_index_b):
    out_html.parent.mkdir(parents=True, exist_ok=True)
    args = [
        "java", "-jar", str(MANIFEST_DIFF_JAR),
        "-manifestA", str(manifest_a),
        "-manifestB", str(manifest_b),
        "-patchIndexA", str(patch_index_a),
        "-patchIndexB", str(patch_index_b),
        "-outdir", str(out_html.parent),
        "-format", "html",
        "-output", str(out_html),
    ]
    result = subprocess.run(args, capture_output=True, text=True, timeout=300)
    if result.returncode != 0:
        log(f"  WARNING: ManifestDiff failed: {result.stderr.strip()}")
        return {}
    return parse_summary(result.stdout)


def convert_cds_text(cds_path):
    txt_path = cds_path.with_suffix(".txt")
    if txt_path.exists():
        return txt_path
    args = [
        "java", "-jar", str(TOTEXT_JAR),
        "-fileType", "CDS",
        "-file", str(cds_path),
        "-output", str(txt_path),
    ]
    result = subprocess.run(args, capture_output=True, text=True, timeout=120)
    if result.returncode != 0 or not txt_path.exists():
        return None
    return txt_path


_DARK_DIFF_CSS = """
        body { background:#0d1117; color:#c9d1d9; }
        table.diff { font-family:'SFMono-Regular',Consolas,'Liberation Mono',monospace;
          border:1px solid #30363d; border-collapse:collapse; background:#0d1117;
          font-size:12px; width:100%; }
        table.diff tbody { background:#0d1117; }
        .diff_header { background:#161b22; color:#8b949e; font-weight:600;
          border:1px solid #30363d; }
        .diff_header a { color:#58a6ff; text-decoration:none; }
        .diff_header a:hover { text-decoration:underline; }
        td.diff_header { text-align:right; padding:2px 8px;
          border:1px solid #30363d; }
        .diff_next { background:#161b22; border:1px solid #30363d; padding:2px 4px; }
        .diff_next a { color:#58a6ff; text-decoration:none; }
        .diff_next a:hover { text-decoration:underline; }
        .diff_add { background:#23863633; color:#3fb950; border:1px solid #30363d; padding:2px 8px; }
        .diff_chg { background:#d2992233; color:#d29922; border:1px solid #30363d; padding:2px 8px; }
        .diff_sub { background:#da363333; color:#f85149; border:1px solid #30363d; padding:2px 8px; }
"""


def run_text_diff(lang_a, lang_b, out_html):
    out_html.parent.mkdir(parents=True, exist_ok=True)
    txt_a = convert_cds_text(lang_a)
    txt_b = convert_cds_text(lang_b)
    if txt_a is None or txt_b is None:
        log("  WARNING: Failed to convert one or both .cds files to text")
        return {}
    lines_a = txt_a.read_text(errors="replace").splitlines(keepends=True)
    lines_b = txt_b.read_text(errors="replace").splitlines(keepends=True)
    raw = difflib.HtmlDiff(tabsize=2).make_file(
        lines_a, lines_b, context=True, numlines=3,
        fromdesc=lang_a.name, todesc=lang_b.name,
    )
    raw = re.sub(
        r'<style[^>]*>.*?</style>',
        '<style type="text/css">' + _DARK_DIFF_CSS + '</style>',
        raw, count=1, flags=re.DOTALL,
    )
    out_html.write_text(raw)

    matcher = difflib.SequenceMatcher(None, lines_a, lines_b)
    added = deleted = 0
    for tag, i1, i2, j1, j2 in matcher.get_opcodes():
        if tag == "delete":
            deleted += i2 - i1
        elif tag == "insert":
            added += j2 - j1
        elif tag == "replace":
            deleted += i2 - i1
            added += j2 - j1
    return {"added": added, "deleted": deleted}


def badge_html(text, color="#8b949e"):
    return f'<span style="display:inline-block;padding:0 7px;font-size:11px;font-weight:600;border-radius:10px;line-height:20px;background:{color}22;color:{color};margin:1px 2px;">{text}</span>'


def generate_index(destdir, pairs):
    index_path = destdir / "index.html"
    css_dir = destdir / "css"
    css_dir.mkdir(parents=True, exist_ok=True)

    css_path = css_dir / "style.css"
    css_path.write_text("""\
*{margin:0;padding:0;box-sizing:border-box}
body{font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,sans-serif;
  background:#0d1117;color:#c9d1d9;padding:32px;max-width:1200px;margin:0 auto}
h1{font-size:28px;font-weight:700;color:#f0f6fc;margin-bottom:4px}
.subtitle{color:#8b949e;font-size:14px;margin-bottom:28px}
table{width:100%;border-collapse:collapse;font-size:13px}
th{background:#161b22;padding:10px 12px;text-align:left;font-weight:600;
  color:#8b949e;border-bottom:2px solid #30363d;white-space:nowrap}
td{padding:12px;border-bottom:1px solid #21262d;vertical-align:top}
tr:hover td{background:#161b22}
.pair-cell{font-weight:600;white-space:nowrap;color:#f0f6fc;font-size:14px}
.diff-cell{line-height:1.8}
.diff-cell a{margin-left:4px;color:#58a6ff;text-decoration:none}
.diff-cell a:hover{text-decoration:underline}
.status-ok{color:#3fb950;font-weight:500}
.status-fail{color:#f85149;font-weight:500}
""")

    def cell_html(summary, keys, colors, link):
        if not summary:
            return ""
        parts = []
        for k in keys:
            v = summary.get(k, 0)
            if v:
                parts.append(badge_html(f"{k.title()}:{v}", colors[k]))
        if not parts:
            parts = ['<span class="status-ok">No changes</span>']
        return ' '.join(parts) + f' <a href="{link}">view</a>'

    rows = []
    for pd in pairs:
        n = pd["n"]
        link_base = f'{n}-vs-{n+1}'

        db_html = cell_html(pd.get("telaradb"),
            ("added", "deleted", "changed"),
            {"added": "#3fb950", "deleted": "#f85149", "changed": "#d29922"},
            f"{link_base}/telaradb.html")

        mf_html = cell_html(pd.get("manifest"),
            ("added", "deleted", "changed", "renamed", "moved"),
            {"added": "#3fb950", "deleted": "#f85149", "changed": "#d29922",
             "renamed": "#bc8cff", "moved": "#58a6ff"},
            f"{link_base}/manifest.html")

        lg_html = cell_html(pd.get("lang"),
            ("added", "deleted"),
            {"added": "#3fb950", "deleted": "#f85149"},
            f"{link_base}/langdiff.html")

        rows.append(f"""\
<tr>
  <td class="pair-cell">{n}&nbsp;&rarr;&nbsp;{n+1}</td>
  <td class="diff-cell">{db_html}</td>
  <td class="diff-cell">{mf_html}</td>
  <td class="diff-cell">{lg_html}</td>
</tr>""")

    html = f"""\
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RIFT Patch Diff Index</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>RIFT Patch Diff Index</h1>
<p class="subtitle">Live — Patches {pairs[0]["n"]} to {pairs[-1]["n"]+1}</p>
<table>
<thead>
<tr><th>Patch Pair</th><th>TelaraDB Diff</th><th>Manifest Diff</th><th>Lang Diff</th></tr>
</thead>
<tbody>
{chr(10).join(rows)}
</tbody>
</table>
</body>
</html>"""
    index_path.write_text(html)
    log(f"Wrote {index_path}")


def main():
    parser = argparse.ArgumentParser(description="Generate RIFT patch diff HTML site")
    parser.add_argument("start", type=int, help="Starting patch index")
    parser.add_argument("end", type=int, help="Ending patch index (exclusive)")
    parser.add_argument("destdir", type=Path, help="Output directory for generated site")
    parser.add_argument("--datamodel", type=Path, default=Path("/tmp/rift_datamodel.txt"),
                        help="Path to rift_datamodel.txt (default: /tmp/rift_datamodel.txt)")
    args = parser.parse_args()

    if args.start >= args.end:
        log("ERROR: start must be less than end")
        sys.exit(1)

    if not args.datamodel.exists():
        log(f"ERROR: rift_datamodel.txt not found at {args.datamodel}")
        log("Generate it or place a copy there, then re-run.")
        sys.exit(1)

    ensure_jar()
    args.destdir.mkdir(parents=True, exist_ok=True)

    pairs = []
    for n in range(args.start, args.end):
        log(f"\n=== Processing {n} vs {n+1} ===")

        pair_dir = args.destdir / f"{n}-vs-{n+1}"
        pair_dir.mkdir(parents=True, exist_ok=True)

        files_ok = True
        cached = {}
        for fname in REQUIRED_FILES:
            a = download_file(n, fname)
            b = download_file(n + 1, fname)
            if a is None or b is None:
                log(f"  SKIPPING pair {n} vs {n+1}: missing {fname}")
                files_ok = False
                break
            cached[fname + "_a"] = a
            cached[fname + "_b"] = b

        if not files_ok:
            pairs.append({"n": n, "telaradb": {}, "manifest": {}})
            continue

        telaradb_html = pair_dir / "telaradb.html"
        manifest_html = pair_dir / "manifest.html"
        langdiff_html = pair_dir / "langdiff.html"

        log("  Running TelaraDBDiff...")
        db_summary = run_telaradb_diff(
            cached["telara.db_a"], cached["telara.db_b"],
            cached["lang_english.cds_a"], cached["lang_english.cds_b"],
            args.datamodel, telaradb_html,
        )
        if db_summary:
            log(f"    Added: {db_summary.get('added', 0)}, "
                f"Deleted: {db_summary.get('deleted', 0)}, "
                f"Changed: {db_summary.get('changed', 0)}")

        log("  Running ManifestDiff...")
        mf_summary = run_manifest_diff(
            cached["assets64.manifest_a"], cached["assets64.manifest_b"],
            manifest_html, n, n + 1,
        )
        if mf_summary:
            log(f"    Added: {mf_summary.get('added', 0)}, "
                f"Deleted: {mf_summary.get('deleted', 0)}, "
                f"Changed: {mf_summary.get('changed', 0)}, "
                f"Renamed: {mf_summary.get('renamed', 0)}, "
                f"Moved: {mf_summary.get('moved', 0)}")
        # Copy preview JS files alongside the manifest report
        js_src = SITEGEN_DIR / "js"
        if js_src.exists():
            for js_file in ["xzwasm.js", "lzma2-dds-viewer.js"]:
                src = js_src / js_file
                if src.exists():
                    shutil.copy2(src, manifest_html.parent / js_file)

        log("  Running text diff on lang_english.cds...")
        lang_summary = run_text_diff(
            cached["lang_english.cds_a"], cached["lang_english.cds_b"],
            langdiff_html,
        )
        if lang_summary:
            log(f"    Added: {lang_summary.get('added', 0)}, "
                f"Deleted: {lang_summary.get('deleted', 0)}")

        pairs.append({"n": n, "telaradb": db_summary, "manifest": mf_summary,
                      "lang": lang_summary})

    generate_index(args.destdir, pairs)
    log(f"\nDone. Site generated at {args.destdir}")


if __name__ == "__main__":
    main()
