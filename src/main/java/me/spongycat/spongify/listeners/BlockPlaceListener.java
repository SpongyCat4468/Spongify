package me.spongycat.spongify.listeners;

import me.spongycat.spongify.items.GodSwordItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().isSimilar(GodSwordItem.getZamorakHilt()) || p.getInventory().getItemInOffHand().isSimilar(GodSwordItem.getZamorakHilt())) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You cannot place down a hilt!");
        }
    }
}
