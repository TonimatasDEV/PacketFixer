package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Shadow
    private int playerIdleTimeout;

    @Inject(method = "playerIdleTimeout", at = @At("HEAD"), cancellable = true)
    private void packetfixer$playerIdleTimeout(CallbackInfoReturnable<Integer> cir) {
        if (playerIdleTimeout <= 0) {
            cir.setReturnValue(0);
        } else {
            cir.setReturnValue(Math.max(playerIdleTimeout, Config.getPlayerIdleTimeout()));
        }
    }
}
