package me.ialext.mining.api.economy;

import org.bukkit.entity.Player;

public interface VaultWrapper {

  void deposit(Player player, double amount);

  void withdraw(Player player, double amount);

  double getBalance(Player player);


}
