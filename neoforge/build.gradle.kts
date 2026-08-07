plugins {
    id("com.gradleup.shadow")
}

val minecraftVersion: String by extra
val neoforgeVersion: String by extra
val neoforgeMinecraftVersionRange: String by extra
val modVersion: String by extra

architectury {
    platformSetupLoomIde()
    neoForge()
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)
}

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentNeoForge"].extendsFrom(common)

repositories {
    maven(url = "https://maven.neoforged.net/releases")
}

dependencies {
    neoForge("net.neoforged:neoforge:$neoforgeVersion")

    common(project(path = ":common")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionNeoForge")) { isTransitive = false }
}

tasks.processResources {
    val replaceProperties = mapOf("modVersion" to modVersion, "neoforgeMinecraftVersionRange" to neoforgeMinecraftVersionRange)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/neoforge.mods.toml") {
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
    destinationDirectory.set(rootDir.toPath().resolve("export").toFile())
}
