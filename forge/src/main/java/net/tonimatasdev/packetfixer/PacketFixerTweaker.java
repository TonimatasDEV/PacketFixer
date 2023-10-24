package net.tonimatasdev.packetfixer;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.List;


public class PacketFixerTweaker implements ITweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {

    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        classLoader.registerTransformer("net.tonimatasdev.packetfixer.asm.PacketFixerClassTransformer");
    }

    @Override
    public String getLaunchTarget() {
        throw new RuntimeException("Invalid for use as a primary tweaker");
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
