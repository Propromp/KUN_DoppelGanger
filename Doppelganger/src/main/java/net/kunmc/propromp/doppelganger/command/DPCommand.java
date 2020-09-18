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

import net.kunmc.propromp.doppelganger.api.DoppelAPI;

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
		if(args[1].equals("@a")) {
			DoppelAPI.doppelAll(args[2]);
		} else {
			DoppelAPI.doppel(UUID.fromString(args[1]),args[2]);
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
	private static void clear(Player player,Command cmd,String commandLabel,String[] args) {
		player.sendMessage("変更中");
		if(args[1].equals("@a")) {
			DoppelAPI.clearAll();
		} else {
			DoppelAPI.clear(UUID.fromString(args[1]));
		}
		player.sendMessage("[DoppelGanger]処理が完了しました。スキン、ニックネームの適用には時間が掛かる可能性があります。");
	}
}
