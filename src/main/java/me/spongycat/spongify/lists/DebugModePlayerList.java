package me.spongycat.spongify.lists;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DebugModePlayerList {
    public static Set<UUID> DebugModePlayers = new HashSet<>();

    public static void addPlayer(Player player) {
        DebugModePlayers.add(player.getUniqueId());
        player.sendMessage(ChatColor.GREEN + "You will receive debug message from now on!");
    }

    public static void removePlayer(Player player) {
        DebugModePlayers.remove(player.getUniqueId());
        player.sendMessage(ChatColor.RED + "You will no longer receive debug message!");
    }

    public static boolean containsPlayer(Player player) {
        return DebugModePlayers.contains(player.getUniqueId());
    }

    public static Set<UUID> getDebugList() {
        return DebugModePlayers;
    }
}
