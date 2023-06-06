package me.spongycat.spongify.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GodSwordItem {
    public static ItemStack getSaradominHilt() {
        ItemStack Saradomin_Hilt = new ItemStack(Material.GOLD_INGOT);

        ItemMeta SaradominMeta = Saradomin_Hilt.getItemMeta();
        SaradominMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Saradomin Hilt");
        Saradomin_Hilt.setItemMeta(SaradominMeta);
        Saradomin_Hilt.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 5);

        return Saradomin_Hilt;
    }

    public static ItemStack getGuthixHilt() {
        ItemStack Guthix_Hilt = new ItemStack(Material.EMERALD);

        ItemMeta GuthixMeta = Guthix_Hilt.getItemMeta();
        GuthixMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Guthix Hilt");
        Guthix_Hilt.setItemMeta(GuthixMeta);
        Guthix_Hilt.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 7);

        return Guthix_Hilt;
    }

    public static ItemStack getArmadylHilt() {
        ItemStack Armadyl_Hilt = new ItemStack(Material.DIAMOND);

        ItemMeta ArmadylMeta = Armadyl_Hilt.getItemMeta();
        ArmadylMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Armadyl Hilt");
        Armadyl_Hilt.setItemMeta(ArmadylMeta);
        Armadyl_Hilt.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);

        return Armadyl_Hilt;
    }

    public static ItemStack getZamorackHilt() {
        ItemStack Zamorack_Hilt = new ItemStack(Material.REDSTONE);

        ItemMeta ZamorackMeta = Zamorack_Hilt.getItemMeta();
        ZamorackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Zamorack Hilt");
        Zamorack_Hilt.setItemMeta(ZamorackMeta);
        Zamorack_Hilt.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);

        return Zamorack_Hilt;
    }

    public static ItemStack getGodSwordBlade() {
        ItemStack God_Sword_Blade = new ItemStack(Material.NETHERITE_INGOT);

        ItemMeta BladeMeta = God_Sword_Blade.getItemMeta();
        BladeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "God Sword Blade");
        God_Sword_Blade.setItemMeta(BladeMeta);
        God_Sword_Blade.addUnsafeEnchantment(Enchantment.DURABILITY, 4);

        return God_Sword_Blade;
    }

    public static ItemStack getSaradominGodSword() {
        ItemStack Saradomin_God_Sword = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta SMeta = Saradomin_God_Sword.getItemMeta();
        SMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Saradomin God Sword");
        Saradomin_God_Sword.setItemMeta(SMeta);
        Saradomin_God_Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
        Saradomin_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
        Saradomin_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        Saradomin_God_Sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);

        return Saradomin_God_Sword;
    }
    public static ItemStack getGuthixGodSword() {
        ItemStack Guthix_God_Sword = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta GMeta = Guthix_God_Sword.getItemMeta();
        GMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Guthix God Sword");
        Guthix_God_Sword.setItemMeta(GMeta);
        Guthix_God_Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
        Guthix_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        Guthix_God_Sword.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 5);
        Guthix_God_Sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);

        return Guthix_God_Sword;
    }
    public static ItemStack getArmadylGodSword() {
        ItemStack Armadyl_God_Sword = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta AMeta = Armadyl_God_Sword.getItemMeta();
        AMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Armadyl God Sword");
        Armadyl_God_Sword.setItemMeta(AMeta);
        Armadyl_God_Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
        Armadyl_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 7);
        Armadyl_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        Armadyl_God_Sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        Armadyl_God_Sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);

        return Armadyl_God_Sword;
    }

    public static ItemStack getZamorakGodSword() {
        ItemStack Zamorak_God_Sword = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta ZMeta = Zamorak_God_Sword.getItemMeta();
        ZMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Zamorak God Sword");
        Zamorak_God_Sword.setItemMeta(ZMeta);
        Zamorak_God_Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
        Zamorak_God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 9);
        Zamorak_God_Sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
        Zamorak_God_Sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);

        return Zamorak_God_Sword;
    }
}
