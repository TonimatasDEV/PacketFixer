plugins {
    java
}

val modVersion = project.property("modVersion")
val minecraftVersion = project.property("minecraftVersion")

subprojects {
    apply(plugin = "java")

    version = "$modVersion-$minecraftVersion"
    group = "dev.tonimatas"

    base.archivesName.set("PacketFixer-" + project.name)
}
