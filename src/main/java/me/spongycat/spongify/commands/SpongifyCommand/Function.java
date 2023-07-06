package me.spongycat.spongify.commands.SpongifyCommand;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.items.Item;
import me.spongycat.spongify.listeners.LavaSurvivalListener;
import me.spongycat.spongify.lists.DebugModePlayerList;
import me.spongycat.spongify.lists.LavaSurvivalList;
import me.spongycat.spongify.util.GiveUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

import static me.spongycat.spongify.Spongify.plugin;

public class Function {
    public static void give(Player p, String args, int amount) {
        if (p.hasPermission("spongify.give")) {
            if (Objects.equals(args, "SmeltingTouch")) {
                GiveUtil.givePlayer(p, Item.SMELTING_TOUCH_BOOK, amount, "Smelting Touch Book");
            } else if (Objects.equals(args, "AutoReplant")) {
                GiveUtil.givePlayer(p, Item.AUTO_REPLANT_HOE, amount, "Auto Replant Hoe");
            } else if (Objects.equals(args, "Bundle")) {
                GiveUtil.givePlayer(p, Material.BUNDLE, amount, "Bundle");
            } else if (Objects.equals(args, "SaradominHilt")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_HILT, amount, "Saradomin Hilt");
            } else if (Objects.equals(args, "GuthixHilt")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_HILT, amount, "Guthix Hilt");
            } else if (Objects.equals(args, "ArmadylHilt")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_HILT, amount, "Armadyl Hilt");
            } else if (Objects.equals(args, "ZamorakHilt")) {
                GiveUtil.givePlayer(p, Item.ZAMORAK_HILT, amount, "Zamorak Hilt");
            } else if (Objects.equals(args, "GodSwordBlade")) {
                GiveUtil.givePlayer(p, Item.GOD_SWORD_BLADE, amount, "God Sword Blade");
            } else if (Objects.equals(args, "SaradominGodSword")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_GOD_SWORD, amount, "Saradomin God Sword");
            } else if (Objects.equals(args, "GuthixGodSword")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_GOD_SWORD, amount, "Guthix God Sword");
            } else if (Objects.equals(args, "ArmadylGodSword")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_GOD_SWORD, amount, "Armadyl God Sword");
            } else if (Objects.equals(args, "ZamorakGodSword")) {
                GiveUtil.givePlayer(p, Item.ZAMORAK_GOD_SWORD, amount, "Zamorak God Sword");
            } else if (Objects.equals(args, "DiamondCore")) {
                GiveUtil.givePlayer(p, Item.DIAMOND_CORE, amount, "Diamond Core");
            } else if (Objects.equals(args, "SuperGoldenCarrot")) {
                GiveUtil.givePlayer(p, Item.SUPER_GOLDEN_CARROT, amount, "Super Golden Carrot");
            } else if (Objects.equals(args, "DiamondArrow")) {
                GiveUtil.givePlayer(p, Item.DIAMOND_ARROW, amount, "Diamond Arrow");
            } else if (Objects.equals(args, "NetheriteArrow")) {
                GiveUtil.givePlayer(p, Item.NETHERITE_ARROW, amount, "Netherite Arrow");
            } else if (Objects.equals(args, "ExplosiveArrow")) {
                GiveUtil.givePlayer(p, Item.EXPLOSIVE_ARROW, amount, "Explosive Arrow");
            } else if (Objects.equals(args, "TeleportArrow")) {
                GiveUtil.givePlayer(p, Item.TELEPORT_ARROW, amount, "Teleport Arrow");
            } else if (Objects.equals(args, "LightningArrow")) {
                GiveUtil.givePlayer(p, Item.LIGHTNING_ARROW, amount, "Lightning Arrow");
            } else if (Objects.equals(args, "LevitateArrow")) {
                GiveUtil.givePlayer(p, Item.LEVITATE_ARROW, amount, "Levitate Arrow");
            } else if (Objects.equals(args, "WitherArrow")) {
                GiveUtil.givePlayer(p, Item.WITHER_ARROW, amount, "Wither Arrow");
            } else if (Objects.equals(args, "DiamondArrowhead")) {
                GiveUtil.givePlayer(p, Item.DIAMOND_ARROWHEAD, amount, "Diamond Arrowhead");
            } else if (Objects.equals(args, "NetheriteArrowhead")) {
                GiveUtil.givePlayer(p, Item.NETHERITE_ARROWHEAD, amount, "Netherite Arrowhead");
            } else if (Objects.equals(args, "ArmadylArrowhead")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_ARROWHEAD, amount, "Armadyl Arrowhead");
            } else if (Objects.equals(args, "GuthixArrowhead")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_ARROWHEAD, amount, "Guthix Arrowhead");
            } else if (Objects.equals(args, "SaradominArrowhead")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_ARROWHEAD, amount, "Saradomin Arrowhead");
            } else if (Objects.equals(args, "ZamorakArrowhead")) {
                GiveUtil.givePlayer(p, Item.ZAMORAK_ARROWHEAD, amount, "Zamorak Arrowhead");
            } else if (Objects.equals(args, "ZarosArrowhead")) {
                GiveUtil.givePlayer(p, Item.ZAROS_ARROWHEAD, amount, "Zaros Arrowhead");
            } else if (Objects.equals(args, "ChaosStaff")) {
                GiveUtil.givePlayer(p, Item.CHAOS_STAFF, amount, "Chaos Staff");
            } else if (Objects.equals(args, "TeleportStaff")) {
                GiveUtil.givePlayer(p, Item.TELEPORT_STAFF, amount, "Teleport Staff");
            } else if (Objects.equals(args, "JudgementStaff")) {
                GiveUtil.givePlayer(p, Item.JUDGEMENT_STAFF, amount, "Judgement Staff");
            } else if (Objects.equals(args, "ShallNotPassStaff")) {
                GiveUtil.givePlayer(p, Item.SHALL_NOT_PASS_STAFF, amount, "Shall Not Pass Staff");
            } else if (Objects.equals(args, "HolyStaff")) {
                GiveUtil.givePlayer(p, Item.HOLY_STAFF, amount, "Holy Staff");
            }
        } else {
            p.sendMessage(ChatColor.RED + "You don't have permission spongify.give to perform this command!");
        }
    }

    public static void version(Player p) {
        p.sendMessage(ChatColor.GREEN + "Spongify is on version " + ChatColor.LIGHT_PURPLE + "v" + Spongify.version);
    }

    public static void about(Player p) {
        p.sendMessage(ChatColor.AQUA + "Author: SpongyCat\n" + ChatColor.GOLD + "Discord: SpongyCat#1562\n" + ChatColor.GREEN + "Github Repo: https://github.com/SpongyCat4468/Spongify\n" + ChatColor.LIGHT_PURPLE + "Enjoy This Plugin!");
    }

    public static void reload(Player p) {
        plugin.reloadConfig();
        p.sendMessage(ChatColor.GREEN + "Config Reloaded!");
    }

    public static void debug(Player p) {
        if (!DebugModePlayerList.containsPlayer(p)) {
            DebugModePlayerList.addPlayer(p);
        } else {
            DebugModePlayerList.removePlayer(p);
        }
    }

    public static void lore(Player p, String[] args) {
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
            lore.add(ChatColor.YELLOW + loreIndex);
            itemInHandMeta.setLore(lore);
            itemInHand.setItemMeta(itemInHandMeta);
            pInventory.setItemInMainHand(itemInHand);
        } else {
            p.sendMessage(ChatColor.RED + "You don't have spongify.lore permission to perform this command!");
        }
    }

    public static void consolegive(String[] args) {
        Player p = Bukkit.getPlayerExact(args[2]);
        int amount = Integer.valueOf(args[3]);
        if (p != null) {
            if (Objects.equals(args[1], "SaradominHilt")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_HILT, amount, "Saradomin Hilt");
            } else if (Objects.equals(args[1], "GuthixHilt")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_HILT, amount, "Guthix Hilt");
            } else if (Objects.equals(args[1], "ArmadylHilt")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_HILT, amount, "Armadyl Hilt");
            } else if (Objects.equals(args[1], "ZamorakHilt")) {
                GiveUtil.givePlayer(p, Item.ZAMORAK_HILT, amount, "Zamorak Hilt");
            } else if (Objects.equals(args[1], "GodSwordBlade")) {
                GiveUtil.givePlayer(p, Item.GOD_SWORD_BLADE, amount, "God Sword Blade");
            } else if (Objects.equals(args[1], "SaradominGodSword")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_GOD_SWORD, amount, "Saradomin God Sword");
            } else if (Objects.equals(args[1], "GuthixGodSword")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_GOD_SWORD, amount, "Guthix God Sword");
            } else if (Objects.equals(args[1], "ArmadylGodSword")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_GOD_SWORD, amount, "Armadyl God Sword");
            } else if (Objects.equals(args[1], "ZamorakGodSword")) {
                GiveUtil.givePlayer(p, Item.ZAMORAK_GOD_SWORD, amount, "Zamorak God Sword");
            }else if (Objects.equals(args[1], "ArmadylArrowhead")) {
                GiveUtil.givePlayer(p, Item.ARMADYL_ARROWHEAD, amount, "Armadyl Arrowhead");
            } else if (Objects.equals(args[1], "GuthixArrowhead")) {
                GiveUtil.givePlayer(p, Item.GUTHIX_ARROWHEAD, amount, "Guthix Arrowhead");
            } else if (Objects.equals(args[1], "SaradominArrowhead")) {
                GiveUtil.givePlayer(p, Item.SARADOMIN_ARROWHEAD, amount, "Saradomin Arrowhead");
            } else if (Objects.equals(args[1], "ZamorakArrowhead")) {
                GiveUtil.givePlayer(p, Item.ZAROS_ARROWHEAD, amount, "Zamorak Arrowhead");
            } else if (Objects.equals(args[1], "ZarosArrowhead")) {
                GiveUtil.givePlayer(p, Item.ZAROS_ARROWHEAD, amount, "Zaros Arrowhead");
            }
        }
    }

    public static void warn(Player p) {
        p.sendMessage(ChatColor.RED + "Usage of /spongify is " + ChatColor.BLUE + "/spongify lore, /spongify version, /spongify about, /spongify give, /spongify reload");
    }

    public static void lavasurvival(Player p, String name) {
        LavaSurvivalListener.addHologram(p.getLocation(), name);
    }
}
