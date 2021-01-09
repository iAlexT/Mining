package me.ialext.mining.plugin.module;

import me.ialext.mining.plugin.MiningPlugin;
import me.yushust.inject.AbstractModule;

public class MiningModule extends AbstractModule {

  private final MiningPlugin plugin;

  public MiningModule(MiningPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  protected void configure() {
    install(
        new DataModule(),
        new BukkitModule(plugin)
    );
  }
}
