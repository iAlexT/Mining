package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class PlayerQuitListener implements Listener {

  @Inject private ObjectRepository<User> userObjectRepository;
  @Inject private Cache<UUID, User> userCache;

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    userCache.find(player.getUniqueId()).ifPresent(user -> {
      userObjectRepository.update(user);
      userCache.remove(player.getUniqueId());
    });
  }
}
