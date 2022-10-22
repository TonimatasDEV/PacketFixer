package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.login.ServerLoginNetHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerLoginNetHandler.class)
public class ServerLoginNetHandlerMixin {

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 600))
    private int injected(int value) {
        return value*10;
    }
}
