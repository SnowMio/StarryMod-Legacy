package moe.mmio.starry.biomes;

import moe.mmio.starry.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeStarry extends BiomeGenBase {
    public BiomeStarry(int id) {
        super(id);

        this.topBlock = Blocks.grass;
        this.fillerBlock = ModItems.starry_stone;
        this.theBiomeDecorator.generateLakes = false;

        this.setColor(0x4B0082);

        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
    }

    @Override
    public boolean canSpawnLightningBolt() {
        return false;
    }

    @Override
    public boolean getEnableSnow() {
        return false;
    }

    @Override
    public int getSkyColorByTemp(float temperature) {
        return 0x4B0082;
    }

    @Override
    public void decorate(World worldIn, Random random, int chunkX, int chunkZ) {
        super.decorate(worldIn, random, chunkX, chunkZ);

        this.theBiomeDecorator.gravelAsSandGen = null;
        this.theBiomeDecorator.gravelGen = null;
        this.theBiomeDecorator.diamondGen = null;
        this.theBiomeDecorator.ironGen = null;
        this.theBiomeDecorator.coalGen = null;
        this.theBiomeDecorator.redstoneGen = null;
        this.theBiomeDecorator.lapisGen = null;
        this.theBiomeDecorator.goldGen = null;

        for (int i = 0; i < 10; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(50);
            int z = chunkZ + random.nextInt(16);
            (new WorldGenMinable(ModItems.starry_ore, 4)).generate(worldIn, random, x, y, z);
        }
        for (int i = 0; i < 5; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(45);
            int z = chunkZ + random.nextInt(16);
            (new WorldGenMinable(ModItems.legend_ore, 2)).generate(worldIn, random, x, y, z);
        }
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random random, Block[] blocks, byte[] meta, int x, int z, double noiseVal) {
        super.genTerrainBlocks(worldIn, random, blocks, meta, x, z, noiseVal);

        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] == Blocks.stone) {
                    blocks[i] = ModItems.starry_stone;
            }
        }
    }
}
