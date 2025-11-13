plugins {
    java
    idea
    eclipse
    id("net.neoforged.gradle.userdev") version "7.1.4"
}

version = rootProject.version

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
}

minecraft {
    mappings {
        version.put("minecraft", "1.21.8")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:21.8.51")
    implementation(project(":common"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
