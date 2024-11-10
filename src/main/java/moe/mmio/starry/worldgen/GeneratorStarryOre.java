package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import moe.mmio.starry.items.ModItems;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GeneratorStarryOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:  // Surface world
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case -1:  // Nether world
                break;
            case 1:   // End
                break;
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        for (int i = 0; i < 20; i++) { // 生成次数:20
            int genX = x + random.nextInt(16);
            int genY = 20 + random.nextInt(30);  // 生成层数: 20~50
            int genZ = z + random.nextInt(16);
            // 每簇生成1~8个矿物
            new WorldGenMinable(ModItems.starry_ore, 1 + random.nextInt(7)).generate(world, random, genX, genY, genZ);
        }
    }
}
