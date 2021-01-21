package me.ialext.mining.plugin.listeners.user;

import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.economy.VaultWrapper;
import me.ialext.mining.api.event.UserGainMoneyEvent;
import me.ialext.mining.api.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.inject.Inject;

public class UserGainMoneyListener implements Listener {

  @Inject private VaultWrapper vaultWrapper;
  @Inject private ObjectRepository<User> userObjectRepository;

  @EventHandler
  public void onUserGainMoney(UserGainMoneyEvent event) {
    User user = event.getUser();
    user.getWonMoney().increment(event.getAmount());
  }
}
