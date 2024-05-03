package dev.tonimatas.packetfixer.mixin;

import net.minecraft.network.play.server.SCustomPayloadPlayPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = SCustomPayloadPlayPacket.class, priority = 999)
public class SCustomPayloadPlayPacketMixin {
    @ModifyConstant(method = {"<init>(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/network/PacketBuffer;)V", "read"}, constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
