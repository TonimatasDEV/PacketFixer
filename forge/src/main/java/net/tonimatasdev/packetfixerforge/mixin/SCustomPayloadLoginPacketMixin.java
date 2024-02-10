package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.login.server.SCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = SCustomPayloadLoginPacket.class, priority = 999)
public class SCustomPayloadLoginPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return value * 100;
    }
}
