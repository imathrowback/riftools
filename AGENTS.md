# Lessons

- **If you find yourself decompiling Java bytecode, stop and ask for help.** You've gone off the rails. The source code is right there — read it instead. If the output doesn't match what the source says, there's probably a simpler explanation (stale build, wrong classpath, etc.) that a human can spot in seconds.
- **Before decompiling class files or running `strings` on `.class` files, check for a stale jar on the classpath.** If a build output doesn't match source, the most likely cause is an older jar being loaded first. Check `find ... -name "*.jar"` results in the right order.
- **Build and run workflow**: Run `./build.sh` from the project root (`~/riftools`). To execute built jars, `cd RiftTools/build/jar` then `java -jar RiftTool.jar` — the jar in `libs/` is stale, use the one in `build/jar/`.
