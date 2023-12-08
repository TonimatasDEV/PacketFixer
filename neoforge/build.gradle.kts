@file:Suppress("UnstableApiUsage")

plugins {
    id ("java-library")
    id ("eclipse")
    id ("idea")
    id ("maven-publish")
    id ("net.neoforged.gradle.userdev") version "7.0.57"
}

val modVersion: String by extra
val minecraftVersion: String by extra
val neoforgeVersion: String by extra
val neoforgeVersionRange: String by extra

group = "net.tonimatasdev"
version = "$modVersion-$minecraftVersion"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

sourceSets.main.get().resources { srcDir("src/generated/resources") }

repositories {

}

dependencies {
    implementation("net.neoforged:neoforge:${neoforgeVersion}")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
}



tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("neoforgeVersionRange" to neoforgeVersionRange, "modVersion" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
