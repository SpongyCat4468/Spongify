package me.spongycat.spongify.listeners.FletchingGUI;

import me.spongycat.spongify.GUI.FletchingTableGUI;
import me.spongycat.spongify.items.CustomArrowItem;
import me.spongycat.spongify.spongifyData.Item;
import me.spongycat.spongify.util.ItemStackUtil;
import me.spongycat.spongify.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static me.spongycat.spongify.util.ItemStackUtil.isSimilarItem;
import static me.spongycat.spongify.util.ItemStackUtil.isSimilarMaterial;

public class ClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        PlayerUtil.sendDebugMessage(e.getWhoClicked(), "Clicked");

        ItemStack fletch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStackUtil.setDisplayName(fletch, ChatColor.YELLOW + "Click To Fletch Your Custom Arrow!");

        final ItemStack clickedItem = e.getCurrentItem();
        if (!FletchingTableGUI.isFletchingGUI(e.getInventory())) return;
        PlayerUtil.sendDebugMessage(e.getWhoClicked(), "GUI is fletching table");

        final Player p = (Player) e.getWhoClicked();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        List<Material> fletchingMaterial = Arrays.asList(
                Material.FIRE_CHARGE,
                Material.ARROW,
                Material.TIPPED_ARROW,
                Material.ENDER_PEARL,
                Material.PHANTOM_MEMBRANE,
                Material.WITHER_ROSE,
                Material.FLINT,
                Material.BLAZE_ROD,
                Material.NETHERITE_INGOT,
                Material.DIAMOND
        );


        boolean isFletchingMaterial = fletchingMaterial.contains(clickedItem.getType());


        if (FletchingTableGUI.isFletchingGUI(e.getInventory())) {
            if (!isFletchingMaterial) {
                e.setCancelled(true);
                PlayerUtil.sendDebugMessage(p, "Click event has been cancelled. (Fletching GUI)");
            }
        }

        Inventory inv = e.getInventory();


        ItemStack arrowSlot = inv.getItem(13);
        ItemStack materialSlot = inv.getItem(10);
        ItemStack arrowheadSlot = inv.getItem(16);



        // Fletch
        if (clickedItem.isSimilar(fletch)) {
            if (materialSlot != null && arrowSlot != null && arrowheadSlot != null) {
                int arrowAm = arrowSlot.getAmount();
                int materialAm = materialSlot.getAmount();
                int arrowheadAm = materialSlot.getAmount();
                if (arrowSlot.getType() == Material.ARROW) {
                    if (isSimilarMaterial(materialSlot, Material.FIRE_CHARGE) && isSimilarItem(arrowheadSlot, Item.ZAMORAK_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getExplosiveArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.ENDER_PEARL) && isSimilarItem(arrowheadSlot, Item.GUTHIX_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getTeleportArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.PHANTOM_MEMBRANE) && isSimilarItem(arrowheadSlot, Item.SARADOMIN_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getLevitateArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.WITHER_ROSE) && isSimilarItem(arrowheadSlot, Item.ZAROS_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getWitherArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.BLAZE_ROD) && isSimilarItem(arrowheadSlot, Item.ARMADYL_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getLightningArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.DIAMOND) && isSimilarItem(arrowheadSlot, Item.DIAMOND_ARROWHEAD)) {
                        setResult(inv, CustomArrowItem.getDiamondArrow(), getResultAmount(arrowAm, materialAm, arrowheadAm));
                    } else if (isSimilarMaterial(materialSlot, Material.NETHERITE_INGOT) && isSimilarItem(arrowheadSlot, Item.NETHERITE_ARROWHEAD)) {
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
