package me.spongycat.spongify.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BundleRecipe {
    public static void registerRecipe() {
        ItemStack bundle = new ItemStack(Material.BUNDLE);

        ShapedRecipe bundleRecipe = new ShapedRecipe(bundle);
        bundleRecipe.shape("DXD", "X X", "XXX");
        bundleRecipe.setIngredient('X', Material.RABBIT_HIDE);
        bundleRecipe.setIngredient('D', Material.STRING);

        Bukkit.addRecipe(bundleRecipe);
    }
}
