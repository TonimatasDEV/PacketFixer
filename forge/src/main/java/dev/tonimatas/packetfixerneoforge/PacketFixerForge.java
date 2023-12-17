package dev.tonimatas.packetfixerneoforge;

import dev.tonimatas.packetfixer.PacketFixer;
import net.minecraftforge.fml.common.Mod;

@Mod(PacketFixer.MOD_ID)
public class PacketFixerForge {
    public PacketFixerForge() {
        PacketFixer.init();
    }
}
