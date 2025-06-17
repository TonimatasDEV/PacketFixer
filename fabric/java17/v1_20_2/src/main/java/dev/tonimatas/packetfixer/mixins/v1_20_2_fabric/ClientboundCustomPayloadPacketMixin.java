package dev.tonimatas.packetfixer.mixins.v1_20_2_fabric;

import dev.tonimatas.packetfixer.common.Config;
import dev.tonimatas.packetfixer.common.Messages;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientboundCustomPayloadPacket.class)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int packetfixer$newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String packetfixer$newMessage(String value) {
        return Messages.getPayloadMessage();
    }
}
