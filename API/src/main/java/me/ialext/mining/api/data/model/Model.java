package me.ialext.mining.api.data.model;

import org.bson.types.ObjectId;

import java.util.Date;

public interface Model {

  ObjectId getObjectId();

  Date getCreationDate();

  Date getLastUpdate();

  void setLastUpdate(Date lastUpdate);

}
