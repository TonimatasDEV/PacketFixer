package dev.tonimatas.packetfixer.fabric.mixins;

import dev.tonimatas.packetfixer.platform.Services;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

public class FabricMixinConfig implements IMixinConfigPlugin {

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean isFabricApiHere = Services.PLATFORM.isModEnabled("fabric-api");

        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.PayloadHelperMixin")) {
            return isFabricApiHere;
        }

        return true;
    }

}
