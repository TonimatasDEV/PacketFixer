package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomPayloadPacket.class, priority = 9999)
public class ServerboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 32767))
    private static int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
