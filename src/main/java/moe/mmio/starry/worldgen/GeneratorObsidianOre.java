package moe.mmio.starry.worldgen;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import moe.mmio.starry.items.ModItems;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GeneratorObsidianOre implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                break;
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                break;
        }
    }

    private void generateNether(World world, Random random, int x, int z) {
        for (int i = 0; i < 9; i++) {
            int genX = x + random.nextInt(16);
            int genY = 5 + random.nextInt(64);
            int genZ = z + random.nextInt(16);
            FMLLog.info("Generating obsidian_ore at %d %d %d", genX, genY, genZ);
            // Forge我喜欢你
            // WorldGenMinable默认只会替换 minecraft:stone
            // 我说为什么排查了半天都不生成
            // new WorldGenMinable(ModItems.obsidian_ore, 1 + random.nextInt(4)).generate(world, random, genX, genY, genZ);
            GeneratorOreNether.generate(world, random, genX, genY, genZ, 4, ModItems.obsidian_ore);
        }
    }


}
