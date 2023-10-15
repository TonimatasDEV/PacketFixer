plugins {
    id("net.minecraftforge.gradle") version "6.+"
    id("org.spongepowered.mixin") version "0.7-SNAPSHOT"
    id("idea")
    id("eclipse")
}

val modVersion: String by extra
val minecraftVersion: String by extra
val forgeVersion: String by extra
val forgeVersionRange: String by extra

group = "net.tonimatasdev"
version = "$modVersion-$minecraftVersion"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
}

minecraft {
    mappings("official", minecraftVersion)

    copyIdeResources.set(true)

    runs {
        configureEach {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")

            mods {
                create("packetfixer") {
                    source(sourceSets.main.get())
                }
            }
        }

        create("client") {
            property("forge.enabledGameTestNamespaces", "packetfixer")
        }

        create("server") {
            property("forge.enabledGameTestNamespaces", "packetfixer")
            args("--nogui")
        }

        create("gameTestServer") {
            property("forge.enabledGameTestNamespaces", "packetfixer")
        }

        create("data") {
            workingDirectory(project.file("run-data"))
            args("--mod", "packetfixer", "--all", "--output", file("src/generated/resources/"), "--existing", file("src/main/resources/"))
        }
    }
}

mixin {
    add(sourceSets.main.get(), "packetfixer.refmap.json")
    config("packetfixer.mixins.json")
}

sourceSets.main.get().resources { srcDir("src/generated/resources") }

repositories {

}

dependencies {
    minecraft("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
}



tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("forgeVersionRange" to forgeVersionRange, "modVersion" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties)
    }
}


tasks.jar {
    manifest {
        attributes(
            "Specification-Title" to "PacketFixerForge",
            "Specification-Vendor" to "TonimatasDEV",
            "Specification-Version" to modVersion,
            "Implementation-Title" to "PacketFixerForge",
            "Implementation-Version" to modVersion,
            "Implementation-Vendor" to "TonimatasDEV"
        )
    }

    finalizedBy("reobfJar")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
