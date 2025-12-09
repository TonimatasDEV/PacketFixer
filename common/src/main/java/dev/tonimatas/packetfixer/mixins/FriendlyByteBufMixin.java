package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FriendlyByteBuf.class)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readUtf()Ljava/lang/String;", constant = @Constant(intValue = 32767))
    private int packetfixer$readUtf$newSize(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "writeUtf(Ljava/lang/String;)Lnet/minecraft/network/FriendlyByteBuf;", constant = @Constant(intValue = 32767))
    private int packetfixer$writeUtf$newSize(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "readIdentifier", constant = @Constant(intValue = 32767))
    private int packetfixer$readResourceLocation$newSize(int value) {
        return Config.getStringSize();
    }
}
