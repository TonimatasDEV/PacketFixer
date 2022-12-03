package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.login.server.SCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SCustomPayloadLoginPacket.class)
public class SCustomPayloadLoginPacketMixin {

    @ModifyConstant(method ="readPacketData", constant = @Constant(intValue = 1048576))
    private int injected(int value) {
        return value*10;
    }

}
