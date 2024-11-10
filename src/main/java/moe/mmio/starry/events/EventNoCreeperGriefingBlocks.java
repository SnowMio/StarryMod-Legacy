package moe.mmio.starry.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.world.ExplosionEvent;

public class EventNoCreeperGriefingBlocks {
    @SubscribeEvent
    public void onExplosionDetonate(ExplosionEvent.Detonate event) {
        if (event.explosion.getExplosivePlacedBy() instanceof EntityCreeper) {
            event.getAffectedBlocks().clear();
        }
    }
}
