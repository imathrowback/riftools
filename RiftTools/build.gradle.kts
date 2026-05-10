plugins {
    java
}

description = "RiftTools main application"

dependencies {
    implementation(project(":rift_lib"))
    implementation(project(":ManifestDiff"))
    implementation(project(":telaradbdiff"))
    implementation(project(":totext"))
    implementation(project(":mapgen"))
    implementation("args4j:args4j:2.0.26")
    implementation("commons-io:commons-io:2.5")
    implementation("org.apache.commons:commons-lang3:3.4")
}

sourceSets.main {
    java.setSrcDirs(listOf("src"))
}

tasks.jar {
    from("src/logback.xml")
}

tasks.jar {
    archiveBaseName = "RiftTool"
    manifest {
        attributes(
            "Main-Class" to "org.imathrowback.riftool.RiftTool",
            "Class-Path" to configurations.runtimeClasspath.get().map { "libs/${it.name}" }.joinToString(" ")
        )
    }
}

val copyDeps by tasks.registering(Copy::class) {
    from(configurations.runtimeClasspath)
    into(layout.buildDirectory.dir("libs/libs"))
    dependsOn(configurations.runtimeClasspath)
}

val copyExes by tasks.registering(Copy::class) {
    from("exes")
    into(layout.buildDirectory.dir("libs"))
}

val copySubprojectJars by tasks.registering(Copy::class) {
    dependsOn(project(":ManifestDiff").tasks.jar,
              project(":telaradbdiff").tasks.jar,
              project(":totext").tasks.jar,
              project(":mapgen").tasks.jar)
    from(project(":ManifestDiff").layout.buildDirectory.dir("libs")) {
        include("ManifestDiff-*.jar")
    }
    from(project(":telaradbdiff").layout.buildDirectory.dir("libs")) {
        include("telaradbdiff-*.jar")
    }
    from(project(":totext").layout.buildDirectory.dir("libs")) {
        include("totext-*.jar")
    }
    from(project(":mapgen").layout.buildDirectory.dir("libs")) {
        include("mapgen-*.jar")
    }
    into(layout.buildDirectory.dir("libs"))
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.jar.get().dependsOn(copyDeps, copyExes, copySubprojectJars)
