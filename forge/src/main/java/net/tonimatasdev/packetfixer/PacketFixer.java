package net.tonimatasdev.packetfixer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Map;


@Mod(modid = "packetfixer")
@IFMLLoadingPlugin.TransformerExclusions("net.tonimatasdev.packetfixer")
public class PacketFixer implements IFMLLoadingPlugin {
    public static final Logger LOGGER = LogManager.getLogger("PacketFixer");

    public PacketFixer() {

    }

    @Mod.EventHandler
    public void onPreInit(FMLInitializationEvent event) {
        LOGGER.info("Packet Fixer has been initialized successfully");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"net.tonimatasdev.packetfixer.asm.PacketFixerClassTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
