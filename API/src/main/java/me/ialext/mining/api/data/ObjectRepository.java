package me.ialext.mining.api.data;

import com.google.common.util.concurrent.ListenableFuture;
import me.ialext.mining.api.model.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Represents the access to an Object Repository,
 * such as a Database, a flat-file, and so on.
 *
 * @param <O> The object to be stored.
 */
public interface ObjectRepository<O extends Model> {

  /**
   * Searches for an {@link O} in the {@link ObjectRepository} using its {@link org.bson.types.ObjectId} {@link String}.
   * @param id The {@link O}'s {@link org.bson.types.ObjectId} {@link String}.
   * @return An {@link Optional} value of {@link O}, taken from the {@link ObjectRepository}.
   */
  ListenableFuture<Optional<O>> findOne(String id);

  /**
   * Searches for a list of {@link O}s in the {@link ObjectRepository} that shares the {@link org.bson.types.ObjectId}.
   * @param ids The {@link org.bson.types.ObjectId}'s {@link String}.
   * @return A {@link List} of {@link Optional} values of {@link O}, taken from the {@link ObjectRepository}.
   */
  ListenableFuture<List<Optional<O>>> find(List<String> ids);

  /**
   * @see #find(List)
   */
  default ListenableFuture<List<Optional<O>>> find(String... ids) {
    return find(Arrays.asList(ids));
  }

  /**
   * Searches for a list of {@link O}s in a limited range using {@link com.mongodb.client.FindIterable}.
   * @param limit The limit of the search. Wraps {@link com.mongodb.client.FindIterable#limit(int)}
   * @param skip The number of {@link O}s that will be skipped. Wraps {@link com.mongodb.client.FindIterable#skip(int)}
   * @return A list of {@link O}s.
   */
  ListenableFuture<List<O>> find(int limit, int skip);

  /**
   * @see #find(int, int)
   */
  default ListenableFuture<List<O>> find(int limit) {
    return find(limit, 0);
  }

  /**
   * @see #find(int)
   */
  default ListenableFuture<List<O>> find() {
    return find(Integer.MAX_VALUE);
  }

  ListenableFuture<Void> update(O o);

  ListenableFuture<Void> save(O o);

  ListenableFuture<Void> delete(O o);

}
