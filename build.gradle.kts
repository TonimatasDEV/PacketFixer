plugins {
    java
}

subprojects {
    apply(plugin = "java")

    base.archivesName.set("PacketFixer-" + project.name)
}