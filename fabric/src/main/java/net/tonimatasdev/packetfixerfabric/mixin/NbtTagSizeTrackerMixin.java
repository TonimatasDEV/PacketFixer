package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketByteBuf.class, priority = 9999)
public abstract class NbtTagSizeTrackerMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/NbtCompound;", constant = @Constant(longValue = 2097152L))
    public long newSize(long value) {
        return Long.MAX_VALUE;
    }
}
