package me.spongycat.spongify.GUI;

import me.spongycat.spongify.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FletchingTableGUI{
    public static Inventory getGUI() {
        Inventory fletchingGUI = Bukkit.createInventory(null, 45, "Fletching Table");

        ItemStack greenGlassPane = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemStack fletch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack toUpgradeGUI = new ItemStack(Material.PAPER);
        ItemStackUtil.setDisplayName(fletch, ChatColor.YELLOW + "Click To Fletch Your Custom Arrow!");
        ItemStackUtil.setDisplayName(toUpgradeGUI, ChatColor.BLUE + "Click To Jump To Upgrade Page");
        for (int i = 0; i <= 44; i++) {
            if ((i < 10 || i > 16 || i == 11 || i == 12 || i == 14 || i == 15) && i != 31) {
                fletchingGUI.setItem(i, greenGlassPane);
            }
        }
        fletchingGUI.setItem(31, new ItemStack(Material.AIR));
        fletchingGUI.setItem(22, fletch);
        fletchingGUI.setItem(44, toUpgradeGUI);

        return fletchingGUI;
    }

    public static Inventory getUpgradeGUI() {
        Inventory upgradeGUI = Bukkit.createInventory(null, 45, "Upgrade");

        ItemStack lightBlueGlassPane = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemStack upgrade = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemStackUtil.setDisplayName(upgrade, ChatColor.LIGHT_PURPLE + "Click To Upgrade Your Custom Arrow!");
        for (int i = 0; i <= 44; i++) {
            if ((i < 10 || i > 16 || i == 11 || i == 12 || i == 14 || i == 15) && i != 31) {
                upgradeGUI.setItem(i, lightBlueGlassPane);
            }
        }
        upgradeGUI.setItem(22, upgrade);

        return upgradeGUI;
    }
    public static void openInventory(final HumanEntity ent) {
        ent.openInventory(getGUI());
    }

    public static void openUpgradeGUI(final HumanEntity ent) {
        ent.closeInventory();
        ent.openInventory(getUpgradeGUI());
    }
}
