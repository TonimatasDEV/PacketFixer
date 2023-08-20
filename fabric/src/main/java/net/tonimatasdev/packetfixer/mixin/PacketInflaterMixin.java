package net.tonimatasdev.packetfixer.mixin;

import net.minecraft.network.PacketInflater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketInflater.class, priority = 999)
public class PacketInflaterMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 2097152), require = 0)
    private int newSize(int value) {
        return value * 100;
    }
}