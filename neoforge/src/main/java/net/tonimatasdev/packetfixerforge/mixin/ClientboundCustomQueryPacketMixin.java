package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.protocol.login.ClientboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ClientboundCustomQueryPacket.class, priority = 9999)
public class ClientboundCustomQueryPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
