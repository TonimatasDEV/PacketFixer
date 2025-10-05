package dev.tonimatas.packetfixer;

import dev.tonimatas.packetfixer.platform.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketFixerCommon {
    public static final String MOD_ID = "packetfixer";
    public static final Logger LOGGER = LoggerFactory.getLogger("Packet Fixer");

    public static void init() {
        String platform = Services.PLATFORM.getPlatformName();
        String version = Services.PLATFORM.getModVersion();
        LOGGER.info("Packet Fixer {} {} has been initialized!", version, platform);
    }
}
