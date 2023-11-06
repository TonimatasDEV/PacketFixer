package net.tonimatasdev.packetfixerfabric.mixin;

import com.mojang.logging.LogUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
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
        List<String> mods = FabricLoader.getInstance().getAllMods().stream().map(ModContainer::getMetadata).map(ModMetadata::getId).toList();

        boolean connectivity = mods.contains("connectivity");
        boolean krypton = mods.contains("krypton");

        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerfabric.mixin.PacketInflaterMixin")) return !connectivity;
        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerfabric.mixin.compat.connectivity.PacketInflaterMixin")) return connectivity;
        if (mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerfabric.mixin.SplitterHandlerMixin") || mixinClassName.equalsIgnoreCase("net.tonimatasdev.packetfixerfabric.mixin.SizePrependerMixin")) {
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
