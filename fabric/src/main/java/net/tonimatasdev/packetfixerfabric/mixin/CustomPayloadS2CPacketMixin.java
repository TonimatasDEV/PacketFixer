package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CustomPayloadS2CPacket.class, priority = 999)
public class CustomPayloadS2CPacketMixin {
    @ModifyConstant(method = "<init>*", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return 2147483647;
    }
}
