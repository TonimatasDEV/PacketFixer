package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.play.server.SCustomPayloadPlayPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SCustomPayloadPlayPacket.class)
public class SCustomPayloadPlayPacketMixin {
    @ModifyConstant(method = {"<init>(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/network/PacketBuffer;)V", "read"}, constant = @Constant(intValue = 1048576))
    private int packetDoubler(int value) {
        return value*10;
    }
}
