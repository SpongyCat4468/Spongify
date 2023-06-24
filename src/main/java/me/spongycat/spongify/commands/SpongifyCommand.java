package me.spongycat.spongify.commands;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.items.CustomArrowItem;
import me.spongycat.spongify.items.GodSwordItem;
import me.spongycat.spongify.recipes.AutoReplantRecipe;
import me.spongycat.spongify.recipes.BundleRecipe;
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
                    p.sendMessage(ChatColor.GREEN + "Spongify is on version " + ChatColor.LIGHT_PURPLE + "v" + Spongify.version);
                } else if (Objects.equals(args[0], "give")) {
                    if (p.hasPermission("spongify.give")) {
                        Material air = Material.AIR;
                        if (Objects.equals(args[1], "SmeltingTouch")) {
                            Give.givePlayer(p, SmeltingTouchRecipe.getSmeltingTouchBook(), 1, "Smelting Touch Book");
                        } else if (Objects.equals(args[1], "AutoReplant")) {
                            Give.givePlayer(p, AutoReplantRecipe.getHoe(), 1, "Auto Replant Hoe");
                        } else if (Objects.equals(args[1], "Bundle")) {
                            Give.givePlayer(p, Material.BUNDLE, 1, "Bundle");
                        } else if (Objects.equals(args[1], "SaradominHilt")) {
                            Give.givePlayer(p, GodSwordItem.getSaradominHilt(), 1, "Saradomin Hilt");
                        } else if (Objects.equals(args[1], "GuthixHilt")) {
                            Give.givePlayer(p, GodSwordItem.getGuthixHilt(), 1, "Guthix Hilt");
                        } else if (Objects.equals(args[1], "ArmadylHilt")) {
                            Give.givePlayer(p, GodSwordItem.getArmadylHilt(), 1, "Armadyl Hilt");
                        } else if (Objects.equals(args[1], "ZamorakHilt")) {
                            Give.givePlayer(p, GodSwordItem.getZamorakHilt(), 1, "Zamorak Hilt");
                        } else if (Objects.equals(args[1], "GodSwordBlade")) {
                            Give.givePlayer(p, GodSwordItem.getGodSwordBlade(), 1, "God Sword Blade");
                        } else if (Objects.equals(args[1], "SaradominGodSword")) {
                            Give.givePlayer(p, GodSwordItem.getSaradominGodSword(), 1, "Saradomin God Sword");
                        } else if (Objects.equals(args[1], "GuthixGodSword")) {
                            Give.givePlayer(p, GodSwordItem.getGuthixGodSword(), 1, "Guthix God Sword");
                        } else if (Objects.equals(args[1], "ArmadylGodSword")) {
                            Give.givePlayer(p, GodSwordItem.getArmadylGodSword(), 1, "Armadyl God Sword");
                        } else if (Objects.equals(args[1], "ZamorakGodSword")) {
                            Give.givePlayer(p, GodSwordItem.getZamorakGodSword(), 1, "Zamorak God Sword");
                        } else if (Objects.equals(args[1], "DiamondCore")) {
                            Give.givePlayer(p, SmeltingTouchRecipe.getDiamondCore(), 1, "Diamond Core");
                        } else if (Objects.equals(args[1], "SuperGoldenCarrot")) {
                            Give.givePlayer(p, AutoReplantRecipe.getCarrot(), 1, "Super Golden Carrot");
                        } else if (Objects.equals(args[1], "DiamondArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getDiamondArrow(), 1, "Diamond Arrow");
                        } else if (Objects.equals(args[1], "NetheriteArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getNetheriteArrow(), 1, "Netherite Arrow");
                        } else if (Objects.equals(args[1], "ExplosiveArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getExplosiveArrow(), 1, "Explosive Arrow");
                        } else if (Objects.equals(args[1], "TeleportArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getTeleportArrow(), 1, "Teleport Arrow");
                        } else if (Objects.equals(args[1], "LightningArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getLightningArrow(), 1, "Lightning Arrow");
                        } else if (Objects.equals(args[1], "LevitateArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getLevitateArrow(), 1, "Levitate Arrow");
                        } else if (Objects.equals(args[1], "WitherArrow")) {
                            Give.givePlayer(p, CustomArrowItem.getWitherArrow(), 1, "Wither Arrow");
                        } else if (Objects.equals(args[1], "DiamondArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getDiamondArrowhead(), 1, "Diamond Arrowhead");
                        } else if (Objects.equals(args[1], "NetheriteArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getNetheriteArrowhead(), 1, "Netherite Arrowhead");
                        } else if (Objects.equals(args[1], "ArmadylArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getArmadylArrowhead(), 1, "Armadyl Arrowhead");
                        } else if (Objects.equals(args[1], "GuthixArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getGuthixArrowhead(), 1, "Guthix Arrowhead");
                        } else if (Objects.equals(args[1], "SaradominArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getSaradominArrowhead(), 1, "Saradomin Arrowhead");
                        } else if (Objects.equals(args[1], "ZamorakArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getZamorakArrowhead(), 1, "Zamorak Arrowhead");
                        } else if (Objects.equals(args[1], "ZarosArrowhead")) {
                            Give.givePlayer(p, CustomArrowItem.getZarosArrowhead(), 1, "Zaros Arrowhead");
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
                }else if (Objects.equals(args[1], "ArmadylArrowhead")) {
                    Give.givePlayer(p, CustomArrowItem.getArmadylArrowhead(), amount, "Armadyl Arrowhead");
                } else if (Objects.equals(args[1], "GuthixArrowhead")) {
                    Give.givePlayer(p, CustomArrowItem.getGuthixArrowhead(), amount, "Guthix Arrowhead");
                } else if (Objects.equals(args[1], "SaradominArrowhead")) {
                    Give.givePlayer(p, CustomArrowItem.getSaradominArrowhead(), amount, "Saradomin Arrowhead");
                } else if (Objects.equals(args[1], "ZamorakArrowhead")) {
                    Give.givePlayer(p, CustomArrowItem.getZamorakArrowhead(), amount, "Zamorak Arrowhead");
                } else if (Objects.equals(args[1], "ZarosArrowhead")) {
                    Give.givePlayer(p, CustomArrowItem.getZarosArrowhead(), amount, "Zaros Arrowhead");
                }
            }
        }
        return true;
    }
}
