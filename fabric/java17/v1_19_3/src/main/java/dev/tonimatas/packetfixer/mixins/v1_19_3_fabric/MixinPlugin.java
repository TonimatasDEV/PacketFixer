package dev.tonimatas.packetfixer.mixins.v1_19_3_fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
        if (isThisVersion()) {
            LogManager.getLogger().info("Packet Fixer fabric 1.19.3-1.20.1 has been applied successfully.");
        }
    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        return isThisVersion();
    }

    private boolean isThisVersion() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("minecraft");

        if (modContainer.isPresent()) {
            String version = modContainer.get().getMetadata().getVersion().getFriendlyString();
            return version.equals("1.19.3") || version.equals("1.19.4") || version.equals("1.20") || version.equals("1.20.1");
        }

        return false;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return Collections.emptyList();
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
