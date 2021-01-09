package me.ialext.mining.plugin.service.initializer;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.hook.VaultHook;
import me.ialext.mining.plugin.util.message.LoggingMessenger;

import javax.inject.Inject;

public class VaultInitializer implements Service {

  @Inject
  private VaultHook vaultHook;

  @Override
  public void initialize() {
    LoggingMessenger.info("Starting Vault initializer...");
    vaultHook.hook();
  }
}
