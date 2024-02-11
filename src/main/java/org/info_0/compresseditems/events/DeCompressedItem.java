package org.info_0.compresseditems.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DeCompressedItem implements Listener {

    private boolean emptySlot(Player player){
        for(int i = 0; i<=35;i++ ) {
            if(player.getInventory().getItem(i) != null && !player.getInventory().getItem(i).getType().isAir()) continue;
            return true;
        }
        return false;
    }

    @EventHandler
    public void decompressItemEvent(PlayerInteractEvent event){
        if(event.getPlayer().getInventory().getItemInMainHand() == null || event.getPlayer().getInventory().getItemInMainHand().getType().isAir()) return;
        if(!(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR))) return;
        if(!event.getPlayer().isSneaking()) return;
        if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLocalizedName().isEmpty()
                || !event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("compressed")) return;
        if(event.getPlayer().getInventory().getItemInOffHand() != null && !event.getPlayer().getInventory().getItemInOffHand().getType().isAir()) return;
        Player player = event.getPlayer();
        if(!emptySlot(player)) return;
        int amount = event.getPlayer().getInventory().getItemInMainHand().getAmount();
        Material material = event.getPlayer().getInventory().getItemInMainHand().getType();
        event.getItem().setAmount(amount-1);
        player.getInventory().addItem(new ItemStack(material,64));
    }

}
