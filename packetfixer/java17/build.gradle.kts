import net.fabricmc.loom.task.RemapJarTask
import java.time.Instant
import java.time.format.DateTimeFormatter

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
    version = "$version-1.18-1.20.4"

    dependsOn("jar", ":common:jar")

    val resourcesJar = tasks.named<Jar>("jar").get().archiveFile.get().asFile
    val commonJar = project(":common").tasks.named<Jar>("jar").get().archiveFile.get().asFile

    val loadersJars = mutableListOf<File>()

    project(":fabric:java17").subprojects.forEach { project ->
        dependsOn(":fabric:java17:${project.name}:remapJar")
        val fabricJar = project(":fabric:java17:${project.name}").tasks.named<RemapJarTask>("remapJar").get().archiveFile.get().asFile
        loadersJars.add(fabricJar)
    }

    val forgeMixins = mutableListOf<String>()
    
    project(":forge:java17").subprojects.forEach { project ->
        dependsOn(":forge:java17:${project.name}:jar")
        val forgeJar = project(":forge:java17:${project.name}").tasks.named<Jar>("jar").get().archiveFile.get().asFile
        loadersJars.add(forgeJar)
        forgeMixins.add("packetfixer.${project.name}.forge.mixins.json")
    }

    project(":neoforge:java17").subprojects.forEach { project ->
        dependsOn(":neoforge:java17:${project.name}:jar")
        val neoforgeJar = project(":neoforge:java17:${project.name}").tasks.named<Jar>("jar").get().archiveFile.get().asFile
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
            "Implementation-Timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
            "MixinConfigs" to forgeMixins.joinToString(","),
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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}