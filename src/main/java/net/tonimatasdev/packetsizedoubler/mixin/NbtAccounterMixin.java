package net.tonimatasdev.packetsizedoubler.mixin;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.NbtAccounter;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NbtAccounter.class, priority = 999)
public class NbtAccounterMixin {
    @Redirect(method = "accountBytes", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J", opcode = Opcodes.GETFIELD))
    private long newSize(NbtAccounter instance) {
        LogUtils.getLogger().info(String.valueOf(2097152L * 1000));
        return 2097152L * 1000;
    }
}
