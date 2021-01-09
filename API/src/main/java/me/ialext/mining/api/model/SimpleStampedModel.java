package me.ialext.mining.api.model;

import lombok.Getter;
import lombok.Setter;
import me.ialext.mining.api.model.Model;
import org.bson.types.ObjectId;

import java.util.Date;

public class SimpleStampedModel extends SimpleModel implements Model.Stamped {

  @Getter
  @Setter
  private Date createdAt;

  @Setter
  @Getter
  private Date lastUpdate;

  public SimpleStampedModel(ObjectId id) {
    super(id);
  }

}
