package net.kunmc.propromp.doppelganger.command;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import net.kunmc.propromp.doppelganger.api.DoppelAPI;
import net.kunmc.propromp.doppelganger.api.SendMessageAPI;

public class DPCommand {

	public static boolean command(Player player,Command cmd,String commandLabel,String[] args) {
		switch(args[0]) {
		case "exec":
			exec(player,cmd,commandLabel,args);
			break;
		case "clear":
			clear(player, cmd, commandLabel, args);
			break;
		case "sendtestmessage":
			sendtestmessage(player,cmd,commandLabel,args);
			break;
		case "sendtestmessagetoall":
			sendtestmessagetoall(player,cmd,commandLabel,args);
			break;
		default:
			player.sendMessage("引数を指定してください。");
			return false;
		}
		return true;
	}

	

	



	private static void exec(Player player, Command cmd, String commandLabel, String[] args) {
		clear(player, cmd, commandLabel, args);
		player.sendMessage("変更中");
		if(args[1].equals("@a")) {
			DoppelAPI.doppelAll(args[2]);
		} else {
			try {
				DoppelAPI.doppel(UUID.fromString(args[1]),args[2]);
			} catch(IllegalArgumentException e) {
				DoppelAPI.doppel(Bukkit.getPlayer(args[1]).getUniqueId(),args[2]);
			}
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
	private static void clear(Player player,Command cmd,String commandLabel,String[] args) {
		player.sendMessage("変更中");
		if(args[1].equals("@a")) {
			DoppelAPI.clearAll();
		} else {
			try {
				DoppelAPI.clear(UUID.fromString(args[1]));
			} catch(IllegalArgumentException e) {
				DoppelAPI.clear(Bukkit.getPlayer(args[1]).getUniqueId());
			}
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
	private static void sendtestmessage(Player player, Command cmd, String commandLabel, String[] args) {
		SendMessageAPI.send(player,args[1]);
	}
	
	private static void sendtestmessagetoall(Player player, Command cmd, String commandLabel, String[] args) {
		SendMessageAPI.sendtoAll(args[1]);
	}
}
