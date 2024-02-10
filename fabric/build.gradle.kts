@file:Suppress("UnstableApiUsage")

plugins {
    id("fabric-loom") version "1.5-SNAPSHOT"
}

val loaderVersion: String by extra
val yarnMappings: String by extra
val modVersion: String by extra
val minecraftVersion: String by extra

repositories {
    maven(url = "https://maven.fabricmc.net/")
    maven(url = "https://libraries.minecraft.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnMappings:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")

}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("modVersion" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}"}
    }
}
