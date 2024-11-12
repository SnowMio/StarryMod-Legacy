package moe.mmio.starry.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes {
    public static void initModBiomes() {
        registerBiomesStage1();
        registerBiomesStage2();
    }

    public static final BiomeGenBase starry_biome = new BiomeStarry(215);

    private static void registerBiomesStage1() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(starry_biome, 10));
    }

    private static void registerBiomesStage2() {
        BiomeManager.addSpawnBiome(starry_biome);
    }
}
