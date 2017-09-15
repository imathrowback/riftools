#!/bin/sh

RELEASE=LIVE

echo ---Download changed files---
mkdir output
$JAVA_HOME/bin/java -Xmx3G -jar ManifestDiff.jar -onlyLang 1 -diffCurrent -outdir output -extractChanged -extractAdded -cacheManifest -release $RELEASE

