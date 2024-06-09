package dev.tonimatas.packetfixer.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class Config {
    private static Properties properties = null;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void runProperties() {
        try {
            File configFolder = new File("config");

            if (!configFolder.exists()) {
                configFolder.mkdirs();
            }

            File propertiesFile = new File(configFolder, "packetfixer.properties");
            properties = new Properties();

            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();

                properties.setProperty("nbtMaxSize", Long.toString(2097152 * 100));
                properties.setProperty("packetSize", Integer.toString(1048576 * 100));
                properties.setProperty("decoderSize", Integer.toString(8388608 * 100));
                properties.setProperty("varInt21", Integer.toString(8));

                save(propertiesFile);
            }

            properties.load(Files.newInputStream(propertiesFile.toPath()));

            checkVariable("nbtMaxSize", Long.toString(2097152 * 100));
            checkVariable("packetSize", Integer.toString(1048576 * 100));
            checkVariable("decoderSize", Integer.toString(8388608 * 100));
            checkVariable("varInt21", Integer.toString(8));
            save(propertiesFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long getNbtMaxSize() {
        if (properties == null) runProperties();
        return Long.parseLong(properties.getProperty("nbtMaxSize"));
    }

    public static int getPacketSize() {
        if (properties == null) runProperties();
        return Integer.parseInt(properties.getProperty("packetSize"));
    }

    public static int getDecoderSize() {
        if (properties == null) runProperties();
        return Integer.parseInt(properties.getProperty("decoderSize"));
    }

    public static int getVarInt21Size() {
        if (properties == null) runProperties();
        return Integer.parseInt(properties.getProperty("varInt21"));
    }

    private static void checkVariable(String variable, String defaultValue) {
        if (properties.getProperty(variable) == null) {
            properties.setProperty(variable, defaultValue);
        }
    }

    private static void save(File propertiesFile) throws IOException {
        properties.store(Files.newOutputStream(propertiesFile.toPath()),
                "Packet Fixer config file.\n" +
                        "Default values (minecraft default): nbtMaxSize 2097152, packetSize 1048576, decoderSize 2097152 and varInt21Size 3.\n" +
                        "Max values are " + Integer.MAX_VALUE + " for packetSize/decoderSize/varInt21 and " + Long.MAX_VALUE + " for nbtMaxSize.");
    }
}
