package dev.tonimatas.packetfixer;

import org.gradle.api.JavaVersion;

import java.util.Collections;
import java.util.List;

public class LoaderExtension {
    private String minecraftVersion;
    private JavaVersion javaVersion;
    private List<String> projects = Collections.emptyList();

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public JavaVersion getJavaVersion() {
        return javaVersion;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setMinecraftVersion(String minecraftVersion) {
        this.minecraftVersion = minecraftVersion;
    }

    public void setJavaVersion(JavaVersion javaVersion) {
        this.javaVersion = javaVersion;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
