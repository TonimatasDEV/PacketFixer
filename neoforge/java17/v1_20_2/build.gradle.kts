plugins {
    java
    idea
    eclipse
    id("net.neoforged.gradle.userdev") version "7.0.192"
    id("net.neoforged.gradle.mixin") version "7.0.192"
}

version = rootProject.version

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

mixin {
    config("packetfixer.v1_20_2.neoforge.mixins.json")
}

minecraft {
    mappings {
        version.put("minecraft", "1.20.4")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:20.4.248")
    implementation(project(":common"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
