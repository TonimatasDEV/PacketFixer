plugins {
    id("multiloader-common")
    id("net.neoforged.moddev")
}

val thisNeoFormVersion: String by extra
val parchmentMinecraft: String by extra
val parchmentVersion: String by extra

neoForge {
    neoFormVersion = thisNeoFormVersion

    val at = file("src/main/resources/META-INF/accesstransformer.cfg")
    if (at.exists()) {
        setAccessTransformers(at.absolutePath)
    }

    parchment {
        minecraftVersion = parchmentMinecraft
        mappingsVersion = parchmentVersion
    }
}

dependencies {
    compileOnly("org.spongepowered:mixin:0.8.5")
    compileOnly("io.github.llamalad7:mixinextras-common:0.3.5")
    annotationProcessor("io.github.llamalad7:mixinextras-common:0.3.5")
}

configurations {
    create("commonJava") {
        isCanBeResolved = false
        isCanBeConsumed = true
    }

    create("commonResources") {
        isCanBeResolved = false
        isCanBeConsumed = true
    }
}

artifacts {
    add("commonJava", sourceSets["main"].java.sourceDirectories.singleFile)
    add("commonResources", sourceSets["main"].resources.sourceDirectories.singleFile)
}

