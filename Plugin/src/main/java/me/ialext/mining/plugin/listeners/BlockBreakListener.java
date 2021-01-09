package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.economy.EconomyOperations;
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
  @Inject private EconomyOperations economyOperations;
  @Inject
  @Named("config")
  private YamlFileCreator config;

  // TODO: 9/1/21 Cleanup code.
  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    double random = PercentageGenerator.newPercentage(100);
    userCache.find(player.getUniqueId()).ifPresent(user -> {
      user.getMinedBlocks().increment(1);
      double probability = config.getDouble("mining.percentage");
      double money = config.getDouble("mining.money");
      if (probability <= 50 && probability > 0) {
        if (random <= probability) {
          Bukkit.getPluginManager().callEvent(new UserGainMoneyEvent(user, money));
        }
      } else if (probability >= 50 && probability <= 100) {
        if (random >= probability) {
          Bukkit.getPluginManager().callEvent(new UserGainMoneyEvent(user, money));
        }
      }
      userObjectRepository.update(user);
    });
  }
}
