package io.github.bloodynoseproduction;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

@SuppressWarnings("unused")
public class PlayerListener implements Listener{
	
	public PlayerListener(UsefullStuff plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
}