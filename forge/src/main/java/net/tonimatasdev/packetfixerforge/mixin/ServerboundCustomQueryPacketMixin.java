package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.protocol.login.ServerboundCustomQueryAnswerPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomQueryAnswerPacket.class, priority = 9999)
public class ServerboundCustomQueryPacketMixin {
    // <= 1.18
    //@ModifyConstant(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", constant = @Constant(intValue = 1048576))
    //private int newSize(int value) {
    //    return Integer.MAX_VALUE;
    //}

    // 1.19 to 1.20.1
    //@ModifyVariable(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/network/FriendlyByteBuf;readNullable(Lnet/minecraft/network/FriendlyByteBuf$Reader;)Ljava/lang/Object;"), index = 1, argsOnly = true)
    //private FriendlyByteBuf redirectReadNullable(FriendlyByteBuf value) {
    //    return new FriendlyByteBuf(value.readBytes(value.readableBytes()));
    //}

    // >= 1.20.2
    @ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
