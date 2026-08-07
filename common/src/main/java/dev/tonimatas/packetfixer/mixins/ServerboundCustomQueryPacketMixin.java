package dev.tonimatas.packetfixer.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import dev.tonimatas.packetfixer.PacketFixer;
import dev.tonimatas.packetfixer.util.Config;
import dev.tonimatas.packetfixer.util.Messages;
import net.minecraft.network.protocol.login.ServerboundCustomQueryAnswerPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerboundCustomQueryAnswerPacket.class)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int packetfixer$newSize(int value, @Local(name = "length") int length) {
        PacketFixer.LOGGER.info("CustomQueryPacket size {}", length);
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private static String packetfixer$newMessage(String value) {
        return Messages.getPayloadMessage();
    }
}