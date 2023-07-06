package me.spongycat.spongify.listeners;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.actions.ClickType;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.event.HologramClickEvent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static me.spongycat.spongify.Spongify.plugin;

public class LavaSurvivalListener implements Listener {
    private Queue<Player> playerQueue = new LinkedList<>();
    private boolean gameStarted = false;
    private int minPlayers = 2;

    private final int boxX = 100; // Example coordinates
    private final int boxY = 100;
    private final int boxZ = 100;

    public static List<Hologram> hologramList = new ArrayList<>();

    @EventHandler
    public void onInteractHologram(HologramClickEvent event) {
        Hologram hologram = event.getHologram();
        // Check if the player interacted with the hologram
        if (event.getClick() == ClickType.RIGHT && (hologramList.contains(hologram))) {
            Player player = event.getPlayer();
            if (!playerQueue.contains(player)) {
                playerQueue.add(player);
                player.sendMessage(ChatColor.GREEN + "You have been added to the lava survival queue!");
                if (playerQueue.size() >= minPlayers) {
                    for (Player player1 : playerQueue) {
                        player1.sendMessage(ChatColor.YELLOW + "Lava survival starting in 5");
                        player1.sendMessage(ChatColor.YELLOW + "Lava survival starting in 4");
                        player1.sendMessage(ChatColor.YELLOW + "Lava survival starting in 3");
                        player1.sendMessage(ChatColor.YELLOW + "Lava survival starting in 2");
                        player1.sendMessage(ChatColor.YELLOW + "Lava survival starting in 1");
                        startGame();
                    }
                }
            } else {
                playerQueue.remove(player);
                player.sendMessage(ChatColor.RED + "You have been removed from the lava survival queue!");
            }
        }
    }

    private void startGame() {
        gameStarted = true;

        // Teleport players to the pre-made box
        World world = Bukkit.getWorld("world");
        int boxX = 100; // Example coordinates
        int boxY = 100;
        int boxZ = 100;

        for (Player player : playerQueue) {
            player.teleport(world.getBlockAt(boxX, boxY, boxZ).getLocation());
            player.getInventory().addItem(new ItemStack(Material.WHITE_WOOL, 64));
            // Add other necessary items to the player's inventory
        }

        // Start the countdown before lava falls
        Bukkit.getScheduler().runTaskLater(plugin, this::startLavaFall, 20 * 30);
    }

    private void startLavaFall() {
        // Start the lava falling from the top of the box
        World world = Bukkit.getWorld("world");

        // Code to make lava fall from the top of the box

        // Schedule wool removal and winner determination
        Bukkit.getScheduler().runTaskLater(plugin, this::resetAndEnd, 20 * 60 * 3);
    }

    private void resetAndEnd() {
        // Remove wool blocks within the defined area
        World world = Bukkit.getWorld("world");
        int minX = 95; // Example coordinates
        int minY = 95;
        int minZ = 95;
        int maxX = 105;
        int maxY = 105;
        int maxZ = 105;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == Material.WHITE_WOOL) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }

        // Determine the winner
        Player lastSurvivor = null;
        for (Player player : playerQueue) {
            if (player.getLocation().getBlockY() >= boxY) {
                if (lastSurvivor == null || player.getLocation().getBlockY() > lastSurvivor.getLocation().getBlockY()) {
                    lastSurvivor = player;
                }
            }
        }

        // Teleport the winner out and give rewards
        if (lastSurvivor != null) {
            lastSurvivor.sendMessage("Congratulations! You survived the lava survival game!");
            // Give rewards to the winner
        }

        // Reset the game
        playerQueue.clear();
        gameStarted = false;
    }

    public static void addHologram(Location location, String name) {
        if (DHAPI.getHologram("Lava_Survival") != null) {
            DHAPI.removeHologram("Lava_Survival");
        }
        List<String> line = Arrays.asList(ChatColor.YELLOW + "Lava Survival", ChatColor.AQUA + "Right click to join queue!");
        Hologram hologram = DHAPI.createHologram(name, location, line);
        hologramList.add(hologram);
    }
}

