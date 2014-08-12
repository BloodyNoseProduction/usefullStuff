package io.github.bloodynoseproduction;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class UsefullStuff extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("[UsefullStuff Enabled]");

		new GraveplaceListener(this);
		
		
		
		///////////////////////////////
		//      command executor    //
		/////////////////////////////
		
		this.getCommand("moo").setExecutor(new MyCommandExecutor(this));	
	}
	
	@Override
	public void onDisable() {
		// TODO
		getLogger().info("[UsefullStuff Disabled]");
	}
}
