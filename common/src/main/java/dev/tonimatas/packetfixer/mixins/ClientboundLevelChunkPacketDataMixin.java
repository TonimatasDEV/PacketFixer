package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.game.ClientboundLevelChunkPacketData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientboundLevelChunkPacketData.class)
public class ClientboundLevelChunkPacketDataMixin {
    @ModifyConstant(method = "<init>(Lnet/minecraft/network/RegistryFriendlyByteBuf;II)V", constant = @Constant(intValue = 2097152))
    private int init$size(int value) {
        return Config.getChunkPacketData();
    }
    
    @ModifyConstant(method = "<init>(Lnet/minecraft/network/RegistryFriendlyByteBuf;II)V", constant = @Constant(stringValue = "Chunk Packet trying to allocate too much memory on read."))
    private String init$message(String constant) {
        return constant + " (" + Config.getChunkPacketData() + ") Modify it in the Packet Fixer config.";
    }
}
