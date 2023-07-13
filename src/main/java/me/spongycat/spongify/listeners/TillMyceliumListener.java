package me.spongycat.spongify.listeners;



import me.spongycat.spongify.Spongify;
import me.spongycat.spongify.spongifyData.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class TillMyceliumListener implements Listener {
    Plugin plugin = Spongify.getPlugin(Spongify.class);
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack tool = player.getInventory().getItemInMainHand();
        if (Config.CAN_TILL_MYCELIUM) {
            if (action == Action.RIGHT_CLICK_BLOCK && tool.getType() == Material.IRON_HOE) {
                Block block = event.getClickedBlock();
                if (block.getType() == Material.MYCELIUM) {
                    block.setType(Material.FARMLAND);
                    player.getWorld().playSound(block.getLocation(), "block.grass.place", 1, 1);
                    tool.setDurability((short) (tool.getDurability() + 1));
                    if (tool.getDurability() >= tool.getType().getMaxDurability()) {
                        player.getInventory().remove(tool);
                    }
                }
            } else if (action == Action.RIGHT_CLICK_BLOCK && tool.getType() == Material.DIAMOND_HOE) {
                Block block = event.getClickedBlock();
                if (block.getType() == Material.MYCELIUM) {
                    block.setType(Material.FARMLAND);
                    player.getWorld().playSound(block.getLocation(), "block.grass.place", 1, 1);
                    tool.setDurability((short) (tool.getDurability() + 1));
                    if (tool.getDurability() >= tool.getType().getMaxDurability()) {
                        player.getInventory().remove(tool);
                    }
                }
            } else if (action == Action.RIGHT_CLICK_BLOCK && tool.getType() == Material.NETHERITE_HOE) {
                Block block = event.getClickedBlock();
                if (block.getType() == Material.MYCELIUM) {
                    block.setType(Material.FARMLAND);
                    player.getWorld().playSound(block.getLocation(), "block.grass.place", 1, 1);
                    tool.setDurability((short) (tool.getDurability() + 1));
                    if (tool.getDurability() >= tool.getType().getMaxDurability()) {
                        player.getInventory().remove(tool);
                    }
                }
            }
        }
    }
}
