package net.tonimatasdev.packetfixerfabric.mixin;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.handler.SplitterHandler;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SplitterHandler.class, priority = 9999)
public class SplitterHandlerMixin {
    @ModifyConstant(method = "shouldSplit", constant = @Constant(intValue = 3))
    private static int newSize(int value) {
        return 8;
    }

    @Inject(method = "handlerRemoved0", at = @At(value = "HEAD"), cancellable = true)
    private void redirectReadNullable(ChannelHandlerContext p_299287_, CallbackInfo ci) {
        Unpooled.directBuffer(8).release();
        ci.cancel();
    }

    @Redirect(method = "decode", at = @At(value = "FIELD", target = "Lnet/minecraft/network/handler/SplitterHandler;reusableBuf:Lio/netty/buffer/ByteBuf;", opcode = Opcodes.GETFIELD))
    public ByteBuf accountBits(SplitterHandler instance) {
        return Unpooled.directBuffer(8);
    }
}
