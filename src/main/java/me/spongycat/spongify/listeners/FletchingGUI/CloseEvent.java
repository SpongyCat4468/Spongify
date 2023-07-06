package me.spongycat.spongify.listeners.FletchingGUI;

import me.spongycat.spongify.GUI.FletchingTableGUI;
import me.spongycat.spongify.util.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class CloseEvent implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (FletchingTableGUI.isFletchingGUI(e.getInventory())) {
            PlayerUtil.sendDebugMessage(e.getPlayer(), "You have closed the fletching table.");
            Inventory inv = e.getInventory();
            if (e.getPlayer() instanceof Player p) {
                if (inv.getItem(10) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(10));
                    PlayerUtil.sendDebugMessage(e.getPlayer(), "Items have dropped on the floor. First ingredient slot.");
                }
                if (inv.getItem(13) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(13));
                    PlayerUtil.sendDebugMessage(e.getPlayer(), "Items have dropped on the floor. Arrow slot.");
                }
                if (inv.getItem(16) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(16));
                    PlayerUtil.sendDebugMessage(e.getPlayer(), "Items have dropped on the floor. Second ingredient slot.");
                }
                if (inv.getItem(31) != null) {
                    p.getWorld().dropItem(p.getLocation(), inv.getItem(31));
                    PlayerUtil.sendDebugMessage(e.getPlayer(), "Items have dropped on the floor. Result slot.");
                }
            }
        }
    }
}
