package net.kunmc.propromp.doppelganger.api;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.Packet;
import net.minecraft.server.v1_15_R1.PacketPlayOutChat;

public class SendMessageAPI {
	public static void sendtoAll(String message) {
		Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
		players = Bukkit.getOnlinePlayers().toArray(players);
		for(Player player:players) {
			SendMessageAPI.send(player, message);
		}
	}
	@SuppressWarnings("rawtypes")
	public static void send(Player player,String message) {
		try {
			IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a(ChatColor.translateAlternateColorCodes('&', "{\"text\":\""+message+"\"}"));
			PacketPlayOutChat chat = new PacketPlayOutChat(icbc);
			(((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)chat);
		
		} catch(Exception e) {
			System.out.println("[DoppelGanger] error");
			e.printStackTrace();
		}
	}
}
