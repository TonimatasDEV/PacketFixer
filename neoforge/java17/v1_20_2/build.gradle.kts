plugins {
    java
    idea
    eclipse
    id("net.neoforged.gradle.userdev") version "7.1.4"
}

version = rootProject.version

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

minecraft {
    mappings {
        version.put("minecraft", "1.20.4")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:20.4.251")
    implementation(project(":common"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
