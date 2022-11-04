package net.glyceryl6.ice_desert.mixin;

import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.level.biome.Biome.*;

@Mixin(Biome.class)
public class MixinBiome {

    /**
     * @author glyceryl
     * @reason modify
     */
    @Overwrite
    public static Biome getClimateBiome(float temperature, float rainfall) {
        rainfall *= temperature;
        if (temperature < 0.1F) {
            return TUNDRA;
        } else if (rainfall < 0.2F) {
            if (temperature < 0.5F) {
                return TUNDRA;
            } else {
                return temperature < 0.95F ? SAVANNA : DESERT;
            }
        } else if (rainfall > 0.5F && temperature < 0.7F) {
            return SWAMPLAND;
        } else if (temperature < 0.5F) {
            return TAIGA;
        } else if (temperature < 0.6F) {
            return ICE_DESERT;
        } else if (temperature < 0.97F) {
            return rainfall < 0.35F ? SHRUBLAND : FOREST;
        } else if (rainfall < 0.45F) {
            return PLAINS;
        } else {
            return rainfall < 0.9F ? SEASONAL_FOREST : RAINFOREST;
        }
    }

}