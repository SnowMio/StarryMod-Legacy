package moe.mmio.starry.blocks;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.items.ModItems;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockHellGravel extends BlockFalling {
    private IIcon Icon;

    public BlockHellGravel(Material material) {
        super(Material.sand);
        this.setBlockName("hell_gravel");
        this.setBlockTextureName(StarryMod.MODID + ":hell_gravel");
        this.setHarvestLevel("shovel", 0);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        Random rand = new Random();

        if (fortune > 0) {
            int chance = Math.min(10 + 10 * fortune, 100);
            if (rand.nextInt(100) < chance) {
                drops.add(new ItemStack(Items.flint));
            } else {
                drops.add(new ItemStack(ModItems.hell_gravel));
            }
        } else {
            if (rand.nextInt(10) == 0) {
                drops.add(new ItemStack(Items.flint));
            } else {
                drops.add(new ItemStack(ModItems.hell_gravel));
            }
        }

        return drops;
    }
}
