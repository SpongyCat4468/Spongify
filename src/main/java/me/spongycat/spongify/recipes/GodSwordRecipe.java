package me.spongycat.spongify.recipes;

import me.spongycat.spongify.items.GodSwordItem;
import me.spongycat.spongify.util.NameSpaceKeyCreator;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class GodSwordRecipe {
    public static void registerRecipe() {
        ItemStack SaradominHilt = GodSwordItem.getSaradominHilt();
        ItemStack GuthixHilt = GodSwordItem.getGuthixHilt();
        ItemStack ArmadylHilt = GodSwordItem.getArmadylHilt();
        ItemStack ZamorackHilt = GodSwordItem.getZamorackHilt();
        ItemStack GodSwordBlade = GodSwordItem.getGodSwordBlade();
        ItemStack SaradominGodSword = GodSwordItem.getSaradominGodSword();
        ItemStack GuthixGodSword = GodSwordItem.getGuthixGodSword();
        ItemStack ArmadylGodSword = GodSwordItem.getArmadylGodSword();
        ItemStack ZamorackGodSword = GodSwordItem.getZamorackGodSword();

        RecipeChoice.ExactChoice SaradominChoice = new RecipeChoice.ExactChoice(SaradominHilt);
        RecipeChoice.ExactChoice GuthixChoice = new RecipeChoice.ExactChoice(GuthixHilt);
        RecipeChoice.ExactChoice ArmadylChoice = new RecipeChoice.ExactChoice(ArmadylHilt);
        RecipeChoice.ExactChoice ZamorackChoice = new RecipeChoice.ExactChoice(ZamorackHilt);
        RecipeChoice.ExactChoice BladeChoice = new RecipeChoice.ExactChoice(GodSwordBlade);

        ShapedRecipe SaradominRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("Saradomin"), SaradominGodSword);
        SaradominRecipe.shape(" X ", " X ", " Y ");
        SaradominRecipe.setIngredient('X', BladeChoice);
        SaradominRecipe.setIngredient('Y', SaradominChoice);

        ShapedRecipe GuthixRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("Guthix"), GuthixGodSword);
        GuthixRecipe.shape(" X ", " X ", " Y ");
        GuthixRecipe.setIngredient('X', BladeChoice);
        GuthixRecipe.setIngredient('Y', GuthixChoice);

        ShapedRecipe ArmadylRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("Armadyl"), ArmadylGodSword);
        ArmadylRecipe.shape(" X ", " X ", " Y ");
        ArmadylRecipe.setIngredient('X', BladeChoice);
        ArmadylRecipe.setIngredient('Y', ArmadylChoice);

        ShapedRecipe ZamorakRecipe = new ShapedRecipe(NameSpaceKeyCreator.recipeKey("Zamorack"), ZamorackGodSword);
        ZamorakRecipe.shape(" X ", " X ", " Y ");
        ZamorakRecipe.setIngredient('X', BladeChoice);
        ZamorakRecipe.setIngredient('Y', ZamorackChoice);


        Bukkit.addRecipe(SaradominRecipe);
        Bukkit.addRecipe(GuthixRecipe);
        Bukkit.addRecipe(ArmadylRecipe);
        Bukkit.addRecipe(ZamorakRecipe);
    }
}
