package moe.mmio.starry.blocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moe.mmio.starry.StarryMod;
import moe.mmio.starry.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.ArrayList;

public class BlockLegendOre extends Block {
    private IIcon Icon;

    public BlockLegendOre(Material material) {
        super(Material.rock);
        this.setHardness(17.0f);
        this.setResistance(25.0f);
        this.setBlockName("legend_ore");
        this.setBlockTextureName(StarryMod.MODID + ":legend_ore");
        this.setHarvestLevel("pickaxe", 3);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        drops.add(new ItemStack(ModItems.legend_ore, 1));

        return drops;
    }

    // 玩家靠近此方块时对玩家造成1点伤害
    @SubscribeEvent
    public void onPlayerTick(LivingEvent.LivingUpdateEvent event) {
        if (!(event.entity instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.entity;
        World world = player.worldObj;

        // 确定玩家是否在这个方块附近
        int playerX = (int) player.posX;
        int playerY = (int) player.posY;
        int playerZ = (int) player.posZ;

        // 伤害半径
        int radius = 2;

        // 遍历半径内所有方块
        for (int x = playerX - radius; x <= playerX + radius; x++) {
            for (int y = playerY - radius; y <= playerY + radius; y++) {
                for (int z = playerZ - radius; z <= playerZ + radius; z++) {
                    // 检查是不是 legend_ore
                    if (world.getBlock(x, y, z) == this) {
                        if (player.ticksExisted % 10 == 0) {
                            // 每10刻造成1点伤害
                            player.attackEntityFrom(DamageSource.generic, 1.0f);
                        }
                        return;
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
    }
}
