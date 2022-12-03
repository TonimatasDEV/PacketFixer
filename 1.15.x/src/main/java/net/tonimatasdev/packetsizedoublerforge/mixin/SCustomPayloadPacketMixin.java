package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.play.server.SCustomPayloadPlayPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SCustomPayloadPlayPacket.class)
public class SCustomPayloadPacketMixin {

    @ModifyConstant(method ="<init>(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/network/PacketBuffer;)V", constant = @Constant(intValue = 1048576))
    private int injected(int value) {
        return value*10;
    }

    @ModifyConstant(method ="readPacketData", constant = @Constant(intValue = 1048576))
    private int injectedRead(int value) {
        return value*10;
    }
}
