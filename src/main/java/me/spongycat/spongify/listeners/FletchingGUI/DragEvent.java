package me.spongycat.spongify.listeners.FletchingGUI;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;


public class DragEvent implements Listener {
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().containsAtLeast(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), 40)) {
            e.setCancelled(true);
        }
    }
}
