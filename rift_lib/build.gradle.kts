plugins {
    `java-library`
}

description = "Rift core library"

dependencies {
    api("org.slf4j:slf4j-api:1.7.7")
    api("com.google.guava:guava:19.0")
    api("org.apache.commons:commons-lang3:3.4")
    api("com.thoughtworks.xstream:xstream:1.4.9")
    api("commons-codec:commons-codec:1.10")
    api("org.jooq:jooq:3.9.1")
    api("org.apache.commons:commons-compress:1.11")
    api("commons-io:commons-io:2.5")
    api("java3d:vecmath:1.3.1")
    api("net.java.dev.jna:jna:4.4.0")
    api("org.tukaani:xz:1.6")
    api("org.apache.httpcomponents:httpclient:4.5.3")
    api("org.xerial:sqlite-jdbc:3.32.3.2")
    api("commons-net:commons-net:3.6")
    api("org.bouncycastle:bcprov-jdk15on:1.57")
}

sourceSets.main {
    java.setSrcDirs(listOf("src"))
}

tasks.jar {
    from("src") {
        include("org/imathrowback/manifest/single-entries.dat", "org/imathrowback/telaradb/db_key")
    }
}

tasks.jar {
    archiveBaseName = "riftlib"
    archiveVersion = ""
    destinationDirectory = layout.buildDirectory.dir("jar")
}
