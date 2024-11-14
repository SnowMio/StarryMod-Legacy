package moe.mmio.starry.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUltimateCrusher extends Item {
    public ItemUltimateCrusher() {
        super();
        this.setMaxDamage(1024);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int x, int y, int z, EntityPlayer player) {
        World world = player.worldObj;
        Block block = world.getBlock(x, y, z);

        world.setBlockToAir(x, y, z);

        // Block dont drop items
        return true;
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack itemStack) {
        return true;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        return Float.MAX_VALUE;
    }
}
