package dev.tonimatas.packetfixer;

import org.gradle.api.JavaVersion;

public class LoaderExtension {
    private String minecraftVersion;
    private JavaVersion javaVersion;

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public JavaVersion getJavaVersion() {
        return javaVersion;
    }

    public void setMinecraftVersion(String minecraftVersion) {
        this.minecraftVersion = minecraftVersion;
    }

    public void setJavaVersion(JavaVersion javaVersion) {
        this.javaVersion = javaVersion;
    }
}
