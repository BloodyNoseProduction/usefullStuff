package io.github.bloodynoseproduction;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class UsefullStuff extends JavaPlugin {
	
	public void loadConfiguration(){

	     this.getConfig().options().copyDefaults(true); 
	     this.saveConfig();
	}

	@Override
	public void onEnable() {
	/*	try {
			File file = new File(getDataFolder() + "config.yml");
			FileConfiguration cfg = getConfig();
			if (!file.exists()) {
				cfg.addDefault("default.playergrave.enable", "true");
				cfg.addDefault("default.cottage.enable", "true");
				cfg.options().copyDefaults(true);
				saveConfig();
			}
		} catch (Exception e) {
		}*/
		
		
		loadConfiguration();
		
		getLogger().info("[UsefullStuff Enabled]");
		Boolean pg = this.getConfig().getBoolean("default.playergrave.enable");
		Boolean pc = this.getConfig().getBoolean("default.cottage.enable");
		if (pg == true) {
			// getConfig().set("default.playergrave.enable", true);
			getServer().getPluginManager().registerEvents(new GraveplaceListener(this), this);
			getLogger().info("[UsefullStuff GravePlaceListener &eEnabled]");
		}
		if (pc == true) {
			
			getServer().getPluginManager().registerEvents(new PlayerCottage(this), this);
			getLogger().info("[UsefullStuff PlayerCottage &eEnabled]");
		}
		else{}
		
		
		// /////////////////////////////
		// command executor //
		// ///////////////////////////

		this.getCommand("moo").setExecutor(new MyCommandExecutor(this));
		//this.getCommand("cot").setExecutor(new MyCommandExecutor(this));
		

	}

	@Override
	public void onDisable() {
		// TODO
		getLogger().info("[UsefullStuff Disabled]");
	}
}
