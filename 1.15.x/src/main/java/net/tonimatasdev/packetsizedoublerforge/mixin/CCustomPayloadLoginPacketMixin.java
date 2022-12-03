package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.login.client.CCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CCustomPayloadLoginPacket.class)
public class CCustomPayloadLoginPacketMixin {

    @ModifyConstant(method ="readPacketData", constant = @Constant(intValue = 1048576))
    private int injected(int value) {
        return value*10;
    }

}
