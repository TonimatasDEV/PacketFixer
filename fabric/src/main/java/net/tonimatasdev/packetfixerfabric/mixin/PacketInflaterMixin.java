package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.PacketInflater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketInflater.class, priority = 9999)
public class PacketInflaterMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 8388608))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}