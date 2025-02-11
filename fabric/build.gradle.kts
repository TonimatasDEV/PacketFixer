import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

architectury {
    platformSetupLoomIde()
    fabric()
}

val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val modVersion: String by extra
val minecraftVersionRange: String by extra

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentFabric"].extendsFrom(common)

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("modVersion" to modVersion, "minimumMinecraftVersion" to minecraftVersionRange.split(",")[0], "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    inputFile.set(shadowTask.archiveFile)
}
