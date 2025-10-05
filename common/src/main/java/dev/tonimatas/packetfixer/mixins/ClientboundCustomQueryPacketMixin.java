package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import dev.tonimatas.packetfixer.util.Messages;
import net.minecraft.network.protocol.login.ClientboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientboundCustomQueryPacket.class)
public class ClientboundCustomQueryPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int packetfixer$newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String packetfixer$newSize(String value) {
        return Messages.getPayloadMessage();
    }
}
