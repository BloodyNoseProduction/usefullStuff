package io.github.bloodynoseproduction;

import java.util.Arrays;

import java.util.List;

import javax.swing.plaf.synth.SynthLookAndFeel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("unused")
public class GraveplaceListener implements Listener {

	UsefullStuff main;

	public GraveplaceListener(UsefullStuff plugin) {
		this.main = plugin;

	}

	@EventHandler
	public void PlayerDeath(PlayerDeathEvent event) {
		org.bukkit.entity.Player player = event.getEntity();
		org.bukkit.entity.Entity entity = event.getEntity();
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		String pn = player.getName();
		float exp = player.getExp();
		float level = player.getLevel();
		float bottle = (float) (level / 2);

		player.sendMessage("//////////////////////////////////////////////////");
		player.sendMessage("Bottle: " + bottle + "| Exp: " + exp + "| lvl: "
				+ level);
		player.sendMessage("Death Point: " + "X: " + x + "Y: " + y + "Z: " + z);
		player.sendMessage("//////////////////////////////////////////////////");
		World w = player.getWorld();
		Location loc = new Location(w, x, y - 1, z);
		Location sloc = new Location(w, x, y, z);
		Location sloc2 = new Location(w, x - 1, y, z);
		Location sloc3 = new Location(w, x - 2, y, z);

		Location f1 = new Location(w, x + 1, y, z);
		Location f2 = new Location(w, x + 1, y + 1, z);
		Location f3 = new Location(w, x + 1, y + 2, z);
		Location f4 = new Location(w, x + 1, y + 1, z + 1);
		Location f5 = new Location(w, x + 1, y + 1, z - 1);
		Location zom = new Location(w, x - 1, y + 1, z+ 1);
		
		loc.getBlock().setType(Material.CHEST);
		

		sloc.getBlock().setType(Material.CARPET);
		sloc2.getBlock().setType(Material.CARPET);
		sloc3.getBlock().setType(Material.CARPET);
		f1.getBlock().setType(Material.NETHER_FENCE);
		f2.getBlock().setType(Material.BEDROCK);
		f3.getBlock().setType(Material.NETHER_FENCE);
		f4.getBlock().setType(Material.NETHER_FENCE);
		f5.getBlock().setType(Material.NETHER_FENCE);

		Zombie nomnom = player.getWorld().spawn(zom, Zombie.class);
		nomnom.setCustomName(pn + "'s Corpse");
		nomnom.setCustomNameVisible(true);
		nomnom.setHealth(20);

		Chest c = (Chest) loc.getBlock().getState();

		ItemStack b = new ItemStack(Material.EXP_BOTTLE);
		for (ItemStack i : event.getDrops()) {
			c.getBlockInventory().addItem(i);
		}
		while (bottle > 0) {
			c.getBlockInventory().addItem(new ItemStack(Material.EXP_BOTTLE));
			bottle--;
		}
		event.getDrops().clear();
		event.setDroppedExp(0);
	}
}
