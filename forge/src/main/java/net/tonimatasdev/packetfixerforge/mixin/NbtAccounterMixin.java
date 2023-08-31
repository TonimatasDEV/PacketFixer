package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.nbt.NbtAccounter;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NbtAccounter.class, priority = 999)
public abstract class NbtAccounterMixin {
    @Redirect(method = "accountBytes", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J", opcode = Opcodes.GETFIELD))
    public long accountBits(NbtAccounter instance) {
        return 2097152 * 100;
    }
}
