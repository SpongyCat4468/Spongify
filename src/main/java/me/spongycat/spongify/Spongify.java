package me.spongycat.spongify;

import me.spongycat.spongify.enchants.AutoReplantEnchantment;
import me.spongycat.spongify.enchants.SmeltingTouchEnchantment;
import me.spongycat.spongify.util.SetupUtil;
import org.bukkit.plugin.java.JavaPlugin;


public final class Spongify extends JavaPlugin {

    public static me.spongycat.spongify.Spongify plugin;
    public static me.spongycat.spongify.enchants.AutoReplantEnchantment autoReplantEnchantment;
    public static me.spongycat.spongify.enchants.SmeltingTouchEnchantment smeltingTouchEnchantment;

    public static final String version = "1.2.5";

    @Override
    public void onEnable() {
        plugin = this;
        autoReplantEnchantment = new AutoReplantEnchantment("auto_replant");
        smeltingTouchEnchantment = new SmeltingTouchEnchantment("smelting_touch");
        SetupUtil.enable();
    }

    @Override
    public void onDisable() {
        SetupUtil.disable();
    }
}
