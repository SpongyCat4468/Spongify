package me.spongycat.spongify.items;

import me.spongycat.spongify.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class CustomArrowItem {
    // Function
    public static void changeTippedArrowColor(ItemStack tippedArrow, Color color) {
        if (tippedArrow.getType() == Material.TIPPED_ARROW) {
            PotionMeta meta = (PotionMeta) tippedArrow.getItemMeta();
            PotionData potionData = new PotionData(PotionType.WATER);
            meta.setBasePotionData(potionData); // Reset potion data to remove previous effects

            meta.setColor(color); // Set the desired color
            tippedArrow.setItemMeta(meta);
        }
    }

    // Custom Arrow

    public static ItemStack getDiamondArrow() {
        ItemStack diamondArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(diamondArrow, ChatColor.AQUA + "Diamond Arrow");
        changeTippedArrowColor(diamondArrow, Color.AQUA);

        return diamondArrow;
    }

    public static ItemStack getNetheriteArrow() {
        ItemStack netheriteArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(netheriteArrow, ChatColor.DARK_GRAY + "Netherite Arrow");
        changeTippedArrowColor(netheriteArrow, Color.fromRGB(58, 38, 24));

        return netheriteArrow;
    }

    public static ItemStack getExplosiveArrow() {
        ItemStack explodeArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(explodeArrow, ChatColor.RED + "Explosive Arrow");
        changeTippedArrowColor(explodeArrow, Color.RED);

        return explodeArrow;
    }

    public static ItemStack getTeleportArrow() {
        ItemStack teleportArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(teleportArrow, ChatColor.GREEN + "Teleport Arrow");
        changeTippedArrowColor(teleportArrow, Color.GREEN);

        return teleportArrow;
    }

    public static ItemStack getLevitateArrow() {
        ItemStack levitateArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(levitateArrow, ChatColor.LIGHT_PURPLE + "Levitate Arrow");
        changeTippedArrowColor(levitateArrow, Color.PURPLE);

        return levitateArrow;
    }

    public static ItemStack getWitherArrow() {
        ItemStack witherArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(witherArrow, ChatColor.BLACK + "Wither Arrow");
        changeTippedArrowColor(witherArrow, Color.BLACK);

        return witherArrow;
    }
    public static ItemStack getLightningArrow() {
        ItemStack lightningArrow = new ItemStack(Material.TIPPED_ARROW);
        ItemStackUtil.setDisplayName(lightningArrow, ChatColor.YELLOW + "Lightning Arrow");
        changeTippedArrowColor(lightningArrow, Color.YELLOW);

        return lightningArrow;
    }

    // Custom Arrowhead

    public static ItemStack getArmadylArrowhead() {
        ItemStack ArmadylArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(ArmadylArrowhead, ChatColor.YELLOW + "Armadyl Arrowhead");

        return ArmadylArrowhead;
    }
    public static ItemStack getZamorakArrowhead() {
        ItemStack ZamorakArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(ZamorakArrowhead, ChatColor.YELLOW + "Zamorak Arrowhead");

        return ZamorakArrowhead;
    }
    public static ItemStack getGuthixArrowhead() {
        ItemStack GuthixArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(GuthixArrowhead, ChatColor.YELLOW + "Guthix Arrowhead");

        return GuthixArrowhead;
    }
    public static ItemStack getSaradominArrowhead() {
        ItemStack SaradominArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(SaradominArrowhead, ChatColor.YELLOW + "Saradomin Arrowhead");

        return SaradominArrowhead;
    }
    public static ItemStack getZarosArrowhead() {
        ItemStack ZarosArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(ZarosArrowhead, ChatColor.YELLOW + "Zaros Arrowhead");

        return ZarosArrowhead;
    }
    public static ItemStack getDiamondArrowhead() {
        ItemStack diamondArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(diamondArrowhead, ChatColor.AQUA + "Diamond Arrowhead");

        return diamondArrowhead;
    }
    public static ItemStack getNetheriteArrowhead() {
        ItemStack netheriteArrowhead = new ItemStack(Material.FLINT);
        ItemStackUtil.setDisplayName(netheriteArrowhead, ChatColor.DARK_GRAY + "Netherite Arrowhead");

        return netheriteArrowhead;
    }
}
