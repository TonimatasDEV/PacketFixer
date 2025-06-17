package dev.tonimatas.packetfixer.mixins.v1_18_forge;

import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
        if (isThisVersion()) {
            System.getProperties().setProperty("forge.disablePacketCompressionDebug", "true");
            LogManager.getLogger().info("Packet Fixer forge 1.18.X has been applied successfully.");
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
        try {
            Class.forName("net.neoforged.fml.loading.FMLLoader");
            return false;
        } catch (ClassNotFoundException ignored) {
        }

        String version = FMLLoader.getLoadingModList().getModFileById("minecraft").getMods().get(0).getVersion().toString();
        return version.equals("1.18") || version.equals("1.18.1") || version.equals("1.18.2");
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
