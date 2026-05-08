# Lessons

- **If you find yourself decompiling Java bytecode, stop and ask for help.** You've gone off the rails. The source code is right there — read it instead. If the output doesn't match what the source says, there's probably a simpler explanation (stale build, wrong classpath, etc.) that a human can spot in seconds.
- **Before decompiling class files or running `strings` on `.class` files, check for a stale jar on the classpath.** If a build output doesn't match source, the most likely cause is an older jar being loaded first. Check `find ... -name "*.jar"` results in the right order.
- **Build and run workflow**: Run `./build.sh` from the project root (`~/riftools`). To execute built jars, `cd RiftTools/build/jar` then `java -jar RiftTool.jar` — the jar in `libs/` is stale, use the one in `build/jar/`.

- **TelaraDBDiff vs ManifestDiff**: ManifestDiff diffs `.manifest` files (asset manifests, TWAM format) — takes `-manifestA`/`-manifestB`. TelaraDBDiff diffs SQLite database files (`.db`/`.cds`) — takes `-dbA`/`-dbB`. They are completely separate tools for different data layers.

- **Downloading files for TelaraDBDiff**: Use `java -jar RiftTools/build/jar/RiftTool.jar -action DOWNLOADFILE -pIndex N -release LIVE -filename <name> -outfilename <path>`. Do NOT pass `-lang 0` — that restricts to lang=0 entries which may not match English (lang=1). Omit the `-lang` flag entirely (defaults to `-1` = any language). Key files to download:
  - `telara.db` — the actual game database (property class data)
  - `lang_english.cds` — localization database for TextEntry ID-to-string lookups (NOT the game db itself)
  - `rift_datamodel.txt` — pre-generated class model mapping class IDs to field names (lives at `/tmp/rift_datamodel.txt`)

- **TelaraDBDiff invocation**: `java -cp RiftTools/build/jar/RiftTool.jar org.imathrowback.telaradbdiff.TelaraDBDiff -dbA <fileA> -dbB <fileB> -dbResolve /tmp/rift_datamodel.txt [-langA <cdsA> -langB <cdsB>] -outdir <dir> -format html -output <path>`
