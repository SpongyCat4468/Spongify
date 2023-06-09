package me.spongycat.spongify;

import me.spongycat.spongify.commands.SpongifyCommand;
import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.items.GodSwordItem;
import me.spongycat.spongify.listeners.*;
import me.spongycat.spongify.recipes.*;
import me.spongycat.spongify.util.Setup;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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

        Setup.setup();
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
