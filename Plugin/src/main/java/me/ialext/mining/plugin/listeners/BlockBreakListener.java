package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.economy.EconomyOperations;
import me.ialext.mining.api.user.User;
import me.ialext.mining.plugin.util.PercentageGenerator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.UUID;

public class BlockBreakListener implements Listener {

  @Inject private ObjectRepository<User> userObjectRepository;
  @Inject private Cache<UUID, User> userCache;
  @Inject private JavaPlugin plugin;
  @Inject private EconomyOperations economyOperations;

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    double random = PercentageGenerator.newPercentage(100);
    userCache.find(player.getUniqueId()).ifPresent(user -> {
      user.getMinedBlocks().increment(1);
      double probability = plugin.getConfig().getDouble("mining.percentage");
      if (probability <= 50 && probability > 0) {
        if (random <= probability) {
          economyOperations.deposit(player, 500);
          player.sendMessage("Deposited 500 by reached a percentage lower than 50");
          user.getWonMoney().increment(500);
        }
      } else if (probability >= 50 && probability <= 100) {
        if (random >= probability) {
          economyOperations.deposit(player, 500);
          player.sendMessage("Deposited 500 by reached a percentage bigger than 50");
          user.getWonMoney().increment(500);
        }
      }
      userObjectRepository.update(user);
    });
  }
}
