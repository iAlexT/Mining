package me.ialext.mining.plugin.placeholder;

import me.ialext.mining.api.placeholder.PlaceholderApplier;
import me.ialext.mining.api.user.User;

import javax.inject.Inject;
import javax.inject.Named;

public class PlaceholderDecorator implements PlaceholderApplier {

  @Inject
  @Named("statistic-placeholder-applier")
  private PlaceholderApplier statisticPlaceholderApplier;


  @Override
  public String setPlaceholder(User user, String placeholder) {
    return statisticPlaceholderApplier.setPlaceholder(user, placeholder)
        .replace("%username%", user.getPlayer().getName());
  }
}
