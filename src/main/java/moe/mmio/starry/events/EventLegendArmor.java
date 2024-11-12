package moe.mmio.starry.events;

import akka.japi.Effect;
import cpw.mods.fml.common.event.FMLModDisabledEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.mmio.starry.armors.ArmorLegendArmor;
import moe.mmio.starry.effects.EffectLegendResurrection;
import moe.mmio.starry.effects.ModEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EventLegendArmor {
    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if (!(event.entity instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entity;

        if (ArmorLegendArmor.isWearingFullSet(player)) {
            if (player.getHealth() - event.ammount <= 0) {
                if (!player.isPotionActive(ModEffects.legendResurrection)) {
                    player.addPotionEffect(new PotionEffect(ModEffects.legendResurrection.id, 2400, 0));
                    event.setCanceled(true);
                    player.setHealth(player.getHealth() + 4.0f);
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("message.legend_resurrection")));
                }
            }
        }
    }
}
