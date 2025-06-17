package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.VarInt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = VarInt.class, priority = 1001)
public class VarIntMixin {
    @ModifyConstant(method = "getByteSize", constant = @Constant(intValue = 5))
    private static int packetfixer$getByteSize$newSize(int value) {
        return Config.getVarIntSize();
    }
    
    @ModifyConstant(method = "read", constant = @Constant(intValue = 5))
    private static int packetfixer$read$newSize(int value) {
        return Config.getVarIntSize();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "VarInt too big"))
    private static String packetfixer$read$newSize(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarIntSize() + ". You can modify it in the Packet Fixer config.";
    }
}
