package me.ialext.mining.api.user;

import dev.morphia.annotations.Entity;
import lombok.Getter;
import me.ialext.mining.api.model.SimpleStampedModel;
import me.ialext.mining.api.statistic.FloatStatistic;
import me.ialext.mining.api.statistic.IntegerStatistic;
import org.bson.types.ObjectId;

import java.util.UUID;

@Entity(value = "users", noClassnameStored = true)
public class SimpleUser extends SimpleStampedModel implements User {

  private final String uuid;
  @Getter private final IntegerStatistic minedBlocks;
  @Getter private final FloatStatistic wonMoney;

  public SimpleUser(UUID uuid, IntegerStatistic minedBlocks, FloatStatistic wonMoney) {
    super(new ObjectId());
    this.uuid = uuid.toString();
    this.minedBlocks = minedBlocks;
    this.wonMoney = wonMoney;
  }

  // Constructor required for Morphia mapping.
  public SimpleUser() {
    super(new ObjectId());
    this.uuid = "";
    this.minedBlocks = new IntegerStatistic();
    this.wonMoney = new FloatStatistic();
  }

  @Override
  public UUID getUuid() {
    return UUID.fromString(uuid);
  }
}
