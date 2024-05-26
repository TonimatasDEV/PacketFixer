package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomQueryPacket.class, priority = 999)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private String newSize(String constant) {
        return "Payload may not be larger than " + Config.getPacketSize() + " bytes. You can modify it in the Packet Fixer config.";
    }
}
