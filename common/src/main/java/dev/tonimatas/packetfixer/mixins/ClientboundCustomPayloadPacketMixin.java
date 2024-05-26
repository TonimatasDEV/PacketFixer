package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.game.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ClientboundCustomPayloadPacket.class, priority = 999)
public class ClientboundCustomPayloadPacketMixin {
    @ModifyConstant(method = {"read", "<init>(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/network/FriendlyByteBuf;)V"}, constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = {"read", "<init>(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/network/FriendlyByteBuf;)V"}, constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private String newSize(String constant) {
        return "Payload may not be larger than " + Config.getPacketSize() + " bytes. You can modify it in the Packet Fixer config.";
    }
}
