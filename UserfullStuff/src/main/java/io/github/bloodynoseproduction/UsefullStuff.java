package io.github.bloodynoseproduction;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UsefullStuff extends JavaPlugin {

	@Override
	public void onEnable() {
		// TODO
		getLogger().info("onEnable has been invoked!");
		
		//new PlayerListener(this);
		new GraveplaceListener(this);
	}
	
	@Override
	public void onDisable() {
		// TODO
		getLogger().info("onDisable has been invoked!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (cmd.getName().equalsIgnoreCase("hello") && sender instanceof Player) {
			
			Player player = (Player) sender;
			player.sendMessage("Moo, " + player.getName() + "!");
			
			return true;
		}
		
		return false;
	}
	
}
