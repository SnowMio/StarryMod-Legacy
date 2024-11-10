package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import moe.mmio.starry.items.ModItems;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GeneratorLegendOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case -1:
                break;
            case 1:
                break;
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        for (int i = 0; i < 16; i++) { // 生成次数:20
            int genX = x + random.nextInt(16);
            int genY = 5 + random.nextInt(30);  // 生成层数: 20~50
            int genZ = z + random.nextInt(16);
            // 每簇生成1~8个矿物
            new WorldGenMinable(ModItems.legend_ore, 1 + random.nextInt(4)).generate(world, random, genX, genY, genZ);
        }
    }
}
