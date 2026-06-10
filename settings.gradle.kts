pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://repo.spongepowered.org/repository/maven-public/")
        maven(url = "https://maven.fabricmc.net/")
        maven(url = "https://nexus.gtnewhorizons.com/repository/public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include("forge")
rootProject.name = "PacketFixer"
