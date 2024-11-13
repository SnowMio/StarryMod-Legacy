package moe.mmio.starry.items;

import moe.mmio.starry.StarryMod;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDragonResummoner extends Item {
    public ItemDragonResummoner() {
        this.setUnlocalizedName("dragon_resummoner");
        this.setTextureName(StarryMod.MODID + ":dragon_resummoner");
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.provider.dimensionId == 1) {
            if (world.getClosestPlayerToEntity(new EntityDragon(world), 200) == null) {
                if (!world.isRemote) {
                    EntityDragon newDragon = new EntityDragon(world);
                    newDragon.setLocationAndAngles(0, 127, 0, 0, 0);
                    world.spawnEntityInWorld(newDragon);
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + StatCollector.translateToLocal("message.dragonrespawn")));
                    stack.stackSize--;
                }
            } else {
                if (!world.isRemote) {
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.cannot_dragon_respawn")));
                }
            }
        } else {
            if (!world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.cannot_use_dragon_respawner")));
            }
        }
        return stack;
    }
}
