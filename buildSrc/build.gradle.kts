plugins {
   `java-gradle-plugin`
   java
}

group = "dev.tonimatas.packetfixer"
version = "1.0.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.architectury.dev/")
    maven("https://maven.minecraftforge.net/")
    maven("https://maven.neoforged.net/releases/")
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
    implementation("net.fabricmc:fabric-loom:1.10-SNAPSHOT")
    implementation("net.minecraftforge.gradle:ForgeGradle:6.+")
    implementation("org.spongepowered:mixingradle:0.7-SNAPSHOT")
}

gradlePlugin {
   plugins { 
       create("fabricModPlugin") { 
           id = "dev.tonimatas.packetfixer.fabric"
           implementationClass = "dev.tonimatas.packetfixer.fabric.FabricModPlugin" 
       }

       create("forgeModPlugin") {
           id = "dev.tonimatas.packetfixer.forge"
           implementationClass = "dev.tonimatas.packetfixer.forge.ForgeModPlugin"
       }
   }
}
