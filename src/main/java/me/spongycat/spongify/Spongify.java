package me.spongycat.spongify;

import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.util.Setup;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class Spongify extends JavaPlugin {

    public static me.spongycat.spongify.Spongify plugin;
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;

    public static final String version = "1.2.2";

    @Override
    public void onEnable() {
        plugin = this;
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
        Setup.enable();
    }

    @Override
    public void onDisable() {
        Setup.disable();
    }
}
