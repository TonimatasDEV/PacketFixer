@file:Suppress("DEPRECATION", "UnstableApiUsage")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
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
    val replaceProperties = mapOf("minecraftVersionRange" to minecraftVersionRange, "modVersion" to modVersion)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/mods.toml") {
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

tasks.jar {
    archiveClassifier.set("dev")
}

tasks.sourcesJar {
    val commonSources = project(":common").tasks.sourcesJar.get()
    dependsOn(commonSources)
    from(commonSources.archiveFile.map { zipTree(it) })
}

components.getByName<AdhocComponentWithVariants>("java").apply {
    withVariantsFromConfiguration(project.configurations["shadowRuntimeElements"]) {
        skip()
    }
}
