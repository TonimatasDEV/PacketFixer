import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    java
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false
    id("com.gradleup.shadow") version "8.3.5" apply false
}

val modVersion: String by extra
val minecraftVersion: String by extra
val minecraftVersionRange: String by extra

architectury {
    minecraft = minecraftVersion
}

subprojects {
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "com.gradleup.shadow")

    base { 
        archivesName.set("packetfixer-" + project.name)
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
        "mappings"(project.the<LoomGradleExtensionAPI>().officialMojangMappings())
    }
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "architectury-plugin")

    val versionArray = minecraftVersionRange.split(",")
    version = "$modVersion-${versionArray[0]}-to-${versionArray[1]}"
    group = "dev.tonimatas"

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}