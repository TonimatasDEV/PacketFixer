package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Shadow
    private int playerIdleTimeout;

    @Redirect(method = "playerIdleTimeout", at = @At(value = "FIELD", target = "Lnet/minecraft/server/MinecraftServer;playerIdleTimeout:I"))
    private int packetfixer$playerIdleTimeout(MinecraftServer server) {
        return Math.max(playerIdleTimeout, Config.getTimeout());
    }
}
