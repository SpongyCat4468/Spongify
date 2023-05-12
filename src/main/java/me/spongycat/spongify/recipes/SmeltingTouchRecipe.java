package me.spongycat.spongify.recipes;

import com.sun.tools.javac.jvm.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.spongycat.spongify.Spongify.plugin;
import static me.spongycat.spongify.Spongify.smeltingTouchEnchantment;

public class SmeltingTouchRecipe implements Listener {

    public static void registerRecipe() {
        ItemStack ore = new ItemStack(Material.DEEPSLATE_EMERALD_ORE, 1);
        ore.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
        ItemMeta meta2 = ore.getItemMeta();
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.GOLD + "Ancient material combined with multiple ore power... ");
        meta2.setLore(lore2);
        meta2.setDisplayName(ChatColor.LIGHT_PURPLE + "Ancient Emerald Ore");
        ore.setItemMeta(meta2);

        ShapedRecipe oreRecipe = new ShapedRecipe(new NamespacedKey(plugin, "ore"), ore);
        oreRecipe.shape("XAX", "KBC", "XJX");
        oreRecipe.setIngredient('X', Material.FURNACE);
        oreRecipe.setIngredient('A', Material.DIAMOND_ORE);
        oreRecipe.setIngredient('K', Material.DEEPSLATE_COAL_ORE);
        oreRecipe.setIngredient('B', Material.DEEPSLATE_EMERALD_ORE);
        oreRecipe.setIngredient('C', Material.DEEPSLATE_COPPER_ORE);
        oreRecipe.setIngredient('J', Material.ANCIENT_DEBRIS);

        Bukkit.addRecipe(oreRecipe);
    }

    @EventHandler
    public void onPrepareSmithing(PrepareSmithingEvent event) {
        NamespacedKey key = new NamespacedKey(plugin, "custom_smithing_recipe");
        Bukkit.removeRecipe(key);
        ItemStack[] items = event.getInventory().getContents();

        ItemStack ore = new ItemStack(Material.DEEPSLATE_EMERALD_ORE, 1);
        ore.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
        ItemMeta meta2 = ore.getItemMeta();
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.GOLD + "Ancient material combined with multiple ore power... ");
        meta2.setLore(lore2);
        meta2.setDisplayName(ChatColor.LIGHT_PURPLE + "Ancient Emerald Ore");
        ore.setItemMeta(meta2);


        if (items[0] != null && items[1] != null) {
            if (items[0].getType() == Material.NETHERITE_PICKAXE && items[1].isSimilar(ore) && items[1].getAmount() == 1) {
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
