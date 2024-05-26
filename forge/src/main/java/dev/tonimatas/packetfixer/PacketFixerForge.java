package dev.tonimatas.packetfixer;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;

@Mod("packetfixer")
public class PacketFixerForge {
    public PacketFixerForge() {
        PacketFixer.init();
    }
}
