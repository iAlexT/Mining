package me.ialext.mining.plugin.module;

import me.ialext.mining.api.economy.EconomyOperations;
import me.ialext.mining.plugin.economy.DefaultEconomyOperations;
import me.yushust.inject.AbstractModule;

public class EconomyModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(EconomyOperations.class).to(DefaultEconomyOperations.class).singleton();
  }
}
