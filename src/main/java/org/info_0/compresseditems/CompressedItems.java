package org.info_0.compresseditems;

import org.bukkit.plugin.java.JavaPlugin;
import org.info_0.compresseditems.commands.GiveCompressedItem;
import org.info_0.compresseditems.events.DeCompressedItem;
import org.info_0.compresseditems.preventusages.PreventCraft;
import org.info_0.compresseditems.preventusages.PreventPlace;

public final class CompressedItems extends JavaPlugin {

    private static CompressedItems instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new DeCompressedItem(),this);
        getServer().getPluginManager().registerEvents(new PreventCraft(),this);
        getServer().getPluginManager().registerEvents(new PreventPlace(),this);
        getCommand("givecompresseditem").setExecutor(new GiveCompressedItem());
    }

    public static CompressedItems getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
