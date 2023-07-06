package me.spongycat.spongify.util;

import me.spongycat.spongify.lists.DebugModePlayerList;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class PlayerUtil {
    public static void sendDebugMessage(Player player, String message) {
        if (DebugModePlayerList.containsPlayer(player)) {
            player.sendMessage(ChatColor.DARK_GREEN + "[Debug] " + message);
        }
    }
    public static void sendDebugMessage(HumanEntity entity, String message) {
        if (entity instanceof Player p)
            if (DebugModePlayerList.containsPlayer(p)) {
                entity.sendMessage(ChatColor.DARK_GREEN + "[Debug] " + message);
            }
    }
}
