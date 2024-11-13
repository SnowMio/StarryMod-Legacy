package moe.mmio.starry.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.mmio.starry.StarryMod;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.world.ExplosionEvent;

public class EventNoCreeperGriefingBlocks {
    @SubscribeEvent
    public void onExplosionDetonate(ExplosionEvent.Detonate event) {
        if (!StarryMod.noCreeperGriefingBlocks) {
            return;
        }

        if (event.explosion.getExplosivePlacedBy() instanceof EntityCreeper) {
            event.getAffectedBlocks().clear();
        }
    }
}
