package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.nbt.NBTSizeTracker;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NBTSizeTracker.class, priority = 999)
public abstract class NbtAccounterMixin {
    @Redirect(method = "accountBits", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NBTSizeTracker;quota:J", opcode = Opcodes.GETFIELD))
    public long accountBits(NBTSizeTracker instance) {
        return 2097152 * 100;
    }
}
