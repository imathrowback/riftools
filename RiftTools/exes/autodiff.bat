@echo off

set JAVA_HOME=c:\Program Files (x86)\Java\jdk1.8.0_45

set RELEASE=PTS

echo ---Download changed files---
mkdir output
"%JAVA_HOME%/bin/java" -Xmx1024M -jar ManifestDiff.jar -diffCurrent -outdir output -extractChanged -extractAdded -cacheManifest -release %RELEASE%

echo ---Diff language---
"%JAVA_HOME%/bin/java" -Xmx1024M -jar ToTextMode.jar -fileType CDS -file output\lang_english.cdsA -output lang_english.cdsA.txt
"%JAVA_HOME%/bin/java" -Xmx1024M -jar ToTextMode.jar -fileType CDS -file output\lang_english.cdsB -output lang_english.cdsB.txt
REM now diff them
diff -d  lang_english.cdsA.txt lang_english.cdsB.txt > lang_english-diff.txt


move changed.txt db_changed.txt
move new.xml db_new.txt


echo ---Diff databases---
rem "%JAVA_HOME%/bin/java" -Xmx1024M -jar TelaraDBDiff.jar -dbA output\telara.dbA -dbB output\telara.dbB -outdir output
REM Language database is optional, if you use it, names will be replaced in the XML output
REM We have to make this after the diff language, since that will download the language files for use

"%JAVA_HOME%/bin/java" -Xmx1024M -jar TelaraDBDiff.jar -dbA output\telara.dbA -dbB output\telara.dbB -outdir output -autoDownload -release %RELEASE%

