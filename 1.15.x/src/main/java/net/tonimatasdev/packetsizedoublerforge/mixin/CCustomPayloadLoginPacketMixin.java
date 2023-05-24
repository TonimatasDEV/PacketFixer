package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.login.client.CCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CCustomPayloadLoginPacket.class)
public class CCustomPayloadLoginPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private int packetDoubler(int value) {
        return value * 100;
    }

}
