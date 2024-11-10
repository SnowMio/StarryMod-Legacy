package moe.mmio.starry.blocks;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockLegendOre extends Block {
    private IIcon Icon;

    public BlockLegendOre(Material material) {
        super(Material.rock);
        this.setHardness(20.0f);
        this.setResistance(25.0f);
        this.setBlockName("legend_ore");
        this.setBlockTextureName(StarryMod.MODID + ":legend_ore");
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        drops.add(new ItemStack(ModItems.legend_ingot, 1));

        return drops;
    }
}
