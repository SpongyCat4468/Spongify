package me.spongycat.spongify.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackUtil {
    public static void setDisplayName(ItemStack item, String name) {
        ItemMeta itemMeta = item.getItemMeta();;
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
    }
}
