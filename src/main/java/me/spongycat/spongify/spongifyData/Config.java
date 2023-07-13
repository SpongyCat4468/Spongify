package me.spongycat.spongify.spongifyData;


import static me.spongycat.spongify.Spongify.plugin;

public class Config {
    public static boolean CAN_TILL_MYCELIUM = findBoolean("Tillable_Mycelium.Enable");
    public static boolean CAN_CRAFT_AUTO_REPLANT = findBoolean("Auto_Replant_Enchant.Enable");
    public static boolean CAN_CRAFT_COMPRESSED_CROPS = findBoolean("Compressed_Crops_Crafting");
    public static boolean CAN_CRAFT_SMELTING_TOUCH = findBoolean("Smelting_Touch.Crafting");
    public static boolean CAN_ADD_SMELTING_TOUCH = findBoolean("Smelting_Touch.Allow_Adding_Enchant");
    public static boolean CAN_SMELTING_TOUCH = findBoolean("Smelting_Touch.Enable_Enchant");
    public static boolean IS_ARMOR_STAND_WITH_ARM = findBoolean("Armor_Stand_With_Arms");
    public static boolean CAN_CRAFT_BUNDLE = findBoolean("Allow_Bundle_Crafting");

    public static int DIAMOND_ARROWHEAD_CHANCE = findInt("Custom_Arrowhead.Diamond_Ore");
    public static int NETHERITE_ARROWHEAD_CHANCE = findInt("Custom_Arrowhead.Ancient_Debris");

    public static boolean findBoolean(String path) {
        return plugin.getConfig().getBoolean(path);
    }

    public static int findInt(String path) {
        return plugin.getConfig().getInt(path);
    }
}
