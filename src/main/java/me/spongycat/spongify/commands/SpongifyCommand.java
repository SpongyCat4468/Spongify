package me.spongycat.spongify.commands;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.items.GodSwordItem;
import me.spongycat.spongify.recipes.AutoReplantRecipe;
import me.spongycat.spongify.recipes.SmeltingTouchRecipe;
import me.spongycat.spongify.util.Give;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
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
                        Material air = Material.AIR;
                        PlayerInventory pInventory = p.getInventory();
                        if (Objects.equals(args[1], "SmeltingTouch")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(SmeltingTouchRecipe.getSmeltingTouchBook());
                                p.sendMessage(ChatColor.GREEN + "You have received a " + ChatColor.YELLOW + "Smelting Touch I Book");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "AutoReplant")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(AutoReplantRecipe.getHoe());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Auto Replant Hoe");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "Bundle")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(new ItemStack(Material.BUNDLE));
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Bundle!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "SaradominHilt")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getSaradominHilt());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Saradomin Hilt!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "GuthixHilt")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getGuthixHilt());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Guthix Hilt!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ArmadylHilt")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getArmadylHilt());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Armadyl Hilt!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ZamorackHilt")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getZamorakHilt());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Zamorack Hilt!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "GodSwordBlade")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getGodSwordBlade());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " God Sword Blade!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "SaradominGodSword")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getSaradominGodSword());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Saradomin God Sword!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "GuthixGodSword")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getGuthixGodSword());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Guthix God Sword!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ArmadylGodSword")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getArmadylGodSword());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Armadyl God Sword!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        } else if (Objects.equals(args[1], "ZamorakGodSword")) {
                            if (pInventory.getItemInMainHand().getType() == air) {
                                pInventory.setItemInMainHand(GodSwordItem.getZamorakGodSword());
                                p.sendMessage(ChatColor.GREEN + "You have received a" + ChatColor.YELLOW + " Zamorak God Sword!");
                            } else {
                                p.sendMessage(ChatColor.RED + "You have to empty your hand before performing this command!");
                            }
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "You don't have permission spongify.give to perform this command!");
                    }
                } else if (Objects.equals(args[0], "about")) {
                    p.sendMessage(ChatColor.AQUA + "Author: SpongyCat\n" + ChatColor.GOLD + "Discord: SpongyCat#1562\n" + ChatColor.GREEN + "Github Repo: https://github.com/SpongyCat4468/Spongify\n" + ChatColor.LIGHT_PURPLE + "Enjoy This Plugin!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Usage of /spongify is " + ChatColor.BLUE + "/spongify lore, /spongify version, /spongify about, /spongify give");
            }
        } else if (Objects.equals(args[0], "consolegive") && args[2] != null && args[3] != null && commandSender instanceof ConsoleCommandSender) {
            Player p = Bukkit.getPlayerExact(args[2]);
            int amount = Integer.valueOf(args[3]);
            if (p != null) {
                if (Objects.equals(args[1], "SaradominHilt")) {
                    Give.givePlayer(p, GodSwordItem.getSaradominHilt(), amount, "Saradomin Hilt");
                } else if (Objects.equals(args[1], "GuthixHilt")) {
                    Give.givePlayer(p, GodSwordItem.getGuthixHilt(), amount, "Guthix Hilt");
                } else if (Objects.equals(args[1], "ArmadylHilt")) {
                    Give.givePlayer(p, GodSwordItem.getArmadylHilt(), amount, "Armadyl Hilt");
                } else if (Objects.equals(args[1], "ZamorackHilt")) {
                    Give.givePlayer(p, GodSwordItem.getZamorakHilt(), amount, "Zamorack Hilt");
                } else if (Objects.equals(args[1], "GodSwordBlade")) {
                    Give.givePlayer(p, GodSwordItem.getGodSwordBlade(), amount, "God Sword Blade");
                } else if (Objects.equals(args[1], "SaradominGodSword")) {
                    Give.givePlayer(p, GodSwordItem.getSaradominGodSword(), amount, "Saradomin God Sword");
                } else if (Objects.equals(args[1], "GuthixGodSword")) {
                    Give.givePlayer(p, GodSwordItem.getGuthixGodSword(), amount, "Guthix God Sword");
                } else if (Objects.equals(args[1], "ArmadylGodSword")) {
                    Give.givePlayer(p, GodSwordItem.getArmadylGodSword(), amount, "Armadyl God Sword");
                } else if (Objects.equals(args[1], "ZamorakGodSword")) {
                    Give.givePlayer(p, GodSwordItem.getZamorakGodSword(), amount, "Zamorak God Sword");
                }
            }
        }
        return true;
    }
}
