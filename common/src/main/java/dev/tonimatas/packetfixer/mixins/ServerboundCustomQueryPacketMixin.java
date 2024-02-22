package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomQueryPacket.class, priority = 9999)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "method_43901", constant = @Constant(intValue = 1048576))
    private static int newSize(int constant) {
        return Integer.MAX_VALUE;
    }
}
