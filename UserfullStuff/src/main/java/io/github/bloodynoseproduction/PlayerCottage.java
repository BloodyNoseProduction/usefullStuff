package io.github.bloodynoseproduction;

import java.awt.Desktop.Action;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public class PlayerCottage implements Listener {

	private UsefullStuff plugin;
	
	public PlayerCottage(UsefullStuff plugin) {
		this.plugin = plugin;
	}
	
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		org.bukkit.entity.Player player = (Player) event.getPlayer();
		
		if(event.getAction() == org.bukkit.event.block.Action.LEFT_CLICK_BLOCK && event.getMaterial() == Material.WOOD_HOE && event.getClickedBlock().getType() == Material.CHEST) {
			player.sendMessage("That is a chest");
		}
	}
}
