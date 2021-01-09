package me.ialext.mining.plugin.economy;

import me.ialext.mining.api.economy.EconomyOperations;
import me.ialext.mining.plugin.hook.VaultHook;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultEconomyOperations implements EconomyOperations {

  @Inject
  private VaultHook vaultHook;

  @Override
  public void deposit(Player player, double amount) {
    vaultHook.getEconomy().depositPlayer(player, amount);
  }

  @Override
  public void withdraw(Player player, double amount) {
    vaultHook.getEconomy().withdrawPlayer(player, amount);
  }

  @Override
  public double getBalance(Player player) {
    return vaultHook.getEconomy().getBalance(player);
  }
}
