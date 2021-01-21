package me.ialext.mining.api.user;

import dev.morphia.annotations.Entity;
import lombok.Getter;
import me.ialext.mining.api.data.model.RawModelImpl;
import me.ialext.mining.api.statistic.DoubleStatistic;
import me.ialext.mining.api.statistic.IntegerStatistic;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
@Entity(value = "users", noClassnameStored = true)
public class SimpleUser extends RawModelImpl implements User {

  private UUID uuid;
  IntegerStatistic minedBlocks;
  DoubleStatistic wonMoney;

  public SimpleUser(UUID uuid, IntegerStatistic minedBlocks, DoubleStatistic wonMoney) {
    super(new ObjectId());
    this.uuid = uuid;
    this.minedBlocks = minedBlocks;
    this.wonMoney = wonMoney;
  }

  // Constructor required for Morphia mapping.
  private SimpleUser() {
    super(new ObjectId());
  }

  @Override
  public UUID getId() {
    return uuid;
  }
}
