package dev.tonimatas.packetfixer.mixins.v1_20_5_neoforge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomPayloadPacket.class)
public class ServerboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "lambda$static$0", constant = @Constant(intValue = 32767))
    private static int packetfixer$newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "lambda$static$2", constant = @Constant(intValue = 32767))
    private static int packetfixer$newSize$1(int value) {
        return Config.getPacketSize();
    }
}
