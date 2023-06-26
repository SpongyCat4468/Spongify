package me.spongycat.spongify.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Give {
    public static void givePlayer(Player p, ItemStack itemStack, int amount, String name) {
        PlayerInventory PI = p.getInventory();
        itemStack.setAmount(amount);
        int emptySlot = PI.firstEmpty();
        if (emptySlot == -1) {
            p.sendMessage(ChatColor.RED + "Your inventory is full, and " + name + " has appeared on the floor, beware!");
            p.getWorld().dropItem(p.getLocation(), itemStack);
        } else {
            PI.setItem(emptySlot, itemStack);
            p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " " + name + "!");
        }
    }
    public static void givePlayer(Player p, Material material, int amount, String name) {
        PlayerInventory PI = p.getInventory();
        ItemStack itemStack = new ItemStack(material);
        itemStack.setAmount(amount);
        int emptySlot = PI.firstEmpty();
        if (emptySlot == -1) {
            p.sendMessage(ChatColor.RED + "Your inventory is full, and a " + name + " has appeared on the floor, beware!");
            p.getWorld().dropItem(p.getLocation(), itemStack);
        } else {
            PI.setItem(emptySlot, itemStack);
            p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " " + name + "!");
        }
    }
}
