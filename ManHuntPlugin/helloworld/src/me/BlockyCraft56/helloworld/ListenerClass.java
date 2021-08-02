package me.BlockyCraft56.helloworld;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ListenerClass implements Listener {

	@EventHandler
	public void onInteract(final PlayerInteractEvent event) {
		final Action action = event.getAction();
		final Player player = event.getPlayer();
		if(action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
			if(player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
				player.setCompassTarget(Main.SpeedRunners.spdrunr.getLocation());
				player.sendMessage("Refreshed Compass.");
			}

		}

	}
}
