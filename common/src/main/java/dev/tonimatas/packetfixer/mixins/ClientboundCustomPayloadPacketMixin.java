package dev.tonimatas.packetfixer.mixins;


import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ClientboundCustomPayloadPacket.class, priority = 9999)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "method_56460", constant = @Constant(intValue = 1048576))
    private static int newSize$1(int value) {
        return Integer.MAX_VALUE;
    }

    @ModifyConstant(method = "method_56461", constant = @Constant(intValue = 1048576))
    private static int newSize$2(int value) {
        return Integer.MAX_VALUE;
    }

}
