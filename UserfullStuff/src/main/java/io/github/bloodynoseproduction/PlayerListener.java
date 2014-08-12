package io.github.bloodynoseproduction;

import org.bukkit.event.Listener;

public class PlayerListener implements Listener{
	
	public PlayerListener(UsefullStuff plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
}