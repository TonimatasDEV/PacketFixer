package dev.tonimatas.packetfixer.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

public class Hooks {
    @ExpectPlatform
    public static boolean isModLoaded(String modId) {
        throw new NotImplementedException();
    }
}
