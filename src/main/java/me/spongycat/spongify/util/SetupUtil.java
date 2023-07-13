package me.spongycat.spongify.util;

import me.spongycat.spongify.commands.SpongifyCommand.SpongifyCommand;
import me.spongycat.spongify.commands.SpongifyCommand.SpongifyTabComplete;
import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.listeners.*;
import me.spongycat.spongify.listeners.FletchingGUI.ClickEvent;
import me.spongycat.spongify.listeners.FletchingGUI.CloseEvent;
import me.spongycat.spongify.listeners.FletchingGUI.DragEvent;
import me.spongycat.spongify.listeners.FletchingGUI.InteractEvent;
import me.spongycat.spongify.recipes.*;
import me.spongycat.spongify.spongifyData.Config;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;

import static me.spongycat.spongify.Spongify.plugin;
import static org.bukkit.Bukkit.getServer;

public class SetupUtil {
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;
    public static void enable() {
        // Tillable Mycelium
        plugin.getServer().getPluginManager().registerEvents(new TillMyceliumListener(), plugin);
        plugin.getServer().getLogger().log(Level.INFO, "[Spongify] Tillable Mycelium Enabled");

        // Armor Stand With Arms
        if (Config.IS_ARMOR_STAND_WITH_ARM) {
            plugin.getServer().getPluginManager().registerEvents(new ArmorStandPlaceListener(), plugin);
            plugin.getServer().getLogger().log(Level.INFO, "[Spongify] Armor Stand with Arms Enabled");
        }

        // Config
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        getServer().getLogger().log(Level.INFO, "[Spongify] Config Saved");

        // Auto Replant Enchant
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        if (Config.CAN_CRAFT_AUTO_REPLANT) {
            AutoReplantRecipe.registerRecipe();
        }
        registerEnchantment(autoReplantEnchantment);
        plugin.getServer().getPluginManager().registerEvents(autoReplantEnchantment, plugin);
        getServer().getLogger().log(Level.INFO, "[Spongify] Auto Replant Enchant Registered");

        // Smelting Touch Enchant
        if (Config.CAN_SMELTING_TOUCH) {
            smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
            registerEnchantment(smeltingTouchEnchantment);
            plugin.getServer().getPluginManager().registerEvents(smeltingTouchEnchantment, plugin);
            plugin.getServer().getPluginManager().registerEvents(new SmeltingTouchRecipe(), plugin);
        }
        SmeltingTouchRecipe.registerRecipe();
        getServer().getLogger().log(Level.INFO, "[Spongify] Smelting Touch Enchant Registered");

        // Bundles
        if (Config.CAN_CRAFT_BUNDLE) {
            BundleRecipe.registerRecipe();
            getServer().getLogger().log(Level.INFO, "[Spongify] Bundle Recipe Registered");
        }

        // Rotten Flesh To Leather
        RottenFleshToLeatherRecipe.registerRecipe();
        getServer().getLogger().log(Level.INFO, "[Spongify] Leather Recipe Registered");


        // Compressed Crops
        if (Config.CAN_CRAFT_COMPRESSED_CROPS) {
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
        // Spongify Command
        plugin.getCommand("spongify").setExecutor(new SpongifyCommand());
        getServer().getLogger().log(Level.INFO, "[Spongify] Spongify Command Registered");


        // Auto Tab Complete
        plugin.getCommand("spongify").setTabCompleter(new SpongifyTabComplete());

        // Prevent Zamorack Hilt (redstone) from being placing down
        plugin.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), plugin);

        // God Sword Recipe
        GodSwordRecipe.registerRecipe();
        getServer().getLogger().log(Level.INFO, "[Spongify] God Sword Recipes & Items Registered");

        // Fletching Table GUI
        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CloseEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DragEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InteractEvent(), plugin);

        // Custom Arrow
        plugin.getServer().getPluginManager().registerEvents(new CustomArrowListener(), plugin);
        getServer().getLogger().log(Level.INFO, "[Spongify] Custom Arrows Registered");

        // Custom Staff
        plugin.getServer().getPluginManager().registerEvents(new CustomStaffListener(), plugin);
        getServer().getLogger().log(Level.INFO, "[Spongify] Custom Staff Registered");

        // Lava Survival
        plugin.getServer().getPluginManager().registerEvents(new LavaSurvivalListener(), plugin);
    }
    public static void disable() {
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
