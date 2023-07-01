package net.tonimatasdev.packetsizedoubler;

import com.mojang.logging.LogUtils;

public class PacketSizeDoubler {
    public static final String MOD_ID = "packetsizedoubler";

    public static void init() {
        LogUtils.getLogger().info("PacketSizeDoubler has been enabled.");
    }
}
