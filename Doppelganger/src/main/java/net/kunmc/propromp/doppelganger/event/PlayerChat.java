package net.kunmc.propromp.doppelganger.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import net.kunmc.propromp.doppelganger.api.DoppelAPI;
import net.kunmc.propromp.doppelganger.api.SendMessageAPI;

public class PlayerChat implements Listener {

	public PlayerChat(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerChatEvent(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		String message = e.getMessage();
		String doppeler = DoppelAPI.getDoppeler(player);
		if(doppeler!=null) {
			SendMessageAPI.sendtoAll("<"+doppeler+"> "+message);
			e.setCancelled(true);
		}
	}

}
