package net.tonimatasdev.packetfixerforge.mixin;


import net.minecraft.network.play.client.CCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CCustomPayloadPacket.class, priority = 999)
public class CCustomPayloadPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 32767))
    private int newSize(int value) {
        return value * 100;
    }
}
