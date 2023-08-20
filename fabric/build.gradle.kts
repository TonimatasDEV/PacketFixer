@file:Suppress("UnstableApiUsage")

plugins {
    id("fabric-loom") version "1.3-SNAPSHOT"
}

val loaderVersion: String by extra
val yarnMappings: String by extra
val modVersion: String by extra
val minecraftVersion: String by extra

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnMappings:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")

}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("version" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.withType<JavaCompile> {
    options.release.set(17)
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}"}
    }
}
