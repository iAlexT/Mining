package me.ialext.mining.plugin.user;

import lombok.Getter;
import me.ialext.mining.api.statistic.FloatStatistic;
import me.ialext.mining.api.statistic.IntegerStatistic;
import me.ialext.mining.api.user.User;
import org.bson.types.ObjectId;

import java.util.UUID;

public class SimpleUser implements User {

  @Getter
  private final ObjectId objectId;
  @Getter
  private final UUID uuid;
  @Getter
  private final IntegerStatistic minedBlocks;
  @Getter
  private final FloatStatistic wonMoney;

  public SimpleUser(UUID uuid, IntegerStatistic minedBlocks, FloatStatistic wonMoney) {
    this.uuid = uuid;
    this.minedBlocks = minedBlocks;
    this.wonMoney = wonMoney;
    this.objectId = new ObjectId(uuid.toString());
  }

}
