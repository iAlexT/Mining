package me.ialext.mining.plugin.module;

import me.ialext.mining.api.economy.VaultWrapper;
import me.ialext.mining.plugin.economy.DefaultVaultWrapper;
import me.yushust.inject.AbstractModule;

public class EconomyModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(VaultWrapper.class).to(DefaultVaultWrapper.class).singleton();
  }
}
