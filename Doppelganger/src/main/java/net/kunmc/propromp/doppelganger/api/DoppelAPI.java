package net.kunmc.propromp.doppelganger.api;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickManager;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

public class DoppelAPI {
	public static void doppel(UUID uuid,String owner) {
		NickManager pnm = NickNamerAPI.getNickManager();
		pnm.setSkin(uuid, owner);
		pnm.setNick(uuid, owner);
	}
	public static void clear(UUID uuid) {
		NickManager pnm = NickNamerAPI.getNickManager();
		pnm.removeNick(uuid);
		pnm.removeSkin(uuid);
	}
	public static void doppelAll(String owner) {
		Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
		players = Bukkit.getOnlinePlayers().toArray(players);
		System.out.println(Bukkit.getOnlinePlayers().size());
		System.out.println(players.length);
		for(int i = 0; i < players.length; i ++) {
			doppel(players[i].getUniqueId(),owner);
		}
	}
	public static void clearAll() {
		Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
		players = Bukkit.getOnlinePlayers().toArray(players);
		for(int i = 0; i < players.length; i ++) {
			clear(players[i].getUniqueId());
		}
	}
}
