package me.ialext.mining.plugin.service;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.util.message.LoggingMessenger;

import javax.inject.Inject;
import javax.inject.Named;

public class MiningService implements Service {

  @Inject
  @Named("listener-initializer")
  private Service listenerInitializer;

  @Inject
  @Named("vault-initializer")
  private Service vaultInitializer;

  @Override
  public void initialize() {
    LoggingMessenger.info("Starting Mining service...");
    listenerInitializer.initialize();
    vaultInitializer.initialize();
  }

}
