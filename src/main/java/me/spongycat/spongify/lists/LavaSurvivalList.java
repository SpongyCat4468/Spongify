package me.spongycat.spongify.lists;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LavaSurvivalList {
    public static Set<UUID> LavaSurvivalPlayers = new HashSet<>();

    public static void addPlayer(Player p, Player sender) {
        LavaSurvivalPlayers.add(p.getUniqueId());
        sender.sendMessage(ChatColor.GREEN + p.getDisplayName() + " has been added to the queue of lava survival!");
    }

    public static void removePlayer(Player p, Player sender) {
        LavaSurvivalPlayers.remove(p.getUniqueId());
        sender.sendMessage(ChatColor.RED + p.getDisplayName() + " has been remove from the queue of lava survival!");
    }

    public static boolean containsPlayer(Player p) {
        return LavaSurvivalPlayers.contains(p.getUniqueId());
    }

    public static Set<UUID> getLavaSurvivalList() {
        return LavaSurvivalPlayers;
    }

    public static String getPlayerList() {
        StringBuilder builder = new StringBuilder();
        for (UUID uuid : LavaSurvivalPlayers) {
            Player player = Bukkit.getPlayerExact(uuid.toString());
            if (player != null) {
                builder.append(player.getName()).append(", ");
            }
        }
        String playerNames = builder.toString();
        if (!playerNames.isEmpty()) {
            playerNames = playerNames.substring(0, playerNames.length() - 2);
        }
        return playerNames;
    }
}
