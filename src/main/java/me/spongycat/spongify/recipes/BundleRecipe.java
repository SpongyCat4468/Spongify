package me.spongycat.spongify.recipes;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.spongifyData.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BundleRecipe {
    public static void registerRecipe() {
        ItemStack bundle = new ItemStack(Material.BUNDLE);

        ShapedRecipe bundleRecipe = new ShapedRecipe(new NamespacedKey(Spongify.plugin, "bundle"), bundle);
        bundleRecipe.shape("DXD", "X X", "XXX");
        bundleRecipe.setIngredient('X', Material.RABBIT_HIDE);
        bundleRecipe.setIngredient('D', Material.STRING);

        if (Config.CAN_CRAFT_BUNDLE) {
            Bukkit.addRecipe(bundleRecipe);
        }
    }
}
