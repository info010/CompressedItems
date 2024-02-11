package org.info_0.compresseditems.preventusages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PreventPlace implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getItemInHand().getItemMeta().getLocalizedName().isEmpty() && event.getItemInHand().getItemMeta().getLocalizedName().equals("compressed")) event.setCancelled(true);
    }

}
