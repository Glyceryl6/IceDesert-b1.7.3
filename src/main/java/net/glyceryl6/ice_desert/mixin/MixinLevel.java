package net.glyceryl6.ice_desert.mixin;

import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Level.class)
public class MixinLevel {

    @ModifyArg(method = "method_242", at = @At(value = "INVOKE", target = "Lnet/minecraft/level/LevelProperties;setTime(J)V", ordinal = 1))
    public long method_242(long newTime) {
        return 1000L;
    }

}