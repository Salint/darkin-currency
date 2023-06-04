package me.salint.darkincurrency.listeners;

import me.salint.darkincurrency.commands.BalanceCommand;
import me.salint.darkincurrency.commands.PayCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandListener {

	@SuppressWarnings("all")
	public CommandListener(JavaPlugin plugin) {
		plugin.getCommand("balance").setExecutor(new BalanceCommand());
		plugin.getCommand("pay").setExecutor(new PayCommand());

		plugin.getCommand("pay").setTabCompleter(new PayCommand());
	}

}
