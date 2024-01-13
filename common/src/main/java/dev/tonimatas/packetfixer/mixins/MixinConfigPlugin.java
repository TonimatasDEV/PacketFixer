package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.PacketFixer;
import dev.tonimatas.packetfixer.util.Hooks;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinConfigPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean krypton = Hooks.isModLoaded("krypton") || Hooks.isModLoaded("pluto");

        if ((mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixer.mixin.Varint21FrameDecoderMixin") || mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixer.mixin.Varint21LengthFieldPrependerMixin")) && krypton) {
            PacketFixer.LOGGER.warn("For can't fit X into 3 error fix (" + mixinClassName + "). Delete Krypton or Pluto.");
            return false;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
