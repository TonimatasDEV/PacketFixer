package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.play.client.CPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CPacketCustomPayload.class, priority = 9999)
public class CPacketCustomPayloadMixin {
    @ModifyConstant(method = "<init>(Ljava/lang/String;Lnet/minecraft/network/PacketBuffer;)V", constant = @Constant(intValue = 32767))
    private int newSize$init(int constant) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 32767))
    private int newSize$readPacketData(int constant) {
        return Config.getPacketSize();
    }
}
