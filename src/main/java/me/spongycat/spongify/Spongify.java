package me.spongycat.spongify;

import me.spongycat.spongify.commands.SpongifyCommand;
import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.items.GodSwordItem;
import me.spongycat.spongify.listeners.ArmorStandPlaceListener;
import me.spongycat.spongify.listeners.BlockPlaceListener;
import me.spongycat.spongify.listeners.TabCompleteListener;
import me.spongycat.spongify.recipes.*;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.spongycat.spongify.listeners.TillMyceliumListener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;

public final class Spongify extends JavaPlugin {

    public static me.spongycat.spongify.Spongify plugin;
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;
    public static final String version = "1.2.0";

    @Override
    public void onEnable() {
        plugin = this;

        // Tillable Mycelium
        getServer().getPluginManager().registerEvents(new TillMyceliumListener(), this);
        getServer().getLogger().log(Level.INFO, "[Spongify] Tillable Mycelium Enabled");

        // Armor Stand With Arms
        if (plugin.getConfig().getBoolean("Enabled")) {
            getServer().getPluginManager().registerEvents(new ArmorStandPlaceListener(), this);
            getServer().getLogger().log(Level.INFO, "[Spongify] Armor Stand with Arms Enabled");
        }

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getLogger().log(Level.INFO, "[Spongify] Config Saved");

        // Auto Replant Enchant
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        if (getConfig().getBoolean("Allow_Hoe_Crafting")) {
            AutoReplantRecipe.registerRecipe();
        }
        registerEnchantment(autoReplantEnchantment);
        this.getServer().getPluginManager().registerEvents(autoReplantEnchantment, this);
        getServer().getLogger().log(Level.INFO, "[Spongify] Auto Replant Enchant Registered");

        // Smelting Touch Enchant
        smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
        registerEnchantment(smeltingTouchEnchantment);
        this.getServer().getPluginManager().registerEvents(smeltingTouchEnchantment, this);
        this.getServer().getPluginManager().registerEvents(new SmeltingTouchRecipe(), this);
        SmeltingTouchRecipe.registerRecipe();
        getServer().getLogger().log(Level.INFO, "[Spongify] Smelting Touch Enchant Registered");

        // Bundles
        if (plugin.getConfig().getBoolean("Recipe_Enabled")) {
            BundleRecipe.registerRecipe();
            getServer().getLogger().log(Level.INFO, "[Spongify] Bundle Recipe Registered");
        }

        // Rotten Flesh To Leather
        RottenFleshToLeatherRecipe.registerRecipe();
        getServer().getLogger().log(Level.INFO, "[Spongify] Leather Recipe Registered");


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
            getServer().getLogger().log(Level.INFO, "[Spongify] Compressed Crops Recipe Registered");
        }
        // Lore
        if (plugin.getConfig().getBoolean("Command_Enabled")) {
            getCommand("spongify").setExecutor(new SpongifyCommand());
            getServer().getLogger().log(Level.INFO, "[Spongify] Lore Command Registered");
        }

        // Auto Tab Complete
        getCommand("spongify").setTabCompleter(new TabCompleteListener());

        // Prevent Zamorack Hilt (redstone) from being placing down
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);

        // God Sword Recipe
        GodSwordRecipe.registerRecipe();
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
