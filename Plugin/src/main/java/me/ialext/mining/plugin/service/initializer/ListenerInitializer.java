package me.ialext.mining.plugin.service.initializer;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.listeners.*;
import me.ialext.mining.plugin.listeners.user.*;
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
  @Inject private UserGainMoneyListener userGainMoneyListener;
  @Inject private UseLoseMoneyListener userLoseMoneyListener;

  @Override
  public void initialize() {
    LoggingMessenger.info("Starting listener initializer...");
    registerListeners(
        playerJoinListener,
        playerQuitListener,
        blockBreakListener,
        blockPlaceListener,
        userGainMoneyListener,
        userLoseMoneyListener
    );
  }

  private void registerListeners(Listener... listeners) {
    for (Listener listener : listeners) {
      plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }
}
