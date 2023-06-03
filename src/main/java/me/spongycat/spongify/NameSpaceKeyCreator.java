package me.spongycat.spongify;

import org.bukkit.NamespacedKey;

public class NameSpaceKeyCreator {
    public static NamespacedKey recipeKey(String key) {
        return new NamespacedKey(Spongify.plugin, key);
    }
}
