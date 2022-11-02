package net.glyceryl6.ice_desert.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.InGame;
import net.minecraft.client.render.TextRenderer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGame.class)
public class MixinInGame extends DrawableHelper {

    @Shadow private Minecraft minecraft;

    @Inject(method = "renderHud", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/InGame;drawTextWithShadow(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V",
            ordinal = 5, shift = At.Shift.AFTER))
    public void renderHud(float f, boolean flag, int i, int j, CallbackInfo ci) {
        TextRenderer renderer = this.minecraft.textRenderer;
        PlayerBase player = this.minecraft.player;
        Level level = player.level;
        int x = (int) player.x;
        int z = (int) player.z;
        String seed = "Seed: " + level.getSeed();
        BiomeSource source = level.getBiomeSource();
        Biome biome = source.getBiome(x, z);
        String info = "Biomes: " + biome.biomeName;
        this.drawTextWithShadow(renderer, info, 2, 104, 14737632);
        this.drawTextWithShadow(renderer, seed, 2, 112, 14737632);
    }

}