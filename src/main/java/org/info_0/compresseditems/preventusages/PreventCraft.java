package org.info_0.compresseditems.preventusages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PreventCraft implements Listener {

    @EventHandler
    public void useCraftingTable(CraftItemEvent event) {
        for (ItemStack item : event.getInventory().getContents()) {
            if (item != null && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null && meta.hasLocalizedName() && meta.getLocalizedName().equals("compressed")) {
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }

    @EventHandler
    public void useFurnace(FurnaceBurnEvent event) {
        ItemStack fuel = event.getFuel();
        if (fuel != null && fuel.hasItemMeta()) {
            ItemMeta meta = fuel.getItemMeta();
            if (meta != null && meta.hasLocalizedName() && meta.getLocalizedName().equals("compressed")) {
                event.setCancelled(true);
                event.setBurning(false);
            }
        }
    }

    @EventHandler
    public void useAnvil(PrepareAnvilEvent event){
        for(ItemStack item : event.getInventory().getContents()){
            if (item == null || !item.hasItemMeta()) return;
            if(!item.getItemMeta().getLocalizedName().isEmpty() && item.getItemMeta().getLocalizedName().equals("compressed")){
                event.setResult(null);
                return;
            }
        }
    }


}
