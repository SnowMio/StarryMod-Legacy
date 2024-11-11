package moe.mmio.starry.blocks;

import moe.mmio.starry.StarryMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockObsidianOre extends Block {
    private IIcon Icon;

    public BlockObsidianOre(Material material) {
        super(Material.rock);
        this.setHardness(45.5f);
        this.setResistance(60.5f);
        this.setBlockName("obsidian_ore");
        this.setBlockTextureName(StarryMod.MODID + ":obsidian_ore");
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(0.1f);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        drops.add(new ItemStack(Blocks.obsidian, 2));

        return drops;
    }
}
