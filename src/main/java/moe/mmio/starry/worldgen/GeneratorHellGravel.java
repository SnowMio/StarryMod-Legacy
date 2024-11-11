package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import moe.mmio.starry.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class GeneratorHellGravel implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                break;
            case -1:
                generateHellGravel(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                break;
        }
    }

    private void generateHellGravel(World world, Random random, int x, int z) {
        for (int i = 0; i < 20; i++) {
            int genX = x + random.nextInt(16);
            int genY = 10 + random.nextInt(80);
            int genZ = z + random.nextInt(16);

            if (world.getBlock(genX, genY, genZ) == Blocks.gravel) {
                world.setBlock(genX, genY, genZ, ModItems.hell_gravel, 0, 2);
            }
        }
    }
}
