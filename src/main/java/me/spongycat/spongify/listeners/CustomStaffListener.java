package me.spongycat.spongify.listeners;

import me.spongycat.spongify.items.Item;
import me.spongycat.spongify.util.CommandUtil;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CustomStaffListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack itemInMainHand = p.getInventory().getItemInMainHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (itemInMainHand.isSimilar(Item.CHAOS_STAFF)) {
                Fireball fireball = p.launchProjectile(Fireball.class);
                fireball.setVelocity(p.getLocation().getDirection().multiply(5));
            } else if (itemInMainHand.isSimilar(Item.TELEPORT_STAFF)) {
                p.launchProjectile(EnderPearl.class);
            } else if (itemInMainHand.isSimilar(Item.JUDGEMENT_STAFF)) {
                CommandUtil.executeCommand("disasters start purge 1");
            } else if (itemInMainHand.isSimilar(Item.HOLY_STAFF)) {
                CommandUtil.executeCommand("leveledmobs kill radius 15 * /nodrops");
            }
        }
    }
}
