package moe.mmio.starry.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import static moe.mmio.starry.armors.ArmorLegendArmor.isWearingFullSet;

public class EventWitherFight {
    private int hitCounter = 6;

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
                    player.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.wither_kill")));
                    hitCounter = 6;
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

    @SubscribeEvent
    public void onWitherSpawn(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityWither) {
            World world = event.world;

            if (isWitherPresent(world)) {
                event.setCanceled(true);
                return;
            }

            for (Object obj : world.playerEntities) {
                if (obj instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) obj;
                    if (isWearingFullSet(player)) {
                        event.setCanceled(true);
                        player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.wither_deny")));
                        return;
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        World world = player.worldObj;

        if (isWearingFullSet(player) && isWitherPresent(world)) {
            for (Object entity : world.loadedEntityList) {
                if (entity instanceof EntityWither) {
                    ((EntityWither) entity).setDead();
                    return;
                }
            }
        }
    }
}
