package me.spongycat.spongify.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class RottenFleshToLeatherRecipe {
    public static void registerRecipe() {
        ItemStack leather = new ItemStack(Material.LEATHER);

        ItemStack SuperRottenFlesh = new ItemStack(Material.ROTTEN_FLESH);

        SuperRottenFlesh.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 5);
        ItemMeta RottenMeta = SuperRottenFlesh.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Super rotten flesh crafted by 5 normal rotten flesh.");
        RottenMeta.setLore(lore);
        SuperRottenFlesh.setItemMeta(RottenMeta);


        ShapedRecipe SuperRottenFleshRecipe = new ShapedRecipe(SuperRottenFlesh);
        SuperRottenFleshRecipe.shape("X X", " X ", "X X");
        SuperRottenFleshRecipe.setIngredient('X', Material.ROTTEN_FLESH);

        ShapedRecipe leatherRecipe = new ShapedRecipe(leather);
        leatherRecipe.shape("XX", "XX");
        leatherRecipe.setIngredient('X', new RecipeChoice.ExactChoice(SuperRottenFlesh));


        Bukkit.addRecipe(SuperRottenFleshRecipe);
        Bukkit.addRecipe(leatherRecipe);
    }
}