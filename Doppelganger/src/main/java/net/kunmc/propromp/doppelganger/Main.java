package net.kunmc.propromp.doppelganger;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import net.kunmc.propromp.doppelganger.command.DPCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("DoppelgangerPlugin by Propromp");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel,String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			DPCommand.command(player, cmd, commandLabel, args);
		}
		return true;
	}

}
