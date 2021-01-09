package me.ialext.mining.api.model;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * A data model which can be stored in {@link com.mongodb.client.MongoCollection}s
 * using its {@link ObjectId}.
 */
public interface Model {

  /**
   * Provides the {@link Model}'s {@link ObjectId}.
   *
   * @return the ID.
   */
  ObjectId getObjectId();

  /**
   * A kind of {@link Model} which is tracked via {@link Date},
   * when it is created and everytime it is updated.
   */
  interface Stamped extends Model {

    /**
     * Provides the {@link Model.Stamped} creation {@link Date}.
     *
     * @return The corresponding date.
     */
    Date getCreatedAt();

    /**
     * Provides the {@link Model.Stamped} last update {@link Date}.
     *
     * @return The corresponding date.
     */
    Date getLastUpdate();

  }
}
