package me.spongycat.spongify.listeners.FletchingGUI;

import me.spongycat.spongify.items.CustomArrowItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.spongycat.spongify.util.ItemStackUtil.isSimilarItem;
import static me.spongycat.spongify.util.ItemStackUtil.isSimilarMaterial;

public class ClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack armadylArrowhead = CustomArrowItem.getArmadylArrowhead();
        ItemStack guthixArrowhead = CustomArrowItem.getGuthixArrowhead();
        ItemStack saradominArrowhead = CustomArrowItem.getSaradominArrowhead();
        ItemStack zarosArrowhead = CustomArrowItem.getZarosArrowhead();
        ItemStack zamorakArrowhead = CustomArrowItem.getZamorakArrowhead();
        ItemStack diamondArrowhead = CustomArrowItem.getDiamondArrowhead();
        ItemStack netheriteArrowhead = CustomArrowItem.getNetheriteArrowhead();

        final ItemStack clickedItem = e.getCurrentItem();
        if (!e.getInventory().containsAtLeast(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), 40)) return;

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        if (!(isSimilarMaterial(clickedItem, Material.FIRE_CHARGE)||
                isSimilarMaterial(clickedItem, Material.ARROW) ||
                isSimilarMaterial(clickedItem, Material.TIPPED_ARROW) ||
                isSimilarMaterial(clickedItem, Material.ENDER_PEARL) ||
                isSimilarMaterial(clickedItem, Material.PHANTOM_MEMBRANE) ||
                isSimilarMaterial(clickedItem, Material.WITHER_ROSE) ||
                isSimilarMaterial(clickedItem, Material.FLINT) ||
                isSimilarMaterial(clickedItem, Material.BLAZE_ROD) ||
                isSimilarMaterial(clickedItem, Material.NETHERITE_INGOT) ||
                isSimilarMaterial(clickedItem, Material.DIAMOND))) {
            e.setCancelled(true);
        }

        ItemStack fletch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta fletchMeta = fletch.getItemMeta();
        fletchMeta.setDisplayName(ChatColor.YELLOW + "Click To Fletch Your Custom Arrow!");
        fletch.setItemMeta(fletchMeta);

        final Player p = (Player) e.getWhoClicked();

        Inventory inv = e.getInventory();


        ItemStack arrowSlot = inv.getItem(13);
        ItemStack materialSlot = inv.getItem(10);
        ItemStack arrowheadSlot = inv.getItem(16);



        // Fletch
        if (clickedItem.isSimilar(fletch)) {
            // 10, 13, 16
            if (materialSlot != null && arrowSlot != null && arrowheadSlot != null) {
                int arrowAm = arrowSlot.getAmount();
                int materialAm = materialSlot.getAmount();
                int arrowheadAm = materialSlot.getAmount();
                if (arrowSlot.getType() == Material.ARROW) {
                    if (isSimilarMaterial(materialSlot, Material.FIRE_CHARGE) && isSimilarItem(arrowheadSlot, zamorakArrowhead)) {
                        setResult(inv, CustomArrowItem.getExplosiveArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.ENDER_PEARL) && isSimilarItem(arrowheadSlot, guthixArrowhead)) {
                        setResult(inv, CustomArrowItem.getTeleportArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.PHANTOM_MEMBRANE) && isSimilarItem(arrowheadSlot, saradominArrowhead)) {
                        setResult(inv, CustomArrowItem.getLevitateArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.WITHER_ROSE) && isSimilarItem(arrowheadSlot, zarosArrowhead)) {
                        setResult(inv, CustomArrowItem.getWitherArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.BLAZE_ROD) && isSimilarItem(arrowheadSlot, armadylArrowhead)) {
                        setResult(inv, CustomArrowItem.getLightningArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.DIAMOND) && isSimilarItem(arrowheadSlot, diamondArrowhead)) {
                        setResult(inv, CustomArrowItem.getDiamondArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.NETHERITE_INGOT) && isSimilarItem(arrowheadSlot, netheriteArrowhead)) {
                        setResult(inv, CustomArrowItem.getNetheriteArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    }
                }
            }
        }
    }
    private static void setResult(Inventory inv, ItemStack result, int amount) {

        ItemStack arrowSlot = inv.getItem(13);
        ItemStack firstIngredientSlot = inv.getItem(10);
        ItemStack secondIngredientSlot = inv.getItem(16);

        if (firstIngredientSlot != null) {
            firstIngredientSlot.setAmount(firstIngredientSlot.getAmount() - amount);
        }
        if (arrowSlot != null) {
            arrowSlot.setAmount(arrowSlot.getAmount() - amount);
        }
        if (secondIngredientSlot != null) {
            secondIngredientSlot.setAmount(secondIngredientSlot.getAmount() - amount);
        }

        result.setAmount(amount);
        inv.setItem(31, result);
        inv.setItem(10, firstIngredientSlot);
        inv.setItem(13, arrowSlot);
        inv.setItem(16, secondIngredientSlot);
    }
    public static int getResultAmount(int num1, int num2, int num3) {
        int smallest = num1;

        if (num2 < smallest) {
            smallest = num2;
        }

        if (num3 < smallest) {
            smallest = num3;
        }

        return smallest;
    }

 }
