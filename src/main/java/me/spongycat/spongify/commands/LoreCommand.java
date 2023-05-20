package me.spongycat.spongify.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (p.hasPermission("spongify.lore")) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    stringBuilder.append(args[i]);
                    stringBuilder.append(" ");
                }
                String loreIndex = stringBuilder.toString().strip();
                PlayerInventory pInventory = p.getInventory();
                ItemStack itemInHand = pInventory.getItemInMainHand();
                ItemMeta itemInHandMeta = itemInHand.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + loreIndex);
                itemInHandMeta.setLore(lore);
                itemInHand.setItemMeta(itemInHandMeta);
                pInventory.setItemInMainHand(itemInHand);
            }
        }
        return true;
    }
}
