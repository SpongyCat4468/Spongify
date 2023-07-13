package me.spongycat.spongify.commands.SpongifyCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;


public class SpongifyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length != 0) {
                switch (args[0]) {
                    case "lore" -> Function.lore(p, args);
                    case "version" -> Function.version(p);
                    case "give" -> {
                        int amount = Integer.parseInt(args[2]);
                        Function.give(p, args[1], amount);
                    }
                    case "about" -> Function.about(p);
                    case "reload" -> Function.reload(p);
                    case "debug" -> Function.debug(p);
                    case "lavasurvival" -> Function.lavasurvival(p, args[1]);
                }
            } else {
                Function.warn(p);
            }
        } else if (Objects.equals(args[0], "consolegive") && args[2] != null && args[3] != null && commandSender instanceof ConsoleCommandSender) {
            Function.consolegive(args);
        }
        return true;
    }
}
