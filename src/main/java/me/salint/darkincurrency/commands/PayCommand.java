package me.salint.darkincurrency.commands;

import me.salint.darkincurrency.ConfigHandler;
import me.salint.darkincurrency.utils.Integer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PayCommand implements TabExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player player)) return true;

		if(args.length < 2) {
			player.sendMessage(ChatColor.RED + "[ERROR] Incorrect Usage.");
			player.sendMessage(ChatColor.GOLD + "USAGE: /" + label + " [player] [money]");
		}
		else {
			Player target = Bukkit.getPlayerExact(args[0]);
			if(target == null) {
				player.sendMessage(ChatColor.RED + "[ERROR] User is not online.");
			}
			else if (target.getName().equals(player.getName())) {
				player.sendMessage(ChatColor.RED + "[ERROR] You can't pay yourself.");
			}
			else {

				double xDiff = Math.pow(player.getLocation().getX() - target.getLocation().getX(), 2);
				double yDiff = Math.pow(player.getLocation().getY() - target.getLocation().getY(), 2);
				double zDiff = Math.pow(player.getLocation().getZ() - target.getLocation().getZ(), 2);

				if(Math.sqrt(xDiff + yDiff + zDiff) > 10) {
					player.sendMessage(ChatColor.RED + "[ERROR] User needs to be in 10-block range.");
				}

				else {
					if(Integer.isInteger(args[1])) {
						player.sendMessage(ChatColor.RED + "[ERROR] Please enter a valid amount.");
					}
					if(Integer.parseInt(args[1]) <= 0) {
						player.sendMessage(ChatColor.RED + "[ERROR] Amount has to be greater than 0.");
					}
					else {
						int balance = ConfigHandler.getConfig().getInt("balance." + player.getName());
						if(balance < Integer.parseInt(args[1])) {
							player.sendMessage(ChatColor.RED + "[ERROR] Insufficient funds.");
						}
						else {
							int targetBalance = ConfigHandler.getConfig().getInt("balance." + target.getName());

							ConfigHandler.getConfig().set("balance." + player.getName(), balance - Integer.parseInt(args[1]));
							ConfigHandler.getConfig().set("balance." + target.getName(), targetBalance + Integer.parseInt(args[1]));
							ConfigHandler.saveConfig();

							player.sendMessage(ChatColor.GREEN + "[DARKIN CURRENCY] You paid " + target.getName() + " " + Integer.parseInt(args[1]) +  " Darkin coins!");
							player.sendMessage(ChatColor.GREEN + "[DARKIN CURRENCY] " + player.getName() + " paid you " + Integer.parseInt(args[1]) + " Darkin coins!");



						}
					}
				}
			}
		}

		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		List<String> completions = new ArrayList<String>();
		if(args.length == 1) {
			Collection<? extends Player> players = Bukkit.getOnlinePlayers();

			for(Player player : players) {
				completions.add(player.getName());
			}
		}
		return completions;
	}
}
