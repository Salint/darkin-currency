package me.salint.darkincurrency.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin {

	public PlayerJoin(PlayerJoinEvent event, FileConfiguration config) {
		Player player = event.getPlayer();

		int balance = config.getInt("balance." + player.getName());
		player.sendMessage(ChatColor.RED + "[DARKIN CURRENCY] " + ChatColor.GOLD + "You have " + balance + " Darkin coins in your balance.");
	}
}