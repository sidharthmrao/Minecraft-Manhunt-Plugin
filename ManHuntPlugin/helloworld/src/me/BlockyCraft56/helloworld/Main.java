package me.BlockyCraft56.helloworld;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static class SpeedRunners {
		public static Player spdrunr;
		public static boolean spdrunractivated = false;
	}


	@Override
	public void onEnable(){
		//Fired when the server enables the plugin
		getServer().getPluginManager().registerEvents(new ListenerClass(), this);
	}

	@Override
	public void onDisable() {
		//Fired when the server stops and disables all plugins
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

		if (label.equalsIgnoreCase("SpeedRunner")) {

			SpeedRunners.spdrunr = (Player) sender;
			SpeedRunners.spdrunractivated = true;
			SpeedRunners.spdrunr.sendMessage("You are now the speedrunner.");
			SpeedRunners.spdrunr.sendMessage(SpeedRunners.spdrunr.getDisplayName());
			return true;
		}

		if (label.equalsIgnoreCase("Hunter")) {
			final Player hunt = (Player) sender;
			final ItemStack tracker = new ItemStack(Material.COMPASS, 1);
			hunt.getInventory().addItem(tracker);
			if(SpeedRunners.spdrunractivated) {
				hunt.setCompassTarget(SpeedRunners.spdrunr.getLocation());
				hunt.sendMessage("Tracking " + SpeedRunners.spdrunr.getDisplayName());
			}
			return true;
		}

		if (label.equalsIgnoreCase("TheHunted")) {
			final Player player = (Player) sender;
			if(SpeedRunners.spdrunractivated) {
				player.sendMessage("The SpeedRunner is: " + SpeedRunners.spdrunr.getDisplayName() + ".");
			}
			else {

				player.sendMessage("No SpeedRunner has been initialized. Use /speedrunner to activate yourself as the SpeedRunner.");
			}
			return true;
		}

		return false;
	}

}

