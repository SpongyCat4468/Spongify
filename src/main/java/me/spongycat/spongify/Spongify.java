package me.spongycat.spongify;

import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.recipes.AutoReplantRecipe;
import me.spongycat.spongify.recipes.CompressedCropsRecipe;
import me.spongycat.spongify.recipes.SmeltingTouchRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import me.spongycat.spongify.listeners.TillMyceliumListener;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class Spongify extends JavaPlugin {

    public static me.spongycat.spongify.Spongify plugin;
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;

    @Override
    public void onEnable() {

        // Tillable Mycelium Listener
        getServer().getPluginManager().registerEvents(new TillMyceliumListener(), this);

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        // Auto Replant Enchant
        plugin = this;
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        if (getConfig().getBoolean("Allow_Hoe_Crafting")) {
            AutoReplantRecipe.registerRecipe();
        }
        registerEnchantment(autoReplantEnchantment);
        this.getServer().getPluginManager().registerEvents(autoReplantEnchantment, this);

        // Smelting Touch Enchant
        smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
        if (getConfig().getBoolean("Allow_Pickaxe_Smithing")) {
            AutoReplantRecipe.registerRecipe();
        }
        registerEnchantment(smeltingTouchEnchantment);
        this.getServer().getPluginManager().registerEvents(smeltingTouchEnchantment, this);
        this.getServer().getPluginManager().registerEvents(new SmeltingTouchRecipe(), this);
        SmeltingTouchRecipe.registerRecipe();


        // Compressed Crops
        if (getConfig().getBoolean("Allow_Compressed_Crafting")) {
            Bukkit.addRecipe(new CompressedCropsRecipe().getCarrotCompressRecipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getCarrotDecompressRecipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getPotatoCompressRecipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getPotatoDecompressRecipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getBeetrootCompressRecipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getBeetrootDecompressRecipe());

            Bukkit.addRecipe(new CompressedCropsRecipe().getCarrotCompress81Recipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getCarrotDecompress9Recipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getPotatoCompress81Recipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getPotatoDecompress9Recipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getBeetrootCompress81Recipe());
            Bukkit.addRecipe(new CompressedCropsRecipe().getBeetrootDecompress9Recipe());
        }



    }

    @Override
    public void onDisable() {
        // Auto Replant Enchant
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(autoReplantEnchantment.getKey())) {
                byKey.remove(autoReplantEnchantment.getKey());
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            if(byName.containsKey(autoReplantEnchantment.getName())) {
                byName.remove(autoReplantEnchantment.getName());
            }
        } catch (Exception ignored) { }
        // Smelting Touch Enchant
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(smeltingTouchEnchantment.getKey())) {
                byKey.remove(smeltingTouchEnchantment.getKey());
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            if(byName.containsKey(smeltingTouchEnchantment.getName())) {
                byName.remove(smeltingTouchEnchantment.getName());
            }
        } catch (Exception ignored) { }
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
        }
    }
}
