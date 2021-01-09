package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.data.Filter;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.statistic.FloatStatistic;
import me.ialext.mining.api.statistic.IntegerStatistic;
import me.ialext.mining.api.user.User;
import me.ialext.mining.api.user.SimpleUser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PlayerJoinListener implements Listener {

  @Inject private Cache<UUID, User> userCache;
  @Inject private ObjectRepository<User> userObjectRepository;

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) throws ExecutionException, InterruptedException {
    Player player = event.getPlayer();
    Optional<User> optionalUser = userObjectRepository.findOneByQuery(Filter.create().set("uuid", player.getUniqueId().toString())).get().stream().findAny();

    User user;
    if (!optionalUser.isPresent()) {
      user = new SimpleUser();
      userObjectRepository.save(user);
    } else {
      user = optionalUser.get();
    }
    userCache.add(player.getUniqueId(), user);
  }
}
