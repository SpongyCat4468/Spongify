package me.spongycat.spongify.util;

import me.spongycat.spongify.Spongify;
import org.bukkit.NamespacedKey;

public class NameSpaceKeyCreator {
    public static NamespacedKey getRecipeKey(String key) {
        return new NamespacedKey(Spongify.plugin, key);
    }
}
