package dev.tonimatas.packetfixer.platform.services;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Gets the version of Packet Fixer.
     *
     * @return The version of Packet Fixer.
     */
    String getModVersion();
}
