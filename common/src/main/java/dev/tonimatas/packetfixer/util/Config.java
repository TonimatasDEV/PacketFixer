package dev.tonimatas.packetfixer.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class Config {
    private static Properties properties = null;
    
    public static void runProperties() {
        try {
            File propertiesFile = new File(new File("config"), "packetfixer.properties");
            properties = new Properties();
            
            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();
                
                properties.setProperty("nbtMaxSize", Long.toString(2097152 * 100));
                properties.setProperty("packetSize", Integer.toString(1048576 * 100));
                properties.setProperty("decoderSize", Integer.toString(8388608 * 100));
                properties.store(Files.newOutputStream(propertiesFile.toPath()), 
                        "Packet Fixer config file.\n" +
                        "Default values (minecraft default): nbtMaxSize 2097152, packetSize 1048576 and decoderSize 2097152.\n" +
                        "Max values are " + Integer.MAX_VALUE + " for packetSize/decoderSize and " + Long.MAX_VALUE + " for nbtMaxSize.");
            }

            properties.load(Files.newInputStream(propertiesFile.toPath()));
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
}
