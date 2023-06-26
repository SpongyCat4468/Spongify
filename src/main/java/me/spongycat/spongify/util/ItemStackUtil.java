package me.spongycat.spongify.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackUtil {
    public static void setDisplayName(ItemStack item, String name) {
        ItemMeta itemMeta = item.getItemMeta();;
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
    }
    public static String getDisplayName(ItemStack item) {
        return item.getItemMeta().getDisplayName();
    }
    public static boolean isSimilarMaterial(ItemStack item, Material material) {
        return item.getType() == material;
    }

    public static boolean isSimilarItem(ItemStack item1, ItemStack item2) {
        return item1.isSimilar(item2);
    }


}
