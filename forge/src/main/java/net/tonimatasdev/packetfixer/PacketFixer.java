package net.tonimatasdev.packetfixer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod(modid = "packetfixer")
public class PacketFixer {
    public static final Logger LOGGER = LogManager.getLogger("PacketFixer");
    public PacketFixer() {

    }

    @Mod.EventHandler
    public void onPreInit(FMLInitializationEvent event) {
        LOGGER.info("Packet Fixer has been initialized successfully");
    }
}
