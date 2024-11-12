package moe.mmio.starry.biomes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.mmio.starry.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.world.ChunkEvent;

import java.util.Random;

public class BiomeStarry extends BiomeGenBase {
    public BiomeStarry(int biomeId) {
        super(biomeId);

        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.dirt;
        this.setColor(0x551A8B);
        this.setBiomeName("Starry");
        this.setTemperatureRainfall(0.8f, 0.4f);

        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 0x551A8B;
    }

    @Override
    public int getSkyColorByTemp(float temperature) {
        return 0x551A8B;
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        World world = event.world;
        if (world.provider.dimensionId == 0) {
            int x, y, z;
            Random rand = new Random();
            for (x = 0; x < 16; x++) {
                for (z = 0; z < 16; z++) {
                    for (y = 1; y < 256; y++) {
                        if (world.getBiomeGenForCoords(x, z) instanceof BiomeStarry) {
                            if (world.getBlock(x, y, z) == Blocks.stone) {
                                world.setBlock(x, y, z, ModItems.starry_stone);
                            }

                            if (rand.nextInt(100) < 5) {
                                world.setBlock(x, y, z, ModItems.starry_ore);
                            } else if (rand.nextInt(100) < 3) {
                                world.setBlock(x, y, z, ModItems.legend_ore);
                            }
                        }
                    }
                }
            }
        }
    }
}
