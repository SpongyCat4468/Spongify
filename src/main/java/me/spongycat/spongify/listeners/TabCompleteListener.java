package me.spongycat.spongify.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TabCompleteListener implements TabCompleter, Listener {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1 && Objects.equals(args[0], "spongify")) {
            completions.add("version");
            completions.add("lore");
            completions.add("about");
            completions.add("give");
        } else if (args.length == 2 && Objects.equals(args[1], "give")) {
            completions.add("SmeltingTouch");
            completions.add("AutoReplant");
            completions.add("Bundle");
            completions.add("ZombifyToken");
            completions.add("ZombifyWand");
            completions.add("CureWand");
            completions.add("CureToken");
        }
        return completions;
    }
}
