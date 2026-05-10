plugins {
    java
}

description = "TelaraDB diff tool"

dependencies {
    implementation(project(":rift_lib"))
    implementation("org.xerial:sqlite-jdbc:3.16.1")
    implementation("org.slf4j:slf4j-api:1.7.7")
    implementation("org.slf4j:jul-to-slf4j:1.7.7")
    implementation("ch.qos.logback:logback-classic:1.1.2")
    implementation("com.google.guava:guava:19.0")
    implementation("net.java.dev.jna:jna:4.4.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.3")
    implementation("commons-io:commons-io:2.5")
    implementation("org.tukaani:xz:1.6")
    implementation("args4j:args4j:2.0.26")
    implementation("com.sksamuel.diff:diff:1.1.11")
}

sourceSets.main {
    java.setSrcDirs(listOf("src"))
}

tasks.jar {
    archiveBaseName = "telaradbdiff"
    manifest {
        attributes(
            "Main-Class" to "org.imathrowback.telaradbdiff.TelaraDBDiff",
            "Class-Path" to configurations.runtimeClasspath.get().map { "libs/${it.name}" }.joinToString(" ")
        )
    }
}

val copyDeps by tasks.registering(Copy::class) {
    from(configurations.runtimeClasspath)
    into(layout.buildDirectory.dir("libs/libs"))
    dependsOn(configurations.runtimeClasspath)
}

tasks.jar.get().dependsOn(copyDeps)
