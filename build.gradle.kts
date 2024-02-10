plugins {
    java
}

val modVersion: String by extra
val minecraftVersion: String by extra

subprojects {
    apply(plugin = "java")

    group = "net.tonimatasdev"
    version = "$modVersion-$minecraftVersion"
    base.archivesName.set("PacketFixer-" + project.name)

    java {
        withSourcesJar()
        toolchain.languageVersion.set(JavaLanguageVersion.of(8))

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}