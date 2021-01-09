package me.ialext.mining.api.model;

import dev.morphia.annotations.Id;
import me.ialext.mining.api.model.Model;
import org.bson.types.ObjectId;

public class SimpleModel implements Model {

  @Id private final ObjectId id;

  public SimpleModel(ObjectId id) {
    this.id = id;
  }

  @Override
  public ObjectId getObjectId() {
    return id;
  }
}
