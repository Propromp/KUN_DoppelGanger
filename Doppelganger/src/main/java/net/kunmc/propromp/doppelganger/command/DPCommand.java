package net.kunmc.propromp.doppelganger.command;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.NickNamerPlugin;
import org.inventivetalent.nicknamer.api.NickManager;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.inventivetalent.nicknamer.api.PluginNickManager;
import org.inventivetalent.nicknamer.command.SkinCommands;

public class DPCommand {

	public static boolean command(Player player,Command cmd,String commandLabel,String[] args) {
		switch(args[0]) {
		case "exec":
			exec(player,cmd,commandLabel,args);
			break;
		case "clear":
			clear(player, cmd, commandLabel, args);
			break;
		default:
			player.sendMessage("引数を指定してください。");
			return false;
		}
		return true;
	}

	private static void exec(Player player, Command cmd, String commandLabel, String[] args) {
		player.sendMessage("変更中");
		Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
		players = Bukkit.getOnlinePlayers().toArray(players);
		System.out.println(Bukkit.getOnlinePlayers().size());
		System.out.println(players.length);
		for(int i = 0; i < players.length; i ++) {
			doppel(players[i].getUniqueId(),args[1]);
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
	private static void clear(Player player,Command cmd,String commandLabel,String[] args) {
		player.sendMessage("変更中");
		Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
		players = Bukkit.getOnlinePlayers().toArray(players);
		for(int i = 0; i < players.length; i ++) {
			clear(players[i].getUniqueId());
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
	
	
	
	public static void doppel(UUID uuid,String owner) {
		PluginNickManager pnm = new PluginNickManager(NickNamerPlugin.instance);
		pnm.setNick(uuid, owner);
		pnm.setSkin(uuid, owner);
	}
	public static void clear(UUID uuid) {
		PluginNickManager pnm = new PluginNickManager(NickNamerPlugin.instance);
		pnm.removeNick(uuid);
		pnm.removeSkin(uuid);
	}

}
