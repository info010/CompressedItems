package org.info_0.compresseditems.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NewItem {

    private static ItemStack createCompressedItem(Material material,Integer amount){
        ItemStack item = new ItemStack(material,amount);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.removeItemFlags();
        meta.setDisplayName(ChatColor.AQUA + String.format("Sıkıştırılmış %s",material.name()));
        meta.setLocalizedName("compressed");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getCompressedItem(Material material,Integer amount){
        return createCompressedItem(material,amount);
    }

}
