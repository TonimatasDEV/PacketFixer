pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://repo.spongepowered.org/repository/maven-public/")
        maven(url = "https://maven.fabricmc.net/")
        maven(url = "https://maven.neoforged.net/releases")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include("fabric", "forge", "neoforge")
rootProject.name = "PacketFixer"
