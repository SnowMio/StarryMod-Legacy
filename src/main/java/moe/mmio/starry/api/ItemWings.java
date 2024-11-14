package moe.mmio.starry.api;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/* DEPARTED API WARNING
 * This API is departed.
 *
 * Affected class:
 * <NONE>
 */
public class ItemWings extends ItemArmor {
    private double flySpeed = 0.1;
    private int durabilityCost = 10;
    private Item repairItem = Items.feather;
    private int maxFlightTime = -1;
    private boolean isInfiniteFlight = true;

    public ItemWings() {
        super(ArmorMaterial.CLOTH, 0, 1);
    }

    public ItemWings setUnlocalizedName(String name) {
        super.setUnlocalizedName(name);
        return this;
    }

    public ItemWings setTextureName(String texture) {
        super.setTextureName(texture);
        return this;
    }

    public ItemWings setSpeed(double speed) {
        this.flySpeed = speed;
        return this;
    }

    public ItemWings setDurability(int durabilityCost) {
        this.durabilityCost = durabilityCost;
        return this;
    }

    public ItemWings setRepairItem(Item item) {
        this.repairItem = item;
        return this;
    }

    public ItemWings setMaxTime(int maxFlightTime) {
        this.maxFlightTime = maxFlightTime;
        this.isInfiniteFlight = maxFlightTime <= 0;
        return this;
    }

    private boolean hasWingsEquipped(EntityPlayer player) {
        ItemStack chestArmor = player.getCurrentArmor(2);
        return chestArmor != null && chestArmor.getItem() instanceof ItemWings;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        World world = player.worldObj;

        if (!world.isRemote && hasWingsEquipped(player)) {
            ItemStack wings = player.getCurrentArmor(2);

            if (player.isSneaking() && player.onGround) {
                player.fallDistance = 0;
            }

            if (player.capabilities.isFlying && wings.getItemDamage() < wings.getMaxDamage()) {
                player.motionY += flySpeed;
                player.fallDistance = 0;

                if (world.getTotalWorldTime() % 16 == 0) {
                    wings.damageItem(durabilityCost, player);
                }

                if (!isInfiniteFlight && wings.getItemDamage() >= maxFlightTime) {
                    player.capabilities.isFlying = false;
                }
            } else {
                player.capabilities.isFlying = false;
            }
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == this.repairItem;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }
}
