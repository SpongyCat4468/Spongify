package me.spongycat.spongify.enchants;

import me.spongycat.spongify.Spongify;
import org.bukkit.Bukkit;
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
import java.util.Random;

import static me.spongycat.spongify.Spongify.plugin;


public class SmeltingTouchEnchantment extends Enchantment implements Listener {
    public SmeltingTouchEnchantment(String namespace) {
        super(new NamespacedKey(Spongify.getPlugin(Spongify.class), namespace));
    }

    private ItemStack getDrop(Material drop, int amount) {
        return new ItemStack(drop, amount);
    }

    private final List<Material> oreList = Arrays.asList(
            Material.COPPER_ORE,
            Material.IRON_ORE,
            Material.GOLD_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.DEEPSLATE_GOLD_ORE,
            Material.NETHER_GOLD_ORE,
            Material.ANCIENT_DEBRIS,
            Material.RAW_COPPER_BLOCK,
            Material.RAW_IRON_BLOCK,
            Material.RAW_GOLD_BLOCK
            );
    private final List<Material> blockList = Arrays.asList(
            Material.SAND,
            Material.RED_SAND
    );
    @EventHandler
    public void BreakEvent(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack tool = player.getInventory().getItemInMainHand();
        Material oreBlockType;
        Material blockType;
        ItemStack drop = new ItemStack(Material.AIR);

        if (plugin.getConfig().getBoolean("Enable_Smelting_Touch")) {
            if (tool.getEnchantments().containsKey(Enchantment.getByKey(Spongify.smeltingTouchEnchantment.getKey()))) {
                if (oreList.contains(block.getType())) {
                    oreBlockType = block.getType();
                    if (oreBlockType == Material.COPPER_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(4) + 2);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(9) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(14) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(19) + 1);
                        }
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.IRON_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            drop = getDrop(Material.IRON_INGOT, 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(2) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(3) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(4) + 1);
                        }
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.GOLD_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            drop = getDrop(Material.GOLD_INGOT, 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(2) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(3) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(4) + 1);
                        }
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.DEEPSLATE_COPPER_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(4) + 2);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(9) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(14) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.COPPER_INGOT, random.nextInt(19) + 1);
                        }
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.DEEPSLATE_IRON_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            drop = getDrop(Material.IRON_INGOT, 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(2) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(3) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.IRON_INGOT, random.nextInt(4) + 1);
                        }
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.DEEPSLATE_GOLD_ORE) {
                        if (!tool.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                            drop = getDrop(Material.GOLD_INGOT, 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(2) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(3) + 1);
                        } else if (tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                            Random random = new Random();
                            drop = getDrop(Material.GOLD_INGOT, random.nextInt(4) + 1);
                        }
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
                    } else if (oreBlockType == Material.RAW_COPPER_BLOCK) {
                        drop = new ItemStack(Material.COPPER_BLOCK);
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.RAW_IRON_BLOCK) {
                        drop = new ItemStack(Material.IRON_BLOCK);
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (oreBlockType == Material.RAW_GOLD_BLOCK) {
                        drop = new ItemStack(Material.GOLD_BLOCK);
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    }
                }
                if (blockList.contains(block.getType())) {
                    blockType = block.getType();
                    if (blockType == Material.SAND) {
                        drop = new ItemStack(Material.GLASS);
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    } else if (blockType == Material.RED_SAND) {
                        drop = new ItemStack(Material.GLASS);
                        block.setType(Material.AIR);
                        block.getWorld().dropItem(block.getLocation(), drop);
                        event.setCancelled(true);
                    }
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

