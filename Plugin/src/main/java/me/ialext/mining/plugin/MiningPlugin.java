package me.ialext.mining.plugin;

import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.module.MiningModule;
import me.yushust.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Named;

public final class MiningPlugin extends JavaPlugin {

  @Inject
  @Named("mining-service")
  private Service miningService;

  @Override
  public void onEnable() {
    Injector injector = Injector.create(new MiningModule(this));
    injector.injectMembers(this);

    miningService.initialize();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
