package me.spongycat.spongify.listeners.FletchingGUI;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static me.spongycat.spongify.GUI.FletchingTableGUI.openInventory;

public class InteractEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.FLETCHING_TABLE ) {
            openInventory(e.getPlayer());
        }
    }
}
