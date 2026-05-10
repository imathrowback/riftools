# riftools
Tools to do automatic rift patch differences

# required libraries

- Java 1.8 SDK (64bit recommended) - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

# building

Run `./build.sh` from the project root. This invokes Gradle to build all modules.

**Note:** The build output location has changed from the old Ant-based system.
Previously JARs were at `RiftTools/build/jar/`; they are now at
`RiftTools/build/libs/` and individual module directories. Update any
scripts referencing the old paths.

Built JARs:
- `RiftTools/build/libs/RiftTool.jar` — main CLI
- `ManifestDiff/build/libs/ManifestDiff.jar` — standalone manifest diff
- `telaradbdiff/build/libs/telaradbdiff.jar` — standalone DB diff
- `totext/build/libs/totext.jar` — standalone ToTextMode
- `mapgen/build/libs/mapgen.jar` — standalone MapGen

# execution

## rift tools
- `java -jar RiftTools/build/libs/RiftTool.jar`

Follow the usage prompts

If you have out of memory errors, ensure you are using the 64bit java client, or add -Xmx3G to the command line, eg:

- `java -Xmx3G -jar RiftTools/build/libs/RiftTool.jar`
