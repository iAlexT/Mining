package me.ialext.mining.api.data.model;

import dev.morphia.annotations.Id;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
public class RawModelImpl implements Model {

  @Id private final ObjectId objectId;
  private final Date creationDate;
  @Setter private Date lastUpdate;

  public RawModelImpl(ObjectId objectId) {
    this.objectId = objectId;
    creationDate = new Date();
    lastUpdate = new Date();
  }

}
