# riftools
Tools to do automatic rift patch differences

# required libraries

- Java 1.8 SDK (64bit recommended) - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

# building

Run `./build.sh` from the project root. This invokes Gradle to build all modules.

**Note:** The build output has changed from the old Ant-based system.
Previously all JARs were under `RiftTools/build/jar/`; they are now in
each module's `build/jar/` directory. Update any scripts referencing
the old flat layout.

Built JARs:
- `RiftTools/build/jar/RiftTool.jar` — main CLI
- `ManifestDiff/build/jar/ManifestDiff.jar` — standalone manifest diff
- `telaradbdiff/build/jar/telaradbdiff.jar` — standalone DB diff
- `totext/build/jar/totext.jar` — standalone ToTextMode
- `mapgen/build/jar/mapgen.jar` — standalone MapGen

# execution

## rift tools
- `java -jar RiftTools/build/jar/RiftTool.jar`

Follow the usage prompts

If you have out of memory errors, ensure you are using the 64bit java client, or add -Xmx3G to the command line, eg:

- `java -Xmx3G -jar RiftTools/build/jar/RiftTool.jar`
