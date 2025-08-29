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
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
}

mixin {
    config("packetfixer.v1_20_5.neoforge.mixins.json")
}

minecraft {
    mappings {
        version.put("minecraft", "1.21.8")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:21.8.9")
    implementation(project(":common"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
