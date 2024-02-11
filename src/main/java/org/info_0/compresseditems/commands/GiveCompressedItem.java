package org.info_0.compresseditems.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.info_0.compresseditems.events.NewItem;

import static org.bukkit.Bukkit.getServer;

public class GiveCompressedItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 2){
            commandSender.sendMessage(ChatColor.YELLOW+"Kullanımı /givecompresseditem <oyuncu> <sıkıtırılmış-malzeme-tipi>");
            return false;
        }
        Player player = (Player) commandSender;
        if(Bukkit.getPlayer(strings[0]) == null){
            player.sendMessage("Oyuncu bulunamadı.");
            return false;
        }
        try {
            Bukkit.getPlayer(strings[0]).getInventory().addItem(NewItem.getCompressedItem(Material.valueOf(strings[1]),1));
            getServer().getLogger().severe(String.format("%s ,bir sıkıştırılmış %s aldı.",strings[0],strings[1]));
            return true;
        }catch (RuntimeException e){
            player.sendMessage("Materyal tipi geçerli değil. https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html");
        }
        return false;
    }
}
