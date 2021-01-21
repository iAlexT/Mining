package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.economy.VaultWrapper;
import me.ialext.mining.api.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.inject.Inject;
import java.util.UUID;

public class BlockPlaceListener implements Listener {

  @Inject private ObjectRepository<User> userObjectRepository;
  @Inject private Cache<UUID, User> userCache;
  @Inject private VaultWrapper vaultWrapper;

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    Player player = event.getPlayer();
    userCache.find(player.getUniqueId()).ifPresent(user -> {
      vaultWrapper.withdraw(player, 100);
      player.sendMessage("Withdrew 100 by placing a block");
    });
  }
}
