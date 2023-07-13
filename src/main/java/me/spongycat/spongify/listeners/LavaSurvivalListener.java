package me.spongycat.spongify.listeners;

import com.olziedev.playerwarps.api.PlayerWarpsAPI;
import com.olziedev.playerwarps.api.warp.Warp;
import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.actions.ClickType;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.event.HologramClickEvent;
import me.spongycat.spongify.util.GiveUtil;
import me.spongycat.spongify.util.PlayerUtil;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static me.spongycat.spongify.Spongify.plugin;

public class LavaSurvivalListener implements Listener {
    private static List<Player> playerQueue = new ArrayList<>();
    public static boolean isGameStarted = false;
    private static Server server;
    private static List<Player> alivePlayers = new ArrayList<>();
    private static int playerInGame;
    private static boolean isCountDown = false;
    private static Hologram hologram;
    private Warp warp;

    @EventHandler
    public void onInteractHolo(HologramClickEvent e){
        server = Bukkit.getServer();
        PlayerUtil.sendDebugMessage(e.getPlayer(), "Holo interacted");
        if (Objects.equals(e.getHologram().getName(), "Lava_Survival") && e.getClick() == ClickType.RIGHT) {
            PlayerUtil.sendDebugMessage(e.getPlayer(), "Starting");
            if (playerQueue.contains(e.getPlayer())) {
                playerQueue.remove(e.getPlayer());
                e.getPlayer().sendMessage(ChatColor.RED + "You have been removed from the queue!");
                server.broadcastMessage(ChatColor.LIGHT_PURPLE + e.getPlayer().getDisplayName() + " has left the lava survival queue!");
            } else {
                playerQueue.add(e.getPlayer());
                e.getPlayer().sendMessage(ChatColor.GREEN + "You have been added to the queue!");
                server.broadcastMessage(ChatColor.LIGHT_PURPLE + e.getPlayer().getDisplayName() + " has joined the lava survival queue!");
            }
            if (playerQueue.size() >= 1 && !isCountDown) {
                isCountDown = true;
                startCountdown();
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                int delay = 0;
                boolean isQueueFull = playerQueue.size() >= 1;

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 60 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 0);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 30 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20 * 30);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 10 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20 * 10);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 5 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20 * 5);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 4 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 3 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 2 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20);

                scheduler.runTaskLater(plugin, () -> {
                    if (isQueueFull) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game starting in 1 seconds");
                    } else {
                        isCountDown = false;
                        isGameStarted = false;
                    }
                }, delay += 20);

                scheduler.runTaskLater(plugin, () -> {
                    Bukkit.broadcastMessage(ChatColor.YELLOW + "Lava Survival Game has started!");
                    startGame();
                    isCountDown = false;
                }, delay + 20);
            }
        }
    }
    public void startGame() {
        alivePlayers.addAll(playerQueue);
        playerInGame = playerQueue.size();
        playerQueue.clear();
        isGameStarted = true;
        PlayerUtil.sendDebugMessage(Bukkit.getPlayerExact("SpongyTexas4468"), "Game Started");
        PlayerWarpsAPI.getInstance(api -> warp = api.getPlayerWarp("LavaSurvival"));
        if (warp == null) {
            PlayerUtil.sendDebugMessage(Bukkit.getPlayerExact("SpongyTexas4468"), "PW null");
            isGameStarted = false;
            server.broadcastMessage("Lava Survival Location Invalid! Please set up a public warp with the name 'LavaSurvival'!");
            return;
        }
        PlayerUtil.sendDebugMessage(Bukkit.getPlayerExact("SpongyTexas4468"), "?");
        for (Player p : alivePlayers) {
            PlayerUtil.sendDebugMessage(Bukkit.getPlayerExact("SpongyTexas4468"), "TP'ed!");
            p.teleport(warp.getWarpLocation().getLocation());
            GiveUtil.givePlayer(p, Material.WHITE_WOOL, 64, "White Wool");
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        alivePlayers.remove(e.getEntity());
        if (alivePlayers.contains(e.getEntity())) {
            server.broadcastMessage(e.getEntity().getDisplayName() + " has died in the lava survival game! " + alivePlayers.size() + "/" + playerInGame + " players left.");
        }
    }

    public static void spawnHolo(Player p) {
        List<String> lines = Arrays.asList(ChatColor.YELLOW + "Lava Survival", ChatColor.GRAY + "Interact with the hologram to join the queue!");
        Location location = p.getLocation();
        try {
            hologram = DHAPI.createHologram("Lava_Survival", location, true, lines);
        } catch (IllegalArgumentException e) {
            DHAPI.moveHologram("Lava_Survival", location);
            hologram = DHAPI.getHologram("Lava_Survival");
        }
    }

    public static void clearQueue() {
        playerQueue.clear();
        alivePlayers.clear();
    }


    public void startCountdown() {
        BossBar bossBar = Bukkit.createBossBar("Lava Survival", BarColor.YELLOW, BarStyle.SOLID);
        for (Player p : playerQueue) {
            bossBar.addPlayer(p);
        }
        bossBar.setProgress(1.0); // Set the initial progress to full


        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            double progress = bossBar.getProgress();
            if (progress < 1.0 / 60 || !isCountDown) {
                progress = 0.0;
                bossBar.setVisible(false);
                for (Player p : playerQueue) {
                    bossBar.removePlayer(p);
                }
                return;
            }
            progress -= 1.0 / 60.0; // Decrease the progress by 1/60 every second
            bossBar.setProgress(progress);
        }, 0L, 20L);
    }

    public static void endGame(Player p) {
        playerQueue.clear();
        isGameStarted = false;
        alivePlayers.clear();
        playerInGame = 0;
        isCountDown = false;
        server = Bukkit.getServer();
        server.broadcastMessage( ChatColor.GOLD + "Lava Survival Game has ended by " + p.getDisplayName() + " with command!");
    }
}

