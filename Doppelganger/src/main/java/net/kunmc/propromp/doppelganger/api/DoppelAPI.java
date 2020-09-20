package net.kunmc.propromp.doppelganger.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickManager;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

public class DoppelAPI {
	private static Map<Player,String> doppeler = new HashMap<>();
	public static void doppel(UUID uuid,String owner) {
		doppeler.put(Bukkit.getPlayer(uuid), owner);
		NickManager pnm = NickNamerAPI.getNickManager();
		pnm.setSkin(uuid, owner);
		pnm.setNick(uuid, owner);
		System.out.println("a");
	}
	public static void clear(UUID uuid) {
		doppeler.put(Bukkit.getPlayer(uuid), null);
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
		for(Player player:players) {
			clear(player.getUniqueId());
		}
	}
	public static String getDoppeler(Player player) {
		return doppeler.get(player);
	}
}
