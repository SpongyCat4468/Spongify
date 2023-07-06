package me.spongycat.spongify.recipes;

import me.spongycat.spongify.items.Item;
import me.spongycat.spongify.util.NameSpaceKeyCreatorUtil;
import org.bukkit.Bukkit;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class GodSwordRecipe {
    public static void registerRecipe() {

        RecipeChoice.ExactChoice SaradominChoice = new RecipeChoice.ExactChoice(Item.SARADOMIN_HILT);
        RecipeChoice.ExactChoice GuthixChoice = new RecipeChoice.ExactChoice(Item.GUTHIX_HILT);
        RecipeChoice.ExactChoice ArmadylChoice = new RecipeChoice.ExactChoice(Item.ARMADYL_HILT);
        RecipeChoice.ExactChoice ZamorackChoice = new RecipeChoice.ExactChoice(Item.ZAMORAK_HILT);
        RecipeChoice.ExactChoice BladeChoice = new RecipeChoice.ExactChoice(Item.GOD_SWORD_BLADE);

        ShapedRecipe SaradominRecipe = new ShapedRecipe(NameSpaceKeyCreatorUtil.getNameSpacedKey("Saradomin"), Item.SARADOMIN_GOD_SWORD);
        SaradominRecipe.shape(" X ", " X ", " Y ");
        SaradominRecipe.setIngredient('X', BladeChoice);
        SaradominRecipe.setIngredient('Y', SaradominChoice);

        ShapedRecipe GuthixRecipe = new ShapedRecipe(NameSpaceKeyCreatorUtil.getNameSpacedKey("Guthix"), Item.GUTHIX_GOD_SWORD);
        GuthixRecipe.shape(" X ", " X ", " Y ");
        GuthixRecipe.setIngredient('X', BladeChoice);
        GuthixRecipe.setIngredient('Y', GuthixChoice);

        ShapedRecipe ArmadylRecipe = new ShapedRecipe(NameSpaceKeyCreatorUtil.getNameSpacedKey("Armadyl"), Item.ARMADYL_GOD_SWORD);
        ArmadylRecipe.shape(" X ", " X ", " Y ");
        ArmadylRecipe.setIngredient('X', BladeChoice);
        ArmadylRecipe.setIngredient('Y', ArmadylChoice);

        ShapedRecipe ZamorakRecipe = new ShapedRecipe(NameSpaceKeyCreatorUtil.getNameSpacedKey("Zamorak"), Item.ZAMORAK_GOD_SWORD);
        ZamorakRecipe.shape(" X ", " X ", " Y ");
        ZamorakRecipe.setIngredient('X', BladeChoice);
        ZamorakRecipe.setIngredient('Y', ZamorackChoice);


        Bukkit.addRecipe(SaradominRecipe);
        Bukkit.addRecipe(GuthixRecipe);
        Bukkit.addRecipe(ArmadylRecipe);
        Bukkit.addRecipe(ZamorakRecipe);
    }
}
