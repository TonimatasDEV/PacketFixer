@file:Suppress("DEPRECATION", "UnstableApiUsage")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow")
}

val minecraftVersion: String by extra
val minecraftVersionRange: String by extra
val neoforgeVersion: String by extra
val modVersion: String by extra

architectury {
    platformSetupLoomIde()
    neoForge()
}

val common by configurations.creating
val shadowCommon by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentNeoForge"].extendsFrom(common)

repositories {
    maven(url = "https://maven.neoforged.net/")
}

dependencies {
    neoForge("net.neoforged:neoforge:$neoforgeVersion")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionNeoForge")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val versionRangeSplit = minecraftVersionRange.split(",")
    var versionRange = minecraftVersionRange
    if (versionRangeSplit[0] == versionRangeSplit[1]) versionRange = versionRangeSplit[0]
    
    val replaceProperties = mapOf("minecraftVersionRange" to versionRange, "modVersion" to modVersion)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    input.set(shadowTask.archiveFile)
}
