package dev.tonimatas.packetfixer.mixin;

import net.minecraft.network.PacketBuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(PacketBuffer.class)
public class PacketBufferMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundNBT;", constant = @Constant(longValue = 2097152L))
    public long newSize(long value) {
        return Long.MAX_VALUE;
    }
}
