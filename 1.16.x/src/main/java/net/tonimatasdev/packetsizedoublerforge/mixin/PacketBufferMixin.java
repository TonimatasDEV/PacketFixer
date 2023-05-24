package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.PacketBuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PacketBuffer.class)
public abstract class PacketBufferMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundNBT;", constant = @Constant(longValue = 2097152L))
    private long packetDoubler(long value) {
        return value * 100;
    }
}
