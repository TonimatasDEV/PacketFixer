package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientboundCustomPayloadPacket.class)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "method_56460", constant = @Constant(intValue = 1048576))
    private static int packetfixer$newSize(int value) {
        return Config.getPacketSize();
    }
    
    @ModifyConstant(method = "method_56461", constant = @Constant(intValue = 1048576))
    private static int packetfixer$newSize$2(int value) {
        return Config.getPacketSize();
    }
}
