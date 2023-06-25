package me.spongycat.spongify.listeners;

import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.items.CustomArrowItem;
import me.spongycat.spongify.util.Give;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static me.spongycat.spongify.Spongify.plugin;


public class CustomArrowListener implements Listener {
    private Set<UUID> playersShootingExplosive = new HashSet<>();
    private Set<UUID> playersShootingLightning = new HashSet<>();
    private Set<UUID> playersShootingLevitate = new HashSet<>();
    private Set<UUID> playersShootingTeleport = new HashSet<>();
    private Set<UUID> playersShootingWither = new HashSet<>();
    private Set<UUID> playersShootingDiamond = new HashSet<>();
    private Set<UUID> playersShootingNetherite = new HashSet<>();

    private int count = 3;

    @EventHandler
    public void onPrepareShoot(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (isUsingExplosiveArrow(p)) {
            playersShootingExplosive.add(p.getUniqueId());
        } else if (isUsingLightningArrow(p)) {
            playersShootingLightning.add(p.getUniqueId());
        } else if (isUsingLevitateArrow(p)) {
            playersShootingLevitate.add(p.getUniqueId());
        } else if (isUsingTeleportArrow(p)) {
            playersShootingTeleport.add(p.getUniqueId());
        } else if (isUsingWitherArrow(p)) {
            playersShootingWither.add(p.getUniqueId());
        } else if (isUsingDiamondArrow(p)) {
            playersShootingDiamond.add(p.getUniqueId());
        } else if (isUsingNetheriteArrow(p)) {
            playersShootingNetherite.add(p.getUniqueId());
        }
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player shooter) {
                UUID ID = shooter.getUniqueId();
                // Check if the shooter has a custom item in their hand
                if (playersShootingExplosive.contains(ID)) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingExplosive.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingExplosive.remove(ID);
                        }
                    }
                    Location arrowLocation = arrow.getLocation();

                    World world = arrowLocation.getWorld();
                    float power = 5.0f;
                    boolean setFire = false;
                    world.createExplosion(arrowLocation, power, setFire);
                    arrow.remove();
                } else if (playersShootingTeleport.contains(ID)) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingTeleport.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingTeleport.remove(ID);
                        }
                    }
                    Location arrowLocation = arrow.getLocation();

                    arrow.remove();
                    shooter.teleport(arrowLocation);
                } else if (playersShootingLightning.contains(ID)) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingLightning.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingLightning.remove(ID);
                        }
                    }
                    Location arrowLocation = arrow.getLocation();
                    World world = arrowLocation.getWorld();

                    arrow.remove();
                    world.strikeLightning(arrowLocation);
                } else if (playersShootingLevitate.contains(ID) && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingLevitate.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingLevitate.remove(ID);
                        }
                    }
                    addEffectToEntity(livingEntity, PotionEffectType.LEVITATION, 300, 2);
                } else if (playersShootingWither.contains(ID)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingWither.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingWither.remove(ID);
                        }
                    }
                    addEffectToEntity(livingEntity, PotionEffectType.WITHER, 100, 3);
                } else if (playersShootingDiamond.contains(ID)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingDiamond.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingDiamond.remove(ID);
                        }
                    }
                    if (livingEntity.getHealth() - 6 <= 0) {
                        livingEntity.setHealth(0);
                        if (livingEntity instanceof Player p) {
                            p.getServer().getConsoleSender().sendMessage(p.getDisplayName() + " was killed by a diamond arrow");
                        }
                    } else {
                        livingEntity.setHealth(livingEntity.getHealth() - 6);
                    }
                } else if (playersShootingNetherite.contains(ID)  && e.getHitEntity() instanceof LivingEntity livingEntity) {
                    if (!isUsingMultishot(shooter)) {
                        playersShootingNetherite.remove(ID);
                    } else {
                        if (count != 1) {
                            count -= 1;
                        } else {
                            count = 3;
                            playersShootingNetherite.remove(ID);
                        }
                    }
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
        if (e.getBlock().getType() == Material.DIAMOND_ORE && isNaturallyGenerated(e.getBlock())) {
            if (drop(plugin.getConfig().getInt("Diamond_Ore"))) {
                Give.givePlayer(e.getPlayer(), CustomArrowItem.getDiamondArrowhead(), 1, "Diamond Arrowhead");
            }
        } else if (e.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE && isNaturallyGenerated(e.getBlock())) {
            if (drop(plugin.getConfig().getInt("Diamond_Ore"))) {
                Give.givePlayer(e.getPlayer(), CustomArrowItem.getDiamondArrowhead(), 1, "Diamond Arrowhead");
            }
        } else if (e.getBlock().getType() == Material.ANCIENT_DEBRIS && isNaturallyGenerated(e.getBlock())) {
            if (drop(plugin.getConfig().getInt("Ancient_Debris"))) {
                Give.givePlayer(e.getPlayer(), CustomArrowItem.getNetheriteArrowhead(), 1, "Netherite Arrowhead");
            }
        }
    }

    public static boolean drop(int percentage) {
        // Convert the percentage to a decimal value
        double probability = percentage / 100.0;

        // Generate a random number between 0 and 1
        double random = Math.random();

        // Check if the random number is less than the probability
        return random < probability;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block b = event.getBlock();
        if (b.getType() == Material.DIAMOND_ORE || b.getType() == Material.DEEPSLATE_DIAMOND_ORE || b.getType() == Material.ANCIENT_DEBRIS) {
            b.setMetadata("PLACED", new FixedMetadataValue(plugin, "E"));
            System.out.println("PLACED");
        }
    }

    public boolean isNaturallyGenerated(Block block) {
        return !block.hasMetadata("PLACED");
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

    public boolean isUsingMultishot(Player player) {
        return player.getInventory().getItemInOffHand().containsEnchantment(Enchantment.MULTISHOT) ||
                player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.MULTISHOT);
    }


}









