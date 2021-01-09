package me.ialext.mining.plugin.placeholder;

import me.ialext.mining.api.placeholder.PlaceholderApplier;
import me.ialext.mining.api.user.User;

public class StatisticPlaceholderApplier implements PlaceholderApplier {

  @Override
  public String setPlaceholder(User user, String placeholder) {
    return placeholder
        .replace("%mined_blocks%", String.valueOf(user.getMinedBlocks().get()))
        .replace("%won_money%", String.valueOf(user.getWonMoney().get()));
  }
}
