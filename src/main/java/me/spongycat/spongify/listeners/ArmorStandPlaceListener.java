package me.spongycat.spongify.listeners;

import me.spongycat.spongify.spongifyData.Config;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPlaceEvent;

public class ArmorStandPlaceListener implements Listener {
    @EventHandler
    public void onArmorStandPlace(EntityPlaceEvent e) {
        if (e.getEntityType() == EntityType.ARMOR_STAND) {
            ArmorStand armorStand = (ArmorStand) e.getEntity();
            if (Config.IS_ARMOR_STAND_WITH_ARM) {
                armorStand.setArms(true);
            }
        }
    }
}
