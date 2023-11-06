package net.tonimatasdev.packetfixerforge.mixin;


import net.minecraft.network.protocol.game.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ClientboundCustomPayloadPacket.class, priority = 9999)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "<init>*", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
