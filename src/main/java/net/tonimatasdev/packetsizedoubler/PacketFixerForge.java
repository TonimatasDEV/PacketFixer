package net.tonimatasdev.packetsizedoubler;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;

@Mod("packetfixer")
public class PacketFixerForge {
    public PacketFixerForge() {
        LogUtils.getLogger().info("PacketFixer (Forge) has been initialized successfully");
    }
}
