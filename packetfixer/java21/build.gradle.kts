import net.fabricmc.loom.task.RemapJarTask

plugins {
    java
    id("com.gradleup.shadow") version "9.0.0-beta15"
}

base.archivesName.set("packetfixer")
version = rootProject.version

tasks.register<Task>("export") {
    dependsOn(tasks.named("mergedJar"))
}

tasks.register<Jar>("mergedJar") {
    archiveClassifier.set("merged")
    version = "$version-1.20.5-1.21.5"

    dependsOn("jar", ":common:jar")

    val resourcesJar = tasks.named<Jar>("jar").get().archiveFile.get().asFile
    val commonJar = project(":common").tasks.named<Jar>("jar").get().archiveFile.get().asFile

    val loadersJars = mutableListOf<File>()

    project(":fabric:java21").subprojects.forEach { project ->
        dependsOn(":fabric:java21:${project.name}:remapJar")
        val fabricJar = project(":fabric:java21:${project.name}").tasks.named<RemapJarTask>("remapJar").get().archiveFile.get().asFile
        loadersJars.add(fabricJar)
    }

    project(":neoforge:java21").subprojects.forEach { project ->
        dependsOn(":neoforge:java21:${project.name}:jar")
        val neoforgeJar = project(":neoforge:java21:${project.name}").tasks.named<Jar>("jar").get().archiveFile.get().asFile
        loadersJars.add(neoforgeJar)
    }

    manifest {
        attributes(
            "Specification-Title" to "Packet Fixer",
            "Specification-Vendor" to "TonimatasDEV",
            "Specification-Version" to version,
            "Implementation-Title" to "Packet Fixer",
            "Implementation-Version" to version,
            "Implementation-Vendor" to "TonimatasDEV",
        )
    }

    from(zipTree(resourcesJar))
    from(zipTree(commonJar))

    loadersJars.forEach { file ->
        from(zipTree(file))
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.processResources {
    val commonProperties = mapOf("modVersion" to rootProject.version)

    inputs.properties(commonProperties)

    filesMatching(listOf("META-INF/mods.toml", "fabric.mod.json")) {
        expand(commonProperties)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}