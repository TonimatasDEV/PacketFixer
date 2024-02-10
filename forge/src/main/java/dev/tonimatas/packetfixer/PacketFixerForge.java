package dev.tonimatas.packetfixer;

import net.minecraftforge.fml.common.Mod;

@Mod(PacketFixer.MOD_ID)
public class PacketFixerForge {
    public PacketFixerForge() {
        PacketFixer.init();
    }
}
