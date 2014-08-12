package io.github.bloodynoseproduction;

import java.util.Arrays;

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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class GraveplaceListener implements Listener {
	@EventHandler
	public void PlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		LivingEntity player = event.getEntity();
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();		
		player.sendMessage("You died at " + "X: " + x + "Y: " + y + "Z: " + z);
		World w = player.getWorld();
		Location loc = new Location(w, x, y, z);
		loc.getBlock().setType(Material.CHEST);
		player.sendMessage("A chest was placed at death point");
		ItemStack[] drops = toItemStack(event.getDrops());
		String DropsString = Arrays.toString(drops);
        player.sendMessage("Your inventory was stored in an array.");
        player.sendMessage("///////////////////////////////////////////");
        player.sendMessage(DropsString);
        player.sendMessage("///////////////////////////////////////////");
        Chest c = (Chest) loc.getBlock().getState();
        	c.getBlockInventory().[U]setContents[/U]((ItemStack)drops);
        player.sendMessage("A chest has been placed with your items in it at" + "X: " + x + " Y: " + y + " Z: " + z);

		}
	public ItemStack[] toItemsStack(List<ItemStack> list) {
		ItemStack[] items = new ItemStack[list.size()];
		int index = 0;
		for (ItemStack i : list) {
			index++;
		}
	}

}
