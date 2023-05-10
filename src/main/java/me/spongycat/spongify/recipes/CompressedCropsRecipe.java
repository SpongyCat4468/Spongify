package me.spongycat.spongify.recipes;

import me.spongycat.spongify.Spongify;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CompressedCropsRecipe {

    public static ShapedRecipe registerShapedRecipeChoice(String recipeName, ItemStack result, RecipeChoice.ExactChoice exactChoice) {

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Spongify.plugin, recipeName), result);
        recipe.shape("AAA", "AAA", "AAA");
        recipe.setIngredient('A', exactChoice);

        return recipe;

    }

    public static ShapedRecipe registerShapelessRecipe(String recipeName, ItemStack result, RecipeChoice.ExactChoice exactChoice) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Spongify.plugin, recipeName), result);
        recipe.shape("   ", " x ", "   ");
        recipe.setIngredient('x', exactChoice);
        return recipe;
    }
    public static ItemStack registerEnchantedItem(Material material, int amount, Enchantment enchantment, int level, ChatColor chatColor, String name) {
        ItemStack item = new ItemStack(material, amount);
        item.addUnsafeEnchantment(enchantment, level);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chatColor + name);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack registerItem(Material material, int amount) {
        ItemStack item = new ItemStack(material, amount);
        return item;
    }


    // registering items
    // carrot
    ItemStack compressed9carrot = registerEnchantedItem(Material.CARROT, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Carrot (x9)");
    ItemStack carrot = registerItem(Material.CARROT, 9);
    ItemStack c9carrot = registerEnchantedItem(Material.CARROT, 9, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Carrot (x9)");
    ItemStack compressed81carrot = registerEnchantedItem(Material.CARROT, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Carrot (x81)");
    // potato
    ItemStack compressed9potato = registerEnchantedItem(Material.POTATO, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Potato (x9)");
    ItemStack potato = registerItem(Material.POTATO, 9);
    ItemStack c9potato = registerEnchantedItem(Material.POTATO, 9, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Potato (x9)");
    ItemStack compressed81potato = registerEnchantedItem(Material.POTATO, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Potato (x81)");

    // beetroot
    ItemStack compressed9beetroot = registerEnchantedItem(Material.BEETROOT, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Beetroot (x9)");
    ItemStack beetroot = registerItem(Material.BEETROOT, 9);
    ItemStack c9beetroot = registerEnchantedItem(Material.BEETROOT, 9, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Beetroot (x9)");
    ItemStack compressed81beetroot = registerEnchantedItem(Material.BEETROOT, 1, Enchantment.ARROW_INFINITE, 10, ChatColor.GOLD, "Compressed Beetroot (x81)");



    // exact choice
    RecipeChoice.ExactChoice carrotChoice = new RecipeChoice.ExactChoice(compressed9carrot);
    RecipeChoice.ExactChoice potatoChoice = new RecipeChoice.ExactChoice(compressed9potato);
    RecipeChoice.ExactChoice beetrootChoice = new RecipeChoice.ExactChoice(compressed9beetroot);
    RecipeChoice.ExactChoice carrotChoice2 = new RecipeChoice.ExactChoice(compressed81carrot);
    RecipeChoice.ExactChoice potatoChoice2 = new RecipeChoice.ExactChoice(compressed81potato);
    RecipeChoice.ExactChoice beetrootChoice2 = new RecipeChoice.ExactChoice(compressed81beetroot);
    RecipeChoice.ExactChoice carrotc = new RecipeChoice.ExactChoice(new ItemStack(Material.CARROT));
    RecipeChoice.ExactChoice potatoc = new RecipeChoice.ExactChoice(new ItemStack(Material.POTATO));
    RecipeChoice.ExactChoice beetrootc = new RecipeChoice.ExactChoice(new ItemStack(Material.BEETROOT));

    // registering recipes
    // carrot
    ShapedRecipe carrotCompressRecipe = registerShapedRecipeChoice("9_carrot", compressed9carrot, carrotc);
    ShapedRecipe carrotDecompressRecipe = registerShapelessRecipe("9_carrot_de", carrot, carrotChoice);
    ShapedRecipe carrotCompress81Recipe = registerShapedRecipeChoice("81_carrot", compressed81carrot, carrotChoice);
    ShapedRecipe carrotDecompress9Recipe = registerShapelessRecipe("81_carrot_de", c9carrot, carrotChoice2);
    // potato
    ShapedRecipe potatoCompressRecipe = registerShapedRecipeChoice("9_potato", compressed9potato, potatoc);
    ShapedRecipe potatoDecompressRecipe = registerShapelessRecipe("9_potato_de", potato, potatoChoice);
    ShapedRecipe potatoCompress81Recipe = registerShapedRecipeChoice("81_potato", compressed81potato, potatoChoice);
    ShapedRecipe potatoDecompress9Recipe = registerShapelessRecipe("81_potato_de", c9potato, potatoChoice2);
    // beetroot
    ShapedRecipe beetrootCompressRecipe = registerShapedRecipeChoice("9_beetroot", compressed9beetroot, beetrootc);
    ShapedRecipe beetrootDecompressRecipe = registerShapelessRecipe("9_beetroot_de", beetroot, beetrootChoice);
    ShapedRecipe beetrootCompress81Recipe = registerShapedRecipeChoice("81_beetroot", compressed81beetroot, beetrootChoice);
    ShapedRecipe beetrootDecompress9Recipe = registerShapelessRecipe("81_beetroot_de", c9beetroot, beetrootChoice2);

    // getter
    public ShapedRecipe getCarrotCompressRecipe() {
        return carrotCompressRecipe;
    }

    public ShapedRecipe getCarrotDecompressRecipe() {
        return carrotDecompressRecipe;
    }

    public ShapedRecipe getPotatoCompressRecipe() {
        return potatoCompressRecipe;
    }

    public ShapedRecipe getPotatoDecompressRecipe() {
        return potatoDecompressRecipe;
    }

    public ShapedRecipe getBeetrootCompressRecipe() {
        return beetrootCompressRecipe;
    }

    public ShapedRecipe getBeetrootDecompressRecipe() {
        return beetrootDecompressRecipe;
    }
    public ShapedRecipe getCarrotCompress81Recipe() {
        return carrotCompress81Recipe;
    }

    public ShapedRecipe getCarrotDecompress9Recipe() {
        return carrotDecompress9Recipe;
    }

    public ShapedRecipe getPotatoCompress81Recipe() {
        return potatoCompress81Recipe;
    }

    public ShapedRecipe getPotatoDecompress9Recipe() {
        return potatoDecompress9Recipe;
    }

    public ShapedRecipe getBeetrootCompress81Recipe() {
        return beetrootCompress81Recipe;
    }

    public ShapedRecipe getBeetrootDecompress9Recipe() {
        return beetrootDecompress9Recipe;
    }
}
