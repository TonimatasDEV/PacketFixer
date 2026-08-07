package dev.tonimatas.packetfixer.neoforge.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomPayloadPacket.class)
public class ServerboundCustomPayloadPacketNeoForgeMixin {
    @ModifyConstant(method = "lambda$static$2", constant = @Constant(intValue = 32767))
    private static int packetfixer$newSize$1(int value) {
        return Config.getPacketSize();
    }
}
