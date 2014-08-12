package io.github.bloodynoseproduction;
 
import java.util.Arrays;
 
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
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
 
    //private UsefullStuff main;
	//private static final ItemStack[][] ItemStack = null;
    UsefullStuff main;
	public GraveplaceListener(UsefullStuff plugin){
    this.main= plugin;
    
    }
    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();       
        player.sendMessage("You died at " + "X: " + x + "Y: " + y + "Z: " + z);
        }
    @EventHandler
    public void onEnttityDamageByEntity(EntityDamageByEntityEvent event){
    	//TODO
    }
}





