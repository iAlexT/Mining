package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.economy.VaultWrapper;
import me.ialext.mining.api.event.UserGainMoneyEvent;
import me.ialext.mining.api.user.User;
import me.ialext.mining.plugin.file.YamlFileCreator;
import me.ialext.mining.plugin.util.PercentageGenerator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

public class BlockBreakListener implements Listener {

  @Inject private ObjectRepository<User> userObjectRepository;
  @Inject private Cache<UUID, User> userCache;
  @Inject private VaultWrapper vaultWrapper;
  @Inject
  @Named("config")
  private YamlFileCreator config;

  // TODO: 9/1/21 Cleanup code.
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();

  }
}
