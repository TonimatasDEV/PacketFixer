plugins {
    java
}

val modVersion: String by extra
val minecraftVersion: String by extra

subprojects {
    apply(plugin = "java")

    version = "$modVersion-$minecraftVersion"
    group = "net.tonimatasdev"

    base.archivesName.set("PacketFixer-" + project.name)
    
    dependencies {
        implementation("org.spongepowered:mixin:0.8.5")
    }
}
