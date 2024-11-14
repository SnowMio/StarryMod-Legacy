package moe.mmio.starry.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EventWitherFight {
    private int hitCounter = 10;

    private boolean isWitherPresent(World world) {
        for (Object entity : world.loadedEntityList) {
            if (entity instanceof EntityWither) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            World world = player.worldObj;

            if (isWitherPresent(world) && (event.source.getEntity() instanceof EntityWither || event.source.isProjectile())) {
                hitCounter--;

                if (hitCounter <= 0) {
                    player.setDead();
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.wither_kill")));
                    hitCounter = 10;
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            World world = player.worldObj;

            if (isWitherPresent(world)) {
                for (Object entity : world.loadedEntityList) {
                    if (entity instanceof EntityWither) {
                        EntityWither wither = (EntityWither) entity;
                        wither.setDead();
                        world.createExplosion(null, wither.posX, wither.posY, wither.posZ, 0.0F, false);
                    }
                }
            }
        }
    }
}
