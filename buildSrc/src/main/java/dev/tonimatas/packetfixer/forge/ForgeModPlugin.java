package dev.tonimatas.packetfixer.forge;

import dev.tonimatas.packetfixer.LoaderPlugin;
import net.minecraftforge.gradle.userdev.UserDevExtension;
import net.minecraftforge.gradle.userdev.UserDevPlugin;
import org.gradle.api.Project;
import org.gradle.api.file.FileCollection;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.jvm.tasks.Jar;
import org.spongepowered.asm.gradle.plugins.MixinExtension;
import org.spongepowered.asm.gradle.plugins.MixinGradlePlugin;

@SuppressWarnings("unused")
public class ForgeModPlugin extends LoaderPlugin {
    @Override
    public void apply(Project project) {
        super.apply(project);
        
        ForgeExtension extension = project.getExtensions().create("loaderModPlugin", ForgeExtension.class);

        project.afterEvaluate(p -> {
            String minecraftVersion = extension.getMinecraftVersion();

            project.getPluginManager().apply(UserDevPlugin.class);
            project.getPluginManager().apply(MixinGradlePlugin.class);

            project.getDependencies().add("minecraft", "net.minecraftforge:forge:" + minecraftVersion + "-" + extension.getForgeVersion());
            project.getDependencies().add("implementation", project.project(":common"));
            project.getDependencies().add("annotationProcessor", "org.spongepowered:mixin:0.8.5:processor");
            
            project.getExtensions().configure(UserDevExtension.class, userDev -> {
                userDev.mappings("official", minecraftVersion);
                userDev.getCopyIdeResources().set(true);
            });

            project.getTasks().named("jar", Jar.class).configure(jar -> jar.finalizedBy("reobfJar"));

            for (String projectStr : extension.getProjects()) {
                SourceSetContainer targetSourceSets = p.project(":forge:java17:" + projectStr).getExtensions().getByType(SourceSetContainer.class);
                SourceSet targetMain = targetSourceSets.getByName("main");

                project.getTasks().named("compileJava", JavaCompile.class).configure(compileJava -> {
                    FileCollection extraSources = targetMain.getAllJava().getSourceDirectories();
                    compileJava.setSource(compileJava.getSource().plus(extraSources));
                });
            }
            
            project.getExtensions().configure(MixinExtension.class, mixin -> {
                String version = minecraftVersion.replaceAll("\\.", "_");
                
                mixin.add("main", "packetfixer.v" + version + ".forge.refmap.json");
                mixin.config("packetfixer.v" + version + ".forge.mixins.json");
            });

            project.getExtensions().configure(JavaPluginExtension.class, java -> {
                java.setSourceCompatibility(extension.getJavaVersion());
                java.setTargetCompatibility(extension.getJavaVersion());
                java.withSourcesJar();
            });
        });
    }
}
