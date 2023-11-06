package net.tonimatasdev.packetfixerforge.mixin;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.loading.FMLLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinConfigPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        System.getProperties().setProperty("forge.disablePacketCompressionDebug", "true");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean connectivity = FMLLoader.getLoadingModList().getModFileById("connectivity") != null;
        boolean krypton = FMLLoader.getLoadingModList().getModFileById("krypton") != null || FMLLoader.getLoadingModList().getModFileById("pluto") != null;

        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerforge.mixin.CompressionDecoderMixin")) return !connectivity;
        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerforge.mixin.compat.connectivity.CompressionDecoderMixin")) return connectivity;
        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerforge.mixin.SplitterHandlerMixin") || mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerforge.mixin.SizePrependerMixin")) {
            LogUtils.getLogger().warn("For can't fit X into 3 error fix. Delete Krypton.");
            return !krypton;
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
