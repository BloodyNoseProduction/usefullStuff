package io.github.bloodynoseproduction;
 
import java.util.Arrays;
 
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
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
	public GraveplaceListener(UsefullStuff plugin){
    this.main= plugin;
    
    }
	 @EventHandler
     public void PlayerDeath(PlayerDeathEvent event) {
         org.bukkit.entity.Player player = event.getEntity();
         org.bukkit.entity.Entity entity = event.getEntity();
         int x = player.getLocation().getBlockX();
         int y = player.getLocation().getBlockY();
         int z = player.getLocation().getBlockZ();  
         
         float exp = player.getExp();
         float level = player.getLevel();
         float bottle = (float) (level/2);
         player.sendMessage("Bottle: " + bottle + "| Exp: " + exp + "| lvl: " + level  );
         
         player.sendMessage("You died at " +"[u]"+ "X: " + x + "Y: " + y + "Z: " + z + "[/u]");
         World w = player.getWorld();
         Location loc = new Location(w, x, y, z);
         loc.getBlock().setType(Material.CHEST);
         player.sendMessage("A chest was placed at death point");
         Chest c = (Chest) loc.getBlock().getState();
         
         ItemStack b = new ItemStack(Material.EXP_BOTTLE);
         for(ItemStack i : event.getDrops()) {
        	 c.getBlockInventory().addItem(i);
         }
         while(bottle > 0){
        	 c.getBlockInventory().addItem(new ItemStack(Material.EXP_BOTTLE));
        	 bottle--;
         }
         event.getDrops().clear();
         event.setDroppedExp(0);
	 }
}





