package me.salint.darkincurrency;

import me.salint.darkincurrency.interfaces.Func;
import me.salint.darkincurrency.listeners.CommandListener;
import me.salint.darkincurrency.listeners.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		Func saveFunc = this::saveConfig;

		ConfigHandler.setConfig(getConfig());
		ConfigHandler.setSaveFunc(saveFunc);

		Bukkit.getLogger().info("***********************************");
		Bukkit.getLogger().info("*        Darkin Currency v1.0     *");
		Bukkit.getLogger().info("*            by Salint            *");
		Bukkit.getLogger().info("***********************************");

		Bukkit.getPluginManager().registerEvents(new EventListener(), this);

		new CommandListener(this);
	}

}