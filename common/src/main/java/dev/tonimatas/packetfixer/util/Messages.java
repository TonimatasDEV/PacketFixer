package dev.tonimatas.packetfixer.util;

public class Messages {
    public static String getPayloadMessage() {
        return "Payload may not be larger than " + Config.getPacketSize() + " bytes. You can modify it in the Packet Fixer config.";
    }
}
