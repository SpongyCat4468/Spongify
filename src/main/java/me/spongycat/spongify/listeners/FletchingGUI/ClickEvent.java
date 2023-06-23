package me.spongycat.spongify.listeners.FletchingGUI;

import me.spongycat.spongify.items.CustomArrow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        final ItemStack clickedItem = e.getCurrentItem();
        if (!e.getInventory().containsAtLeast(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), 40)) return;

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        if (!(clickedItem.getType() == Material.FIRE_CHARGE ||
                clickedItem.getType() == Material.ARROW ||
                clickedItem.getType() == Material.ENDER_PEARL)) {
            e.setCancelled(true);
        }

        ItemStack fletch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta fletchMeta = fletch.getItemMeta();
        fletchMeta.setDisplayName(ChatColor.YELLOW + "Click To Fletch Your Custom Arrow!");
        fletch.setItemMeta(fletchMeta);

        final Player p = (Player) e.getWhoClicked();

        Inventory inv = e.getInventory();


        ItemStack arrowSlot = inv.getItem(13);
        ItemStack firstIngredientSlot = inv.getItem(10);
        ItemStack secondIngredientSlot = inv.getItem(16);

        if (clickedItem.isSimilar(fletch)) {
            // 10, 13, 16
            if (firstIngredientSlot != null && arrowSlot != null) {
                if (arrowSlot.getType() == Material.ARROW) {
                    if (firstIngredientSlot.getType() == Material.FIRE_CHARGE) {
                        setResult(inv, CustomArrow.getExplodeArrow());
                    } else if (firstIngredientSlot.getType() == Material.ENDER_PEARL) {
                        setResult(inv, CustomArrow.getTeleportArrow());
                    }
                }
            }
        }
    }
    private static void setResult(Inventory inv ,ItemStack result) {
        inv.setItem(31, result);
        inv.clear(10);
        inv.clear(13);
        inv.clear(16);
    }
 }
