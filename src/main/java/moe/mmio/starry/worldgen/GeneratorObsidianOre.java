package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import moe.mmio.starry.items.ModItems;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GeneratorObsidianOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                break;
            case -1:
                break;
            case 1:
                generateTheEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateTheEnd(World world, Random random, int x, int z) {
        for (int i = 0; i < 6; i++) {
            int genX = x + random.nextInt(16);
            int genY = 5 + random.nextInt(128);
            int genZ = z + random.nextInt(16);
            new WorldGenMinable(ModItems.obsidian_ore, 1 + random.nextInt(4)).generate(world, random, genX, genY, genZ);
        }
    }
}