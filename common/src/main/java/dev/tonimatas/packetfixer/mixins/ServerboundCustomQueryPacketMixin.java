package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ServerboundCustomQueryPacket.class, priority = 9999)
public class ServerboundCustomQueryPacketMixin {
    @ModifyVariable(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/network/FriendlyByteBuf;readNullable(Lnet/minecraft/network/FriendlyByteBuf$Reader;)Ljava/lang/Object;"), index = 1, argsOnly = true)
    private FriendlyByteBuf redirectReadNullable(FriendlyByteBuf value) {
        return new FriendlyByteBuf(value.readBytes(value.readableBytes()));
    }
}
