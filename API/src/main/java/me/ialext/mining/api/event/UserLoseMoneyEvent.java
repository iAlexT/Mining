package me.ialext.mining.api.event;

import lombok.Getter;
import me.ialext.mining.api.user.User;
import org.bukkit.event.HandlerList;

/**
 * Event triggered whenever an {@link User} loses money.
 */
public class UserLoseMoneyEvent extends UserEvent {

  private static final HandlerList HANDLER_LIST = new HandlerList();

  @Getter private final double amount;

  public UserLoseMoneyEvent(User user, double amount) {
    super(user);
    this.amount = amount;
  }

  @Override
  public HandlerList getHandlers() {
    return HANDLER_LIST;
  }

  public static HandlerList getHandlerList() {
    return HANDLER_LIST;
  }
}
