package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.platform.Services;
import dev.tonimatas.packetfixer.util.Config;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class CommonMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        Config.runProperties();

        if (Services.PLATFORM.getPlatformName().equalsIgnoreCase("neoforge")) {
            System.getProperties().setProperty("neoforge.disablePacketCompressionDebug", "true");
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean isKryptonHere = Services.PLATFORM.isModEnabled("krypton") || Services.PLATFORM.isModEnabled("krypton_fnp");

        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.VarIntMixin")) {
            return !isKryptonHere;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
