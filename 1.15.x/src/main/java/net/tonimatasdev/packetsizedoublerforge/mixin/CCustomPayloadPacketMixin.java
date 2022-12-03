package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.play.client.CCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CCustomPayloadPacket.class)
public class CCustomPayloadPacketMixin {

    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 32767))
    private int injected(int value) {
        return value*10;
    }
}
