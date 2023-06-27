package me.spongycat.spongify.recipes;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.util.ItemStackUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AutoReplantRecipe {
    public static void registerRecipe() {
        ItemStack hoe = new ItemStack(Material.NETHERITE_HOE, 1);
        hoe.addUnsafeEnchantment(Spongify.autoReplantEnchantment, 1);
        hoe.addEnchantment(Enchantment.DIG_SPEED, 5);
        hoe.addEnchantment(Enchantment.DURABILITY, 3);
        hoe.addEnchantment(Enchantment.MENDING, 1);
        hoe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        ItemStackUtil.setLore(hoe,ChatColor.GOLD + "Auto Replant I");

        ItemStack carrot = new ItemStack(Material.GOLDEN_CARROT, 1);
        carrot.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
        ItemStackUtil.setLore(carrot, ChatColor.LIGHT_PURPLE + "Special golden carrot with mysterious power...");
        ItemStackUtil.setDisplayName(carrot, ChatColor.GOLD + "Super Golden Carrot");

        RecipeChoice.ExactChoice carrotChoice = new RecipeChoice.ExactChoice(carrot);




        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Spongify.plugin, "Replant_Hoe"), hoe);
        recipe.shape("PXP", "XYX", "AAA");
        recipe.setIngredient('X', carrotChoice);
        recipe.setIngredient('Y', Material.NETHERITE_HOE);
        recipe.setIngredient('A', Material.NETHERITE_INGOT);
        recipe.setIngredient('P', Material.DISPENSER);

        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(Spongify.plugin, "Super_Carrot"), carrot);
        recipe2.shape("SSS", "SSS", "SSS");
        recipe2.setIngredient('S', Material.GOLDEN_CARROT);

        Bukkit.addRecipe(recipe);
        Bukkit.addRecipe(recipe2);
    }
    public static ItemStack getHoe() {
        ItemStack hoe = new ItemStack(Material.NETHERITE_HOE, 1);
        hoe.addUnsafeEnchantment(Spongify.autoReplantEnchantment, 1);
        hoe.addEnchantment(Enchantment.DIG_SPEED, 5);
        hoe.addEnchantment(Enchantment.DURABILITY, 3);
        hoe.addEnchantment(Enchantment.MENDING, 1);
        hoe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        ItemStackUtil.setLore(hoe,ChatColor.GOLD + "Auto Replant I");

        return hoe;
    }

    public static ItemStack getCarrot() {
        ItemStack carrot = new ItemStack(Material.GOLDEN_CARROT, 1);
        carrot.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
        ItemStackUtil.setLore(carrot, ChatColor.LIGHT_PURPLE + "Special golden carrot with mysterious power...");
        ItemStackUtil.setDisplayName(carrot, ChatColor.GOLD + "Super Golden Carrot");

        return carrot;
    }
}
