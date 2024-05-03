package dev.tonimatas.packetfixer.mixin;

import net.minecraft.network.login.client.CCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CCustomPayloadLoginPacket.class, priority = 999)
public class CCustomPayloadLoginPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
