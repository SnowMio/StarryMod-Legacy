package moe.mmio.starry.blocks;

import moe.mmio.starry.StarryMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockStarryStone extends Block {
    private IIcon Icon;

    public BlockStarryStone(Material material) {
        super(Material.rock);
        this.setHardness(45.5f);
        this.setResistance(60.5f);
        this.setBlockName("starry_stone");
        this.setBlockTextureName(StarryMod.MODID + ":starry_stone");
        this.setHarvestLevel("pickaxe", 2);
        this.setLightLevel(0.2f);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        drops.add(new ItemStack(Blocks.obsidian, 1));

        return drops;
    }
}
