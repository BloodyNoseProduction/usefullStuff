package io.github.bloodynoseproduction;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.PlaySoundCommand;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class MyCommandExecutor implements CommandExecutor {
	private UsefullStuff plugin;

	public MyCommandExecutor(UsefullStuff plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {

		if (cmd.getName().equalsIgnoreCase("moo") && sender instanceof Player) {

			Player player = (Player) sender;
			Location loc = player.getLocation();
			player.sendMessage(ChatColor.AQUA + "Moo, " + player.getName()+ "!");
			
			player.playSound(loc, Sound.COW_HURT, 5F, 1F);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("cot") && sender instanceof Player) {
			
			Player player = (Player) sender;
			int x = player.getLocation().getBlockX();
			int y = player.getLocation().getBlockY();
			int z = player.getLocation().getBlockZ();
			World w = player.getWorld();
			Location loc = new Location(w, x + 2, y, z);
			Location loc2 = new Location(w, x +2, y + 1, z);
			
			
			loc.getBlock().setType(Material.COBBLESTONE);
			loc2.getBlock().setType(Material.COBBLESTONE);
			return true;
			
		}
		
		return false;
	}

}
