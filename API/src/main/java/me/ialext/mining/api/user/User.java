package me.ialext.mining.api.user;

import me.ialext.mining.api.data.model.Model;
import me.ialext.mining.api.data.model.annotation.ModelImplementation;
import me.ialext.mining.api.statistic.DoubleStatistic;
import me.ialext.mining.api.statistic.IntegerStatistic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;


/**
 * Represents a custom {@link Player} which contains some extra methods.
 */
@ModelImplementation(SimpleUser.class)
public interface User extends Model {

  /**
   * Provides the {@link User}'s {@link UUID}.
   *
   * @return The UUID.
   */
  UUID getId();

  /**
   * Provides the {@link User}'s mined blocks {@link me.ialext.mining.api.statistic.Statistic}.
   *
   * @return The mined blocks statistic.
   */
  IntegerStatistic getMinedBlocks();

  /**
   * Provides the {@link User}'s won money {@link me.ialext.mining.api.statistic.Statistic}.
   *
   * @return THe won money statistic.
   */
  DoubleStatistic getWonMoney();

  /**
   * Provides the {@link User}'s Bukkit {@link Player}.
   *
   * @return The Bukkit Player.
   */
  default Player getPlayer() {
    return Bukkit.getPlayer(getId());
  }

}
