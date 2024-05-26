@file:Suppress("UnstableApiUsage", "DEPRECATION")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val modVersion: String by extra
val minecraftVersion: String by extra
val forgeVersion: String by extra
val forgeVersionRange: String by extra

architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    forge {
        mixinConfig("packetfixer-common.mixins.json", "packetfixer-forge.mixins.json")
    }
}

val common by configurations.creating
val shadowCommon by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentForge"].extendsFrom(common)

dependencies {
    forge("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionForge")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("forgeVersionRange" to forgeVersionRange, "version" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties)
    }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("forgeVersionRange" to forgeVersionRange, "version" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    exclude("fabric.mod.json")

    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    input.set(shadowTask.archiveFile)
    dependsOn(shadowTask)
    archiveClassifier.set("")
}