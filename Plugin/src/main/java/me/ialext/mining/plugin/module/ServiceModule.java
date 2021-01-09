package me.ialext.mining.plugin.module;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.service.MiningService;
import me.ialext.mining.plugin.service.initializer.ListenerInitializer;
import me.ialext.mining.plugin.service.initializer.VaultInitializer;
import me.yushust.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Service.class).named("mining-service").to(MiningService.class).singleton();
    bind(Service.class).named("listener-initializer").to(ListenerInitializer.class).singleton();
    bind(Service.class).named("vault-initializer").to(VaultInitializer.class).singleton();
  }
}
