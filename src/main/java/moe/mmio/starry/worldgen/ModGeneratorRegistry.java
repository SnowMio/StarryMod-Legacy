package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModGeneratorRegistry {
    public static void initializeGenerators() {
        GameRegistry.registerWorldGenerator(new GeneratorStarryOre(), 1);
        GameRegistry.registerWorldGenerator(new GeneratorLegendOre(), 1);
        GameRegistry.registerWorldGenerator(new GeneratorObsidianOre(), 0);
        GameRegistry.registerWorldGenerator(new GeneratorHellGravel(), 0);
    }
}
