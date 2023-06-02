package me.spongycat.spongify.commands;

import jdk.dynalink.support.ChainedCallSite;
import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.items.VillagerDiscountItem;
import me.spongycat.spongify.recipes.AutoReplantRecipe;
import me.spongycat.spongify.recipes.SmeltingTouchRecipe;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class SpongifyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length != 0) {
                if (Objects.equals(args[0], "lore")) {
                    if (p.hasPermission("spongify.lore")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i]);
                            stringBuilder.append(" ");
                        }
                        String loreIndex = stringBuilder.toString().strip();
                        PlayerInventory pInventory = p.getInventory();
                        ItemStack itemInHand = pInventory.getItemInMainHand();
                        ItemMeta itemInHandMeta = itemInHand.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();
                        if (!Objects.equals(loreIndex, "clear")) {
                            lore.add(ChatColor.YELLOW + loreIndex);
                            itemInHandMeta.setLore(lore);
                            itemInHand.setItemMeta(itemInHandMeta);
                            pInventory.setItemInMainHand(itemInHand);
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "You don't have spongify.lore permission to perform this command!");
                    }
                } else if (Objects.equals(args[0], "version")) {
                    p.sendMessage(ChatColor.GREEN + "Spongify is on version " + ChatColor.LIGHT_PURPLE + Spongify.version);
                } else if (Objects.equals(args[0], "give")) {
                    if (p.hasPermission("spongify.give")) {
                        ItemStack air = new ItemStack(Material.AIR);
                        PlayerInventory pInventory = p.getInventory();
                        if (Objects.equals(args[1], "SmeltingTouch")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(SmeltingTouchRecipe.getSmeltingTouchBook());
                                p.sendMessage(ChatColor.GREEN + "You have received Smelting Touch I book");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "AutoReplant")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(AutoReplantRecipe.getHoe());
                                p.sendMessage(ChatColor.GREEN + "You have received Auto Replant Hoe");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "Bundle")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(new ItemStack(Material.BUNDLE));
                                p.sendMessage(ChatColor.GREEN + "You have received a bundle!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ZombifyToken")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(VillagerDiscountItem.getZombifyToken());
                                p.sendMessage(ChatColor.GREEN + "You have received a Zombify Token!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ZombifyWand")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(VillagerDiscountItem.getZombifyWand());
                                p.sendMessage(ChatColor.GREEN + "You have received a Zombify Wand!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "CureWand")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(VillagerDiscountItem.getCureWand());
                                p.sendMessage(ChatColor.GREEN + "You have received a Cure Wand!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "CureToken")) {
                            if (pInventory.getItemInMainHand().equals(air)) {
                                pInventory.setItemInMainHand(VillagerDiscountItem.getCureToken());
                                p.sendMessage(ChatColor.GREEN + "You have received a Cure Token!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "You don't have permission spongify.give to perform this command!");
                    }
                } else if (Objects.equals(args[0], "about")) {
                    p.sendMessage(ChatColor.AQUA + "Author: SpongyCat\n" + ChatColor.GOLD + "Discord: SpongyCat#1562\n" + ChatColor.LIGHT_PURPLE + "Enjoy This Plugin!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Usage of /spongify is " + ChatColor.BLUE + "/spongify lore, /spongify version, /spongify about, /spongify give");
            }
        }
        return true;
    }
}
