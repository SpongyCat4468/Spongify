package me.spongycat.spongify.recipes;

import me.spongycat.spongify.spongifyData.Config;
import me.spongycat.spongify.spongifyData.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.spongycat.spongify.Spongify.plugin;
import static me.spongycat.spongify.Spongify.smeltingTouchEnchantment;

public class SmeltingTouchRecipe implements Listener {

    public static void registerRecipe() {

        ShapedRecipe diamondRecipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond"), Item.DIAMOND_CORE);
        diamondRecipe.shape("XXX", "XAX", "XXX");
        diamondRecipe.setIngredient('X', Material.DIAMOND_BLOCK);
        diamondRecipe.setIngredient('A', Material.TOTEM_OF_UNDYING);

        RecipeChoice.ExactChoice diamondChoice = new RecipeChoice.ExactChoice(Item.DIAMOND_CORE);

        ShapedRecipe oreRecipe = new ShapedRecipe(new NamespacedKey(plugin, "ore"), Item.SMELTING_TOUCH_BOOK);
        oreRecipe.shape("XAX", "ABA", "XAX");
        oreRecipe.setIngredient('X', Material.BLAST_FURNACE);
        oreRecipe.setIngredient('A', diamondChoice);
        oreRecipe.setIngredient('B', Material.BOOK);

        if (Config.CAN_CRAFT_SMELTING_TOUCH) {
            Bukkit.addRecipe(oreRecipe);
            Bukkit.addRecipe(diamondRecipe);
        }

    }

    @EventHandler
    public void onPrepareSmithing(PrepareSmithingEvent event) {
        NamespacedKey key = new NamespacedKey(plugin, "custom_smithing_recipe");
        Bukkit.removeRecipe(key);
        ItemStack[] items = event.getInventory().getContents();

        if (Config.CAN_ADD_SMELTING_TOUCH) {
            if (items[0] != null && items[1] != null) {
                if (items[0].getType() == Material.NETHERITE_PICKAXE && items[1].isSimilar(Item.SMELTING_TOUCH_BOOK) && items[1].getAmount() == 1) {
                    ItemStack result = items[0];
                    ItemMeta meta3 = items[0].getItemMeta();
                    ArrayList<String> lore3 = new ArrayList<>();
                    lore3.add(ChatColor.GOLD + "Smelting Touch I");
                    meta3.setLore(lore3);
                    result.setItemMeta(meta3);
                    result.addUnsafeEnchantment(smeltingTouchEnchantment, 1);

                    // Set the durability of the resulting item to match the durability of the input pickaxe
                    int durability = (int) ((double) items[0].getDurability() / items[0].getType().getMaxDurability() * result.getType().getMaxDurability());
                    result.setDurability((short) durability);
                    ItemStack first = items[0];
                    ItemStack second = items[1];
                    RecipeChoice firstChoice = new RecipeChoice.ExactChoice(first);
                    RecipeChoice secondChoice = new RecipeChoice.ExactChoice(second);
                    if (!first.containsEnchantment(smeltingTouchEnchantment)) {
                        int count = items[1].getAmount();
                        items[1].setAmount(count - 1);
                    }

                    // Create the custom recipe using the result item and a unique key
                    SmithingRecipe recipe = new SmithingRecipe(key, result, firstChoice, secondChoice);

                    // Register the recipe with the server
                    Bukkit.getServer().addRecipe(recipe);

                } else if (items[0].getType() == Material.NETHERITE_SHOVEL && items[1].isSimilar(Item.SMELTING_TOUCH_BOOK) && items[1].getAmount() == 1) {
                    ItemStack result = items[0];
                    ItemMeta meta3 = items[0].getItemMeta();
                    ArrayList<String> lore3 = new ArrayList<>();
                    lore3.add(ChatColor.GOLD + "Smelting Touch I");
                    meta3.setLore(lore3);
                    result.setItemMeta(meta3);
                    result.addUnsafeEnchantment(smeltingTouchEnchantment, 1);

                    // Set the durability of the resulting item to match the durability of the input pickaxe
                    int durability = (int) ((double) items[0].getDurability() / items[0].getType().getMaxDurability() * result.getType().getMaxDurability());
                    result.setDurability((short) durability);
                    ItemStack first = items[0];
                    ItemStack second = items[1];
                    RecipeChoice firstChoice = new RecipeChoice.ExactChoice(first);
                    RecipeChoice secondChoice = new RecipeChoice.ExactChoice(second);
                    if (!first.containsEnchantment(smeltingTouchEnchantment)) {
                        int count = items[1].getAmount();
                        items[1].setAmount(count - 1);
                    }

                    // Create the custom recipe using the result item and a unique key
                    SmithingRecipe recipe = new SmithingRecipe(key, result, firstChoice, secondChoice);

                    // Register the recipe with the server
                    Bukkit.getServer().addRecipe(recipe);

                } else if (items[0].getType() == Material.NETHERITE_HOE && items[1].isSimilar(Item.SMELTING_TOUCH_BOOK) && items[1].getAmount() == 1) {
                    ItemStack result = items[0];
                    ItemMeta meta3 = items[0].getItemMeta();
                    ArrayList<String> lore3 = new ArrayList<>();
                    lore3.add(ChatColor.GOLD + "Smelting Touch I");
                    meta3.setLore(lore3);
                    result.setItemMeta(meta3);
                    result.addUnsafeEnchantment(smeltingTouchEnchantment, 1);

                    // Set the durability of the resulting item to match the durability of the input pickaxe
                    int durability = (int) ((double) items[0].getDurability() / items[0].getType().getMaxDurability() * result.getType().getMaxDurability());
                    result.setDurability((short) durability);
                    ItemStack first = items[0];
                    ItemStack second = items[1];
                    RecipeChoice firstChoice = new RecipeChoice.ExactChoice(first);
                    RecipeChoice secondChoice = new RecipeChoice.ExactChoice(second);
                    if (!first.containsEnchantment(smeltingTouchEnchantment)) {
                        int count = items[1].getAmount();
                        items[1].setAmount(count - 1);
                    }

                    // Create the custom recipe using the result item and a unique key
                    SmithingRecipe recipe = new SmithingRecipe(key, result, firstChoice, secondChoice);

                    // Register the recipe with the server
                    Bukkit.getServer().addRecipe(recipe);

                }
            }
        }
    }

    public static ItemStack getDiamondCore() {
        ItemStack superDiamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
        superDiamond.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
        ItemMeta meta3 = superDiamond.getItemMeta();
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add(ChatColor.GOLD + "Diamond core combined with totem power");
        meta3.setLore(lore3);
        meta3.setDisplayName(ChatColor.LIGHT_PURPLE + "Diamond Core");
        superDiamond.setItemMeta(meta3);

        return superDiamond;
    }

    public static ItemStack getSmeltingTouchBook() {
        ItemStack ore = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta meta2 = ore.getItemMeta();
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.GOLD + "Smelting Touch I");
        meta2.setLore(lore2);
        ore.setItemMeta(meta2);

        return ore;
    }
}
