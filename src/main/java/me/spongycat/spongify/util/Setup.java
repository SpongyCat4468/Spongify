package me.spongycat.spongify.util;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.commands.SpongifyCommand;
import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.listeners.*;
import me.spongycat.spongify.recipes.*;
import org.bukkit.Bukkit;

import java.util.logging.Level;

import static me.spongycat.spongify.Spongify.plugin;
import static org.bukkit.Bukkit.getServer;

public class Setup {
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;
    public static void setup() {
        // Tillable Mycelium
        plugin.getServer().getPluginManager().registerEvents(new TillMyceliumListener(), plugin);
        plugin.getServer().getLogger().log(Level.INFO, "[Spongify] Tillable Mycelium Enabled");

        // Armor Stand With Arms
        if (plugin.getConfig().getBoolean("Enabled")) {
            plugin.getServer().getPluginManager().registerEvents(new ArmorStandPlaceListener(), plugin);
            plugin.getServer().getLogger().log(Level.INFO, "[Spongify] Armor Stand with Arms Enabled");
        }

        // Config
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        getServer().getLogger().log(Level.INFO, "[Spongify] Config Saved");

        // Auto Replant Enchant
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        if (plugin.getConfig().getBoolean("Allow_Hoe_Crafting")) {
            AutoReplantRecipe.registerRecipe();
        }
        Spongify.registerEnchantment(autoReplantEnchantment);
        plugin.getServer().getPluginManager().registerEvents(autoReplantEnchantment, plugin);
        getServer().getLogger().log(Level.INFO, "[Spongify] Auto Replant Enchant Registered");

        // Smelting Touch Enchant
        smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
        Spongify.registerEnchantment(smeltingTouchEnchantment);
        plugin.getServer().getPluginManager().registerEvents(smeltingTouchEnchantment, plugin);
        plugin.getServer().getPluginManager().registerEvents(new SmeltingTouchRecipe(), plugin);
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
        if (plugin.getConfig().getBoolean("Allow_Compressed_Crafting")) {
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
            plugin.getCommand("spongify").setExecutor(new SpongifyCommand());
            getServer().getLogger().log(Level.INFO, "[Spongify] Lore Command Registered");
        }

        // Auto Tab Complete
        plugin.getCommand("spongify").setTabCompleter(new TabCompleteListener());

        // Prevent Zamorack Hilt (redstone) from being placing down
        plugin.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), plugin);

        // God Sword Recipe
        GodSwordRecipe.registerRecipe();
    }
}
