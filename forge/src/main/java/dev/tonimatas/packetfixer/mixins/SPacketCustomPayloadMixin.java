package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.play.server.SPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = SPacketCustomPayload.class, priority = 9999)
public class SPacketCustomPayloadMixin {
    @ModifyConstant(method = "<init>(Ljava/lang/String;Lnet/minecraft/network/PacketBuffer;)V", constant = @Constant(intValue = 1048576))
    private int newSize$init(int constant) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 1048576))
    private int newSize$readPacketData(int constant) {
        return Config.getPacketSize();
    }
}
