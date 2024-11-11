package moe.mmio.starry.worldgen.genfunc;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorOreTheEnd {
    public static void generate(World world, Random random, int x, int y, int z, int veinSize, Block ore) {
        for (int i = 0; i < veinSize; i++) {
            int offsetX = x + random.nextInt(3) - random.nextInt(3);
            int offsetY = y + random.nextInt(3) - random.nextInt(3);
            int offsetZ = z + random.nextInt(3) - random.nextInt(3);

            if (world.getBlock(offsetX, offsetY, offsetZ) == Blocks.end_stone) {
                world.setBlock(offsetX, offsetY, offsetZ, ore, 0, 2);
            }
        }
    }
}
