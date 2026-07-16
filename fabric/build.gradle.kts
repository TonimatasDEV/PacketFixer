plugins {
    id("com.gradleup.shadow")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)

    fabricApi.configureDataGeneration {
        modId.set("packetfixer")
        outputDirectory.set(rootDir.resolve("common/src/main/generated"))
    }
}

val minecraftVersion: String by extra
val fabricApiVersion: String by extra
val fabricLoaderVersion: String by extra
val fabricMinecraftVersionRange: String by extra
val modVersion: String by extra

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentFabric"].extendsFrom(common)

dependencies {
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    api("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion+$minecraftVersion")

    common(project(path = ":common")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) { isTransitive = false }
}

tasks.processResources {
    val replaceProperties = mapOf("modVersion" to modVersion, "fabricMinecraftVersionRange" to fabricMinecraftVersionRange)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.jar {
    archiveClassifier = "raw"
}

tasks.shadowJar {
    dependsOn("jar")
    configurations = listOf(shadowCommon)
    from(zipTree(tasks.jar.get().archiveFile))
    archiveClassifier.set(null)
}
