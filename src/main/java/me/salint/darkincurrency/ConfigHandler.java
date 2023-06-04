package me.salint.darkincurrency;

import me.salint.darkincurrency.interfaces.Func;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {

	private static FileConfiguration config;
	private static Func saveFunc;

	public static void setConfig(FileConfiguration method) {
		config = method;
	}
	public static void setSaveFunc(Func func) {
		saveFunc = func;
	}
	public static FileConfiguration getConfig() {
		return config;
	}
	public static void saveConfig() {
		saveFunc.run();
	}

}
