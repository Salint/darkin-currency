package me.salint.darkincurrency.listeners;

import me.salint.darkincurrency.ConfigHandler;
import me.salint.darkincurrency.events.PlayerLevelChange;
import me.salint.darkincurrency.events.PlayerJoin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class EventListener implements Listener {

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
		new PlayerJoin(event, ConfigHandler.getConfig());
	}
	@EventHandler
	public void OnPlayerLevelChange(PlayerLevelChangeEvent event) {
		new PlayerLevelChange(event, ConfigHandler.getConfig());
	}


}
