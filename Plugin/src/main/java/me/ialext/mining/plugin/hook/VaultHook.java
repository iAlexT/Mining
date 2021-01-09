package me.ialext.mining.plugin.hook;

import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

import static me.ialext.mining.plugin.util.message.LoggingMessenger.severe;

@Singleton
public class VaultHook {

  @Inject
  private JavaPlugin plugin;

  @Getter
  private Economy economy;

  public void hook() {
    if (!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
      severe("The plugin Vault was not found, disabling plugin...");
      Bukkit.getPluginManager().disablePlugin(plugin);

      return;
    }


    RegisteredServiceProvider<Economy> provider = Bukkit.getServicesManager().getRegistration(Economy.class);
    if (provider == null) {
      severe("The plugin vault was found, but an exception has occurred with its service, disabling plugin...");
      Bukkit.getPluginManager().disablePlugin(plugin);
      return;
    }

    economy = provider.getProvider();
  }

}
