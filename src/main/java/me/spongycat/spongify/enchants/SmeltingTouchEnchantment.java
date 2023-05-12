package me.spongycat.spongify.enchants;

import me.spongycat.spongify.Spongify;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class SmeltingTouchEnchantment extends Enchantment implements Listener {
    public SmeltingTouchEnchantment(String namespace) {
        super(new NamespacedKey(Spongify.getPlugin(Spongify.class), namespace));
    }

    private final List<Material> oreList = Arrays.asList(
            Material.COPPER_ORE,
            Material.IRON_ORE,
            Material.GOLD_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.DEEPSLATE_GOLD_ORE,
            Material.NETHER_GOLD_ORE,
            Material.ANCIENT_DEBRIS
            );
    @EventHandler
    public void BreakEvent(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack tool = player.getInventory().getItemInMainHand();
        Material oreBlockType;
        ItemStack drop;

        if (tool.getEnchantments().containsKey(Enchantment.getByKey(Spongify.smeltingTouchEnchantment.getKey()))) {
            if (oreList.contains(block.getType())) {
                oreBlockType = block.getType();
                if (oreBlockType == Material.COPPER_ORE) {
                    drop = new ItemStack(Material.COPPER_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.IRON_ORE) {
                    drop = new ItemStack(Material.IRON_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.GOLD_ORE) {
                    drop = new ItemStack(Material.GOLD_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.DEEPSLATE_COPPER_ORE) {
                    drop = new ItemStack(Material.COPPER_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.DEEPSLATE_IRON_ORE) {
                    drop = new ItemStack(Material.IRON_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.DEEPSLATE_GOLD_ORE) {
                    drop = new ItemStack(Material.GOLD_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.NETHER_GOLD_ORE) {
                    drop = new ItemStack(Material.GOLD_INGOT);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                } else if (oreBlockType == Material.ANCIENT_DEBRIS) {
                    drop = new ItemStack(Material.NETHERITE_SCRAP);
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), drop);
                    event.setCancelled(true);
                }


            }
        }

    }



    @Override
    public String getName() {
        return "Smelting Touch";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TOOL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment == Enchantment.SILK_TOUCH) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return true;
    }
}

