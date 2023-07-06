package me.spongycat.spongify.commands.SpongifyCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpongifyTabComplete implements TabCompleter{
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("version");
            completions.add("lore");
            completions.add("about");
            completions.add("give");
            completions.add("reload");
            completions.add("lavasurvival");
        } else if (args.length == 2 && Objects.equals(args[0], "give")) {
            // Misc
            completions.add("DiamondCore");
            completions.add("SuperGoldenCarrot");
            completions.add("SmeltingTouch");
            completions.add("AutoReplant");
            completions.add("Bundle");
            // God Sword Item
            completions.add("SaradominHilt");
            completions.add("GuthixHilt");
            completions.add("ArmadylHilt");
            completions.add("ZamorakHilt");
            completions.add("GodSwordBlade");
            completions.add("SaradominGodSword");
            completions.add("GuthixGodSword");
            completions.add("ArmadylGodSword");
            completions.add("ZamorakGodSword");
            // Custom Arrow
            completions.add("DiamondArrow");
            completions.add("NetheriteArrow");
            completions.add("LightningArrow");
            completions.add("ExplosiveArrow");
            completions.add("TeleportArrow");
            completions.add("LevitateArrow");
            completions.add("WitherArrow");

            completions.add("DiamondArrowhead");
            completions.add("NetheriteArrowhead");
            completions.add("ArmadylArrowhead");
            completions.add("GuthixArrowhead");
            completions.add("SaradominArrowhead");
            completions.add("ZamorakArrowhead");
            completions.add("ZarosArrowhead");
            // Custom Staff
            completions.add("ChaosStaff");
            completions.add("TeleportStaff");
            completions.add("JudgementStaff");
            completions.add("ShallNotPassStaff");
            completions.add("HolyStaff");
        } else if (args.length == 2 && Objects.equals(args[0], "lavasurvival")) {
            completions.add("spawnHolo");
        }
        return completions;
    }
}
