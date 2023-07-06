package me.spongycat.spongify.util;

import org.bukkit.Bukkit;

public class CommandUtil {
    public static void executeCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
