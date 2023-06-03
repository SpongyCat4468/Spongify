package me.spongycat.spongify.recipes;

import me.spongycat.spongify.util.NameSpaceKeyCreator;
import me.spongycat.spongify.items.VillagerDiscountItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class VillagerDiscountRecipe {
    public static void registerRecipe() {
        ItemStack splashWeaknessPotion = new ItemStack(Material.SPLASH_POTION);
        PotionMeta potionMeta = (PotionMeta) splashWeaknessPotion.getItemMeta();
        potionMeta.setBasePotionData(new PotionData(PotionType.WEAKNESS));
        splashWeaknessPotion.setItemMeta(potionMeta);
        RecipeChoice.ExactChoice weaknessChoice = new RecipeChoice.ExactChoice(splashWeaknessPotion);

        ItemStack strengthPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta1 = (PotionMeta) strengthPotion.getItemMeta();
        potionMeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        strengthPotion.setItemMeta(potionMeta1);
        RecipeChoice.ExactChoice strengthChoice = new RecipeChoice.ExactChoice(strengthPotion);

        ItemStack ZombifyWand = VillagerDiscountItem.getZombifyWand();
        ItemStack ZombifyToken = VillagerDiscountItem.getZombifyToken();
        ItemStack CureWand = VillagerDiscountItem.getCureWand();
        ItemStack CureToken = VillagerDiscountItem.getCureToken();
        ZombifyToken.setAmount(10);
        CureToken.setAmount(10);

        ShapedRecipe zWandRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("zWand"),ZombifyWand);
        zWandRecipe.shape("HXH", "ZXZ", " Y ");
        zWandRecipe.setIngredient('X', Material.EMERALD_BLOCK);
        zWandRecipe.setIngredient('Y', Material.STICK);
        zWandRecipe.setIngredient('Z', Material.ZOMBIE_SPAWN_EGG);
        zWandRecipe.setIngredient('H', Material.DIAMOND_SWORD);

        ShapedRecipe zTokenRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("zToken"), ZombifyToken);
        zTokenRecipe.shape("XY");
        zTokenRecipe.setIngredient('X', Material.DIAMOND_SWORD);
        zTokenRecipe.setIngredient('Y', strengthPotion.getData());

        ShapedRecipe cWandRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("cWand"), CureWand);
        cWandRecipe.shape(" X ", " Y ", " Z ");
        cWandRecipe.setIngredient('X', Material.VILLAGER_SPAWN_EGG);
        cWandRecipe.setIngredient('Y', Material.HEART_OF_THE_SEA);
        cWandRecipe.setIngredient('Z', Material.STICK);

        ShapedRecipe cTokenRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("cToken"), CureToken);
        cTokenRecipe.shape("XY");
        cTokenRecipe.setIngredient('X', splashWeaknessPotion.getData());
        cTokenRecipe.setIngredient('Y', Material.GOLDEN_APPLE);

        Bukkit.addRecipe(zWandRecipe);
        Bukkit.addRecipe(zTokenRecipe);
        Bukkit.addRecipe(cWandRecipe);
        Bukkit.addRecipe(cTokenRecipe);
    }
}
