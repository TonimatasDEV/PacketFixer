package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.nbt.NbtAccounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NbtAccounter.class)
public class NbtAccounterMixin {
    @Mutable
    @Shadow @Final private long quota;

    @Inject(method = "accountBytes(J)V", at = @At("HEAD"))
    private void packetfixer$newSize(long size, CallbackInfo ci) {
        quota = Config.isForceUnlimitedNbtEnabled() ? Config.getNbtMaxSize() : quota;
    }
    
    @ModifyConstant(method = "defaultQuota", constant = @Constant(longValue = 2097152L))
    private static long packetfixer$defaultQuota$newSize(long constant) {
        return Config.getNbtMaxSize();
    }
}
