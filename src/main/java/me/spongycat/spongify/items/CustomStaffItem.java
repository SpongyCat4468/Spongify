package me.spongycat.spongify.items;

import me.spongycat.spongify.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class CustomStaffItem {
    public static ItemStack getChaosStaff() {
        ItemStack ChaosStaff = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemStackUtil.setDisplayName(ChaosStaff, ChatColor.YELLOW + "Chaos Staff");

        return ChaosStaff;
    }

    public static ItemStack getTeleportStaff() {
        ItemStack TeleportStaff = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemStackUtil.setDisplayName(TeleportStaff, ChatColor.GREEN + "Teleport Staff");

        return TeleportStaff;
    }

    public static ItemStack getJudegementStaff() {
        ItemStack JudgementStaff = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemStackUtil.setDisplayName(JudgementStaff, ChatColor.GOLD + "Judgement Staff");

        return JudgementStaff;
    }

    public static ItemStack getShallNotPassStaff() {
        ItemStack ShallNotPassStaff = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemStackUtil.setDisplayName(ShallNotPassStaff, ChatColor.GRAY + "Shall Not Pass Staff");
        ShallNotPassStaff.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        ItemStackUtil.hideEnchant(ShallNotPassStaff);

        return ShallNotPassStaff;
    }

    public static ItemStack getHolyStaff() {
        ItemStack HolyStaff = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemStackUtil.setDisplayName(HolyStaff, ChatColor.RED + "Holy Staff");

        return HolyStaff;
    }
}
