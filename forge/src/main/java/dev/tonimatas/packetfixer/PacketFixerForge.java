package dev.tonimatas.packetfixer;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("ALL")
@Mod("packetfixer")
public class PacketFixerForge {
    public PacketFixerForge() {
        LogManager.getLogger().info("PacketFixer (Forge) has been initialized successfully");
    }
}
