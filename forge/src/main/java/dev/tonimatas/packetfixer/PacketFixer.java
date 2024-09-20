package dev.tonimatas.packetfixer;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = "packetfixer")
public class PacketFixer {
    public static final Logger LOGGER = LogManager.getLogger("PacketFixer");

    public PacketFixer() {
        LOGGER.info("Packet Fixer has been initialized successfully.");
    }
}
