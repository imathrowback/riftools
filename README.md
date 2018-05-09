# riftools
Tools to do automatic rift patch differences

# required libraries

- Java 1.8 SDK (64bit recommended)- http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Apache Ant - https://ant.apache.org/bindownload.cgi

# execution

## Autodiff
- edit build.bat with your own directory configs
- run build.bat
- Binary build will be in riftools\build\jar
- run autodiff.bat or execute each jar itself

## rift tools
- java -jar RiftTool.jar

Follow the usage prompts

if you have out of memory errors, ensure you are using the 64bit java client, or add -Xmx3G to the command line, eg:

- java -Xmx3G -jar RiftTool.jar
