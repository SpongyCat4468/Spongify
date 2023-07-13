package me.spongycat.spongify.commands.SpongifyCommand;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.spongifyData.Item;
import me.spongycat.spongify.listeners.LavaSurvivalListener;
import me.spongycat.spongify.lists.DebugModePlayerList;
import me.spongycat.spongify.util.GiveUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.spongycat.spongify.Spongify.plugin;

public class Function {
    public static void give(Player p, String args, int amount) {
        if (p.hasPermission("spongify.give")) {
            switch (args) {
                case "SmeltingTouch" -> GiveUtil.givePlayer(p, Item.SMELTING_TOUCH_BOOK, amount, "Smelting Touch Book");
                case "AutoReplant" -> GiveUtil.givePlayer(p, Item.AUTO_REPLANT_HOE, amount, "Auto Replant Hoe");
                case "Bundle" -> GiveUtil.givePlayer(p, Item.BUNDLE, amount, "Bundle");
                case "SaradominHilt" -> GiveUtil.givePlayer(p, Item.SARADOMIN_HILT, amount, "Saradomin Hilt");
                case "GuthixHilt" -> GiveUtil.givePlayer(p, Item.GUTHIX_HILT, amount, "Guthix Hilt");
                case "ArmadylHilt" -> GiveUtil.givePlayer(p, Item.ARMADYL_HILT, amount, "Armadyl Hilt");
                case "ZamorakHilt" -> GiveUtil.givePlayer(p, Item.ZAMORAK_HILT, amount, "Zamorak Hilt");
                case "GodSwordBlade" -> GiveUtil.givePlayer(p, Item.GOD_SWORD_BLADE, amount, "God Sword Blade");
                case "SaradominGodSword" -> GiveUtil.givePlayer(p, Item.SARADOMIN_GOD_SWORD, amount, "Saradomin God Sword");
                case "GuthixGodSword" -> GiveUtil.givePlayer(p, Item.GUTHIX_GOD_SWORD, amount, "Guthix God Sword");
                case "ArmadylGodSword" -> GiveUtil.givePlayer(p, Item.ARMADYL_GOD_SWORD, amount, "Armadyl God Sword");
                case "ZamorakGodSword" -> GiveUtil.givePlayer(p, Item.ZAMORAK_GOD_SWORD, amount, "Zamorak God Sword");
                case "DiamondCore" -> GiveUtil.givePlayer(p, Item.DIAMOND_CORE, amount, "Diamond Core");
                case "SuperGoldenCarrot" -> GiveUtil.givePlayer(p, Item.SUPER_GOLDEN_CARROT, amount, "Super Golden Carrot");
                case "DiamondArrow" -> GiveUtil.givePlayer(p, Item.DIAMOND_ARROW, amount, "Diamond Arrow");
                case "NetheriteArrow" -> GiveUtil.givePlayer(p, Item.NETHERITE_ARROW, amount, "Netherite Arrow");
                case "ExplosiveArrow" -> GiveUtil.givePlayer(p, Item.EXPLOSIVE_ARROW, amount, "Explosive Arrow");
                case "TeleportArrow" -> GiveUtil.givePlayer(p, Item.TELEPORT_ARROW, amount, "Teleport Arrow");
                case "LightningArrow" -> GiveUtil.givePlayer(p, Item.LIGHTNING_ARROW, amount, "Lightning Arrow");
                case "LevitateArrow" -> GiveUtil.givePlayer(p, Item.LEVITATE_ARROW, amount, "Levitate Arrow");
                case "WitherArrow" -> GiveUtil.givePlayer(p, Item.WITHER_ARROW, amount, "Wither Arrow");
                case "DiamondArrowhead" -> GiveUtil.givePlayer(p, Item.DIAMOND_ARROWHEAD, amount, "Diamond Arrowhead");
                case "NetheriteArrowhead" -> GiveUtil.givePlayer(p, Item.NETHERITE_ARROWHEAD, amount, "Netherite Arrowhead");
                case "ArmadylArrowhead" -> GiveUtil.givePlayer(p, Item.ARMADYL_ARROWHEAD, amount, "Armadyl Arrowhead");
                case "GuthixArrowhead" -> GiveUtil.givePlayer(p, Item.GUTHIX_ARROWHEAD, amount, "Guthix Arrowhead");
                case "SaradominArrowhead" -> GiveUtil.givePlayer(p, Item.SARADOMIN_ARROWHEAD, amount, "Saradomin Arrowhead");
                case "ZamorakArrowhead" -> GiveUtil.givePlayer(p, Item.ZAMORAK_ARROWHEAD, amount, "Zamorak Arrowhead");
                case "ZarosArrowhead" -> GiveUtil.givePlayer(p, Item.ZAROS_ARROWHEAD, amount, "Zaros Arrowhead");
                case "ChaosStaff" -> GiveUtil.givePlayer(p, Item.CHAOS_STAFF, amount, "Chaos Staff");
                case "TeleportStaff" -> GiveUtil.givePlayer(p, Item.TELEPORT_STAFF, amount, "Teleport Staff");
                case "JudgementStaff" -> GiveUtil.givePlayer(p, Item.JUDGEMENT_STAFF, amount, "Judgement Staff");
                case "ShallNotPassStaff" -> GiveUtil.givePlayer(p, Item.SHALL_NOT_PASS_STAFF, amount, "Shall Not Pass Staff");
                case "HolyStaff" -> GiveUtil.givePlayer(p, Item.HOLY_STAFF, amount, "Holy Staff");
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
        int amount = Integer.parseInt(args[3]);
        String item = args[1];

        assert p != null;

        switch (item) {
            case "SaradominHilt" -> GiveUtil.givePlayer(p, Item.SARADOMIN_HILT, amount, "Saradomin Hilt");
            case "GuthixHilt" -> GiveUtil.givePlayer(p, Item.GUTHIX_HILT, amount, "Guthix Hilt");
            case "ArmadylHilt" -> GiveUtil.givePlayer(p, Item.ARMADYL_HILT, amount, "Armadyl Hilt");
            case "ZamorakHilt" -> GiveUtil.givePlayer(p, Item.ZAMORAK_HILT, amount, "Zamorak Hilt");
            case "GodSwordBlade" -> GiveUtil.givePlayer(p, Item.GOD_SWORD_BLADE, amount, "God Sword Blade");
            case "SaradominGodSword" -> GiveUtil.givePlayer(p, Item.SARADOMIN_GOD_SWORD, amount, "Saradomin God Sword");
            case "GuthixGodSword" -> GiveUtil.givePlayer(p, Item.GUTHIX_GOD_SWORD, amount, "Guthix God Sword");
            case "ArmadylGodSword" -> GiveUtil.givePlayer(p, Item.ARMADYL_GOD_SWORD, amount, "Armadyl God Sword");
            case "ZamorakGodSword" -> GiveUtil.givePlayer(p, Item.ZAMORAK_GOD_SWORD, amount, "Zamorak God Sword");
            case "ArmadylArrowhead" -> GiveUtil.givePlayer(p, Item.ARMADYL_ARROWHEAD, amount, "Armadyl Arrowhead");
            case "GuthixArrowhead" -> GiveUtil.givePlayer(p, Item.GUTHIX_ARROWHEAD, amount, "Guthix Arrowhead");
            case "SaradominArrowhead" -> GiveUtil.givePlayer(p, Item.SARADOMIN_ARROWHEAD, amount, "Saradomin Arrowhead");
            case "ZamorakArrowhead" -> GiveUtil.givePlayer(p, Item.ZAMORAK_ARROWHEAD, amount, "Zamorak Arrowhead");
            case "ZarosArrowhead" -> GiveUtil.givePlayer(p, Item.ZAROS_ARROWHEAD, amount, "Zaros Arrowhead");
        }

    }

    public static void warn(Player p) {
        p.sendMessage(ChatColor.RED + "Usage of /spongify is " + ChatColor.BLUE + "/spongify lore, /spongify version, /spongify about, /spongify give, /spongify reload");
    }

    public static void lavasurvival(Player p, String name) {
        switch (name) {
            case "spawnHolo" -> LavaSurvivalListener.spawnHolo(p);
            case "clearQueue" -> LavaSurvivalListener.clearQueue();
            case "endGame" -> LavaSurvivalListener.endGame(p);
        }
    }
}
