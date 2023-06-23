package me.spongycat.spongify.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FletchingTableGUI{
    private static Inventory fletchingGUI;

    public static Inventory getGUI() {
        fletchingGUI = Bukkit.createInventory(null, 45, "Fletching Table");

        ItemStack greenGlassPane = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemStack fletch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta fletchMeta = fletch.getItemMeta();
        fletchMeta.setDisplayName(ChatColor.YELLOW + "Click To Fletch Your Custom Arrow!");
        fletch.setItemMeta(fletchMeta);
        for (int i = 0; i <= 44; i++) {
            if (i < 10 || i > 16 || i == 11 || i == 12 || i == 14 || i ==15) {
                fletchingGUI.setItem(i, greenGlassPane);
            }
        }

        fletchingGUI.setItem(31, new ItemStack(Material.AIR));
        fletchingGUI.setItem(22, fletch);

        return fletchingGUI;
    }

    // You can open the inventory with this
    public static void openInventory(final HumanEntity ent) {
        ent.openInventory(getGUI());
    }

}
