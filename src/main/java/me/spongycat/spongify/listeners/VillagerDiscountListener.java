package me.spongycat.spongify.listeners;

import me.spongycat.spongify.items.VillagerDiscountItem;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class VillagerDiscountListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && item != null && item == VillagerDiscountItem.getZombifyWand()) {
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock.getState() instanceof Villager villager) {
                Location loc = villager.getLocation();

                // Convert villager to zombie villager
                ZombieVillager zombieVillager = loc.getWorld().spawn(loc, ZombieVillager.class);
                zombieVillager.setVillagerProfession(villager.getProfession());
                zombieVillager.setConversionTime(Integer.MAX_VALUE);
                villager.remove();
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Villager) {
            Player player = (Player) event.getDamager();
            Villager villager = (Villager) event.getEntity();

            // Apply discounts to the trades of the cured villager
            List<MerchantRecipe> recipes = villager.getRecipes();

            for (MerchantRecipe recipe : recipes) {
                int newPrice = recipe.getIngredients().get(0).getAmount() - 1; // Modify the price as desired
                ItemStack ingredient = recipe.getIngredients().get(0);
                if (newPrice > 0) {
                    ingredient.setAmount(newPrice);
                } else {
                    ingredient.setAmount(1); // Ensure the price is at least 1
                }
            }

            villager.setRecipes(recipes);
        }
    }
}