package net.tonimatasdev.packetsizedoubler.mixin;

import net.minecraft.network.protocol.game.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomPayloadPacket.class, priority = 999)
public class ServerboundCustomPayloadPacketMixin {
    @ModifyConstant(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", constant = @Constant(intValue = 32767))
    private int newSize(int value) {
        return 2147483647;
    }
}
