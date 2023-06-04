package me.salint.darkincurrency.commands;

import me.salint.darkincurrency.ConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player player)) return true;

		int balance = ConfigHandler.getConfig().getInt("balance." + player.getName());
		player.sendMessage(ChatColor.RED + "[DARKIN CURRENCY] " + ChatColor.GOLD + "You have " + balance + " Darkin coins in your balance.");

		return true;
	}
}
