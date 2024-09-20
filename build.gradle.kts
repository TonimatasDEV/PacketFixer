plugins {
    java
}

val modVersion: String by extra
val minecraftVersion: String by extra

subprojects {
    apply(plugin = "java")

    version = "$modVersion-$minecraftVersion"
    group = "dev.tonimatas"

    base.archivesName.set("PacketFixer-" + project.name)
}
