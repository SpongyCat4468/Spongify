package me.spongycat.spongify.listeners;

import me.spongycat.spongify.items.CustomArrowItem;
import me.spongycat.spongify.util.Give;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;


public class CustomArrowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) throws InterruptedException {
        if (e.getEntity() instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player shooter) {
                // Check if the shooter has a custom item in their hand
                if (isUsingExplosiveArrow(shooter)) {
                    Location arrowLocation = arrow.getLocation();

                    World world = arrowLocation.getWorld();
                    float power = 5.0f;
                    boolean setFire = false;
                    world.createExplosion(arrowLocation, power, setFire);
                    arrow.remove();
                } else if (isUsingTeleportArrow(shooter)) {
                    Location arrowLocation = arrow.getLocation();

                    arrow.remove();
                    shooter.teleport(arrowLocation);
                } else if (isUsingLightningArrow(shooter)) {
                    Location arrowLocation = arrow.getLocation();
                    World world = arrowLocation.getWorld();

                    arrow.remove();
                    world.strikeLightning(arrowLocation);
                } else if (isUsingLevitateArrow(shooter) && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    addEffectToEntity(livingEntity, PotionEffectType.LEVITATION, 300, 2);
                } else if (isUsingWitherArrow(shooter)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    addEffectToEntity(livingEntity, PotionEffectType.WITHER, 100, 3);
                } else if (isUsingDiamondArrow(shooter)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (livingEntity.getHealth() - 6 <= 0) {
                        livingEntity.setHealth(0);
                        if (livingEntity instanceof Player p) {
                            p.getServer().getConsoleSender().sendMessage(p.getDisplayName() + " was killed by a diamond arrow");
                        }
                    } else {
                        livingEntity.setHealth(livingEntity.getHealth() - 6);
                    }
                } else if (isUsingNetheriteArrow(shooter)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (livingEntity.getHealth() - 12 <= 0) {
                        livingEntity.setHealth(0);
                        if (livingEntity instanceof Player p) {
                            p.getServer().getConsoleSender().sendMessage(p.getDisplayName() + " was killed by a netherite arrow");
                        }
                    } else {
                        livingEntity.setHealth(livingEntity.getHealth() - 12);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE && isNaturallyGenerated(e.getBlock())) {
            Random random = new Random();
            if (random.nextInt(100) + 1 == 1) {
                Give.givePlayer(e.getPlayer(), CustomArrowItem.getDiamondArrowhead(), 1, "Diamond Arrowhead");
            }
        }
        if (e.getBlock().getType() == Material.ANCIENT_DEBRIS && isNaturallyGenerated(e.getBlock())) {
            Random random = new Random();
            if (random.nextInt(100) + 1 == 1) {
                Give.givePlayer(e.getPlayer(), CustomArrowItem.getNetheriteArrowhead(), 1, "Netherite Arrowhead");
            }
        }
    }

    public boolean isNaturallyGenerated(Block block) {
        // Compare block metadata with the default value (e.g., 0 for most blocks)
        if (block.getType() == Material.ANCIENT_DEBRIS) {
            return block.getBlockData().getAsString().contains("minecraft:ancient_debris"); // Replace with the block type you want to check
        } else if (block.getType() == Material.DIAMOND_ORE) {
            return block.getBlockData().getAsString().contains("minecraft:diamond_ore");
        } else {
            return block.getBlockData().getAsString().contains("minecraft:deepslate_diamond_ore");
        }
    }


    public void addEffectToEntity(LivingEntity entity, PotionEffectType effectType, int duration, int amplifier) {
        PotionEffect effect = new PotionEffect(effectType, duration, amplifier);
        entity.addPotionEffect(effect);
    }


    public boolean isUsingExplosiveArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getExplosiveArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getExplosiveArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingTeleportArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getTeleportArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getTeleportArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingLevitateArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getLevitateArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getLevitateArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingWitherArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getWitherArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getWitherArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingLightningArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getLightningArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getLightningArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingNetheriteArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getNetheriteArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getNetheriteArrow())) {
            return true;
        }
        return false;
    }
    public boolean isUsingDiamondArrow(Player player) {
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Check if the offhand item is a bow or crossbow and the mainhand item is an arrow
        if ((offHandItem.getType() == Material.BOW || offHandItem.getType() == Material.CROSSBOW)
                && mainHandItem.isSimilar(CustomArrowItem.getDiamondArrow())) {
            return true;
        } else if ((mainHandItem.getType() == Material.BOW || mainHandItem.getType() == Material.CROSSBOW)
                && offHandItem.isSimilar(CustomArrowItem.getDiamondArrow())) {
            return true;
        }
        return false;
    }


}









