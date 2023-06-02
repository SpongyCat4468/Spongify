package me.spongycat.spongify.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerDiscountItem {
    public static ItemStack getZombifyWand() {
        ItemStack ZombifyWand = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemMeta zWandMeta = ZombifyWand.getItemMeta();
        zWandMeta.setDisplayName(ChatColor.AQUA + "Zombify Wand");
        ZombifyWand.setItemMeta(zWandMeta);

        return ZombifyWand;
    }

    public static ItemStack getZombifyToken() {
        ItemStack ZombifyToken = new ItemStack(Material.SUNFLOWER);
        ItemMeta zTokenMeta = ZombifyToken.getItemMeta();
        zTokenMeta.setDisplayName(ChatColor.YELLOW + "Zombify Token");
        ZombifyToken.setItemMeta(zTokenMeta);

        return ZombifyToken;
    }

    public static ItemStack getCureWand() {
        ItemStack CureWand = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemMeta cWandMeta = CureWand.getItemMeta();
        cWandMeta.setDisplayName(ChatColor.AQUA + "Cure Wand");
        CureWand.setItemMeta(cWandMeta);

        return CureWand;
    }

    public static ItemStack getCureToken() {
        ItemStack CureToken = new ItemStack(Material.SUNFLOWER);
        ItemMeta cTokenMeta = CureToken.getItemMeta();
        cTokenMeta.setDisplayName(ChatColor.YELLOW + "Cure Token");
        CureToken.setItemMeta(cTokenMeta);

        return CureToken;
    }









}
