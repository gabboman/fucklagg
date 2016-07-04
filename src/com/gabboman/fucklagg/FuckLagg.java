package com.gabboman.fucklagg;
import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class FuckLagg extends JavaPlugin {
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	this.getCommand("calclagg").setExecutor(new CalcLagg());
    	Bukkit.getConsoleSender().sendMessage("Loading lag killer by gabboman");
    	
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage("Unloading lag killer by gabboman");

    }

}
