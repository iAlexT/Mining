package me.ialext.mining.plugin.cache;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.user.User;

import javax.inject.Singleton;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class UserCache implements Cache<UUID, User> {

  private final Map<UUID, User> users = new ConcurrentHashMap<>();

  @Override
  public Map<UUID, User> get() {
    return users;
  }
}
