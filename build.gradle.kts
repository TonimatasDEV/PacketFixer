plugins {
    id("fabric-loom") version "1.10-SNAPSHOT" apply false
    id("net.neoforged.moddev") version "2.0.62-beta" apply false
}

val modVersion: String by extra

allprojects {
    version = modVersion
}