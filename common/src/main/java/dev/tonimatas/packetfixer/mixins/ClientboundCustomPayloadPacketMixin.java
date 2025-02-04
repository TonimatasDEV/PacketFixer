package dev.tonimatas.packetfixer.mixins;


import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientboundCustomPayloadPacket.class)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "method_56460", constant = @Constant(intValue = 1048576))
    private static int newSize$1(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "method_56461", constant = @Constant(intValue = 1048576))
    private static int newSize$2(int value) {
        return Config.getPacketSize();
    }

}
