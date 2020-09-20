package net.kunmc.propromp.doppelganger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.kunmc.propromp.doppelganger.api.DoppelAPI;
import net.kunmc.propromp.doppelganger.command.DPCommand;
import net.kunmc.propromp.doppelganger.event.PlayerChat;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("DoppelgangerPlugin by Propromp");
		new PlayerChat(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel,String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			DPCommand.command(player, cmd, commandLabel, args);
		}
		return true;
	}
	
	@Override
	public void onDisable() {
		DoppelAPI.clearAll();
		this.getLogger().finest("bye");
	}

}
