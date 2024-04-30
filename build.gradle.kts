import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    java
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "1.6-SNAPSHOT" apply false
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

val modVersion: String by extra
val minecraftVersion: String by extra
val minecraftVersionRange: String by extra

architectury {
    minecraft = minecraftVersion
}

allprojects {
    apply(plugin = "java")
    
    val versionArray = minecraftVersionRange.split(",")
    version = "$modVersion-${versionArray[0]}-to-${versionArray[1]}"
    group = "dev.tonimatas.packetfixer"
}


subprojects {
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "architectury-plugin")

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

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.release.set(21)
    }
}