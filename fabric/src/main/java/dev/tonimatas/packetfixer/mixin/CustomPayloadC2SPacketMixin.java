package dev.tonimatas.packetfixer.mixin;


import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CustomPayloadC2SPacket.class, priority = 9999)
public class CustomPayloadC2SPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 32767))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
