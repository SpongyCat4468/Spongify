package me.spongycat.spongify.listeners.FletchingGUI;

import me.spongycat.spongify.GUI.FletchingTableGUI;
import me.spongycat.spongify.util.PlayerUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;


public class DragEvent implements Listener {
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (FletchingTableGUI.isFletchingGUI(e.getInventory())) {
            e.setCancelled(true);
            PlayerUtil.sendDebugMessage(e.getWhoClicked(), "Drag Event cancelled.");
        }
    }
}
