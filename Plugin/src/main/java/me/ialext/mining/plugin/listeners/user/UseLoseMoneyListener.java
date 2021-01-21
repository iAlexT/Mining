package me.ialext.mining.plugin.listeners.user;

import me.ialext.mining.api.economy.VaultWrapper;
import me.ialext.mining.api.event.UserLoseMoneyEvent;
import me.ialext.mining.api.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.inject.Inject;

public class UseLoseMoneyListener implements Listener {

  @Inject
  private VaultWrapper vaultWrapper;

  @EventHandler
  public void onUserLoseMoney(UserLoseMoneyEvent event) {
    User user = event.getUser();
    vaultWrapper.withdraw(user.getPlayer(), event.getAmount());
  }
}
