package me.spongycat.spongify.listeners.FletchingGUI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CloseEvent implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory().containsAtLeast(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), 40)) {
            Inventory inv = e.getInventory();
            if (e.getPlayer() instanceof Player p) {
                if (inv.getItem(10) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(10));
                }
                if (inv.getItem(13) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(13));
                }
                if (inv.getItem(16) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(16));
                }
                if (inv.getItem(31) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(31));
                }
            }
        }
    }
}
