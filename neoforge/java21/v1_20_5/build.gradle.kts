plugins {
    java
    idea
    eclipse
    id("net.neoforged.gradle.userdev") version "7.0.185"
    id("net.neoforged.gradle.mixin") version "7.0.185"
}

version = rootProject.version

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
}

mixin {
    config("packetfixer.v1_20_5.neoforge.mixins.json")
}

minecraft {
    mappings {
        version.put("minecraft", "1.21.6")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:21.6.0-beta")
    implementation(project(":common"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
