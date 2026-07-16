plugins {
    java
    id("architectury-plugin") version "3.5-SNAPSHOT"
    id("dev.architectury.loom") version "1.17-SNAPSHOT" apply false
    id("com.gradleup.shadow") version "9.5.1" apply false
}

val minecraftVersion: String by extra
val modVersion: String by extra

architectury {
    minecraft = minecraftVersion
}

allprojects {
    apply(plugin = "java")

    version = modVersion
    group = "dev.tonimatas.ftf"
}

subprojects {
    apply(plugin = "dev.architectury.loom-no-remap")
    apply(plugin = "architectury-plugin")

    base {
        archivesName.set("PacketFixer-" + project.name)
    }

    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
    }

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }

    tasks.withType<JavaCompile> {
        options.release.set(25)
    }
}
