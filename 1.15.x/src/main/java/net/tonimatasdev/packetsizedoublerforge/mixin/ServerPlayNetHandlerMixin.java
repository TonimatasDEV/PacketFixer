package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.play.ServerPlayNetHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ServerPlayNetHandler.class})
public class ServerPlayNetHandlerMixin {

    @ModifyConstant(method = "tick", constant = @Constant(longValue = 15000L, ordinal = 0))
    private long injected(long value) {
        return value*4;
    }
}