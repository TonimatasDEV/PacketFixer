package net.tonimatasdev.packetfixer;

import com.mojang.logging.LogUtils;

public class PacketFixer {
    public static final String MOD_ID = "packetfixer";

    public static void init() {
        LogUtils.getLogger().info("PacketFixer has been initialized successfully");
    }
}
