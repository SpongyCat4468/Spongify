package me.spongycat.spongify.util;

import me.spongycat.spongify.Spongify;
import org.bukkit.NamespacedKey;

public class NameSpaceKeyCreatorUtil {
    public static NamespacedKey getNameSpacedKey(String key) {
        return new NamespacedKey(Spongify.plugin, key);
    }
}
