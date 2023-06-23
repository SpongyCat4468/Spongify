package me.spongycat.spongify.items;

import me.spongycat.spongify.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomArrow {
    public static ItemStack getExplodeArrow() {
        ItemStack explodeArrow = new ItemStack(Material.ARROW);
        ItemStackUtil.setDisplayName(explodeArrow, ChatColor.RED + "Explosive Arrow");

        return explodeArrow;
    }

    public static ItemStack getTeleportArrow() {
        ItemStack teleportArrow = new ItemStack(Material.ARROW);
        ItemStackUtil.setDisplayName(teleportArrow, ChatColor.GREEN + "Teleport Arrow");

        return teleportArrow;
    }
}
