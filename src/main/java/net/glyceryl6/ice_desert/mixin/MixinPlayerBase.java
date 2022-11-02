package net.glyceryl6.ice_desert.mixin;

import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public abstract class MixinPlayerBase extends Living {

    public MixinPlayerBase(Level level) {
        super(level);
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void tick(CallbackInfo ci) {
        boolean isInLava = this.method_1335();
        boolean isInWater = this.method_1393();
        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            if (this.onGround) {
                this.setVelocity(this.velocityX * 1.8F, this.velocityY, this.velocityZ * 1.8F);
            } else if (isInLava || isInWater) {
                this.setVelocity(this.velocityX * 1.3F, this.velocityY, this.velocityZ * 1.3F);
            }
        }
    }

}