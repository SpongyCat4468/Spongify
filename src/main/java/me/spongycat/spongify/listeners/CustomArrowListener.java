package me.spongycat.spongify.listeners;

import me.spongycat.spongify.items.CustomArrow;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class CustomArrowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow arrow) {
            Player shooter = (Player) arrow.getShooter();

            // Check if the shooter has a custom item in their hand
            ItemStack itemInOffhand = shooter.getInventory().getItemInOffHand();
            if (isExplodeArrow(itemInOffhand)) {
                Location arrowLocation = arrow.getLocation();

                World world = arrowLocation.getWorld();
                float power = 5.0f;
                boolean setFire = false;
                world.createExplosion(arrowLocation, power, setFire);
                arrow.remove();
            } else if (isTeleportArrow(itemInOffhand)) {
                Location arrowLocation = arrow.getLocation();

                arrow.remove();
                shooter.teleport(arrowLocation);
            }
        }
    }

    private boolean isExplodeArrow(ItemStack itemStack) {
        return itemStack.isSimilar(CustomArrow.getExplodeArrow());
    }

    private boolean isTeleportArrow(ItemStack itemStack) {
        return itemStack.isSimilar(CustomArrow.getTeleportArrow());
    }
}









