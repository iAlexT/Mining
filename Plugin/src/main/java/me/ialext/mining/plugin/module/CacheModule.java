package me.ialext.mining.plugin.module;

import me.ialext.mining.api.cache.Cache;
import me.ialext.mining.api.user.User;
import me.ialext.mining.plugin.cache.UserCache;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.key.TypeReference;

import java.util.UUID;

public class CacheModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TypeReference.of(Cache.class, UUID.class, User.class)).to(UserCache.class);
  }
}
