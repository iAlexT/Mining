package me.ialext.mining.plugin.service.initializer;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.listeners.BlockBreakListener;
import me.ialext.mining.plugin.listeners.BlockPlaceListener;
import me.ialext.mining.plugin.listeners.PlayerJoinListener;
import me.ialext.mining.plugin.listeners.PlayerQuitListener;
import me.ialext.mining.plugin.util.message.LoggingMessenger;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;

public class ListenerInitializer implements Service {

  @Inject private JavaPlugin plugin;

  @Inject private PlayerJoinListener playerJoinListener;
  @Inject private PlayerQuitListener playerQuitListener;
  @Inject private BlockBreakListener blockBreakListener;
  @Inject private BlockPlaceListener blockPlaceListener;

  @Override
  public void initialize() {
    LoggingMessenger.info("Starting listener initializer...");
    registerListeners(
        playerJoinListener,
        playerQuitListener,
        blockBreakListener,
        blockPlaceListener
    );
  }

  private void registerListeners(Listener... listeners) {
    for (Listener listener : listeners) {
      plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }
}
