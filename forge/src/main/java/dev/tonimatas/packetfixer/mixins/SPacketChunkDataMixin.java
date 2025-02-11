package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.play.server.SPacketChunkData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SPacketChunkData.class)
public class SPacketChunkDataMixin {
    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 2097152))
    private int init$size(int value) {
        return Config.getChunkPacketData();
    }

    @ModifyConstant(method = "readPacketData", constant = @Constant(stringValue = "Chunk Packet trying to allocate too much memory on read."))
    private String init$message(String constant) {
        return constant + " (" + Config.getChunkPacketData() + ") Modify it in the Packet Fixer config.";
    }
}
