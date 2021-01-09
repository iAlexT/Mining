package me.ialext.mining.plugin.module;

import me.ialext.mining.plugin.MiningPlugin;
import me.yushust.inject.AbstractModule;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitModule extends AbstractModule {

  private final MiningPlugin plugin;

  public BukkitModule(MiningPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  protected void configure() {
    bind(JavaPlugin.class).to(MiningPlugin.class).singleton();
    bind(Plugin.class).to(MiningPlugin.class).singleton();
    bind(MiningPlugin.class).toInstance(plugin);
  }
}
