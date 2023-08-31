package net.tonimatasdev.packetfixerforge;

import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.packetfixer.PacketFixer;

@Mod(PacketFixer.MOD_ID)
public class PacketFixerForge {
    public PacketFixerForge() {
        PacketFixer.init();
    }
}
