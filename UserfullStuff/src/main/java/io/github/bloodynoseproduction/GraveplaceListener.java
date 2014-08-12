package io.github.bloodynoseproduction;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class GraveplaceListener implements Listener {
	@EventHandler
	public void PlayerDeath(EntityDeathEvent event) {
		Block dpoint = event.getEntity().getLocation().getBlock();
		LivingEntity player = event.getEntity();
		
		if(player instanceof Player){
			player = (Player) event.getEntity();
			ItemStack[] drops = event.getDrops().toArray();
			int x = player.getLocation().getBlockX();
			int y = player.getLocation().getBlockY();
			int z = player.getLocation().getBlockZ();
			World w = player.getWorld();Location(w, x, y, x);
			Location loc = new Location(w, x, y, z);
			Chest c = loc.getBlock().setType(Material.CHEST);
			c.getInventory().setContents(drops);
		}
	}

}
