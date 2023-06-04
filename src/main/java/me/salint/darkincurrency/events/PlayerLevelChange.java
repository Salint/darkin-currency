package me.salint.darkincurrency.events;

import me.salint.darkincurrency.ConfigHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerLevelChange {

	public PlayerLevelChange(PlayerLevelChangeEvent event, FileConfiguration config) {

		int coins = 0;
		Player player = event.getPlayer();
		if(event.getNewLevel() <= 10) {
			coins = 5;
		}
		else if(event.getNewLevel() <= 25){
			coins = 15;
		}
		else if(event.getNewLevel() <= 50){
			coins = 30;
		}
		else if(event.getNewLevel() <= 100){
			coins = 60;
		}
		else {
			coins = 100;
		}
		int oldCoins = ConfigHandler.getConfig().getInt("balance." + player.getName());
		ConfigHandler.getConfig().set("balance." + player.getName(), oldCoins + coins);
		ConfigHandler.saveConfig();


	}
}