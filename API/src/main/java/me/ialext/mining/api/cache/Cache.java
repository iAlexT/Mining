package me.ialext.mining.api.cache;

import java.util.Map;
import java.util.Optional;

/**
 * A temporal cache that uses a {@link Map} as repository.
 *
 * @param <K> The type of key stored in this {@link Cache}.
 * @param <V> The type of value stored in this {@link Cache}.
 */
public interface Cache<K, V> {

  /**
   * Provides the {@link Map} repository of this {@link Cache}.
   *
   * @return The repository {@link Map}.
   */
  Map<K, V> get();

  /**
   * Searches for an {@link V} keyed with the given {@link K}, and returns an {@link Optional} value.
   *
   * @param k The {@link V}'s key.
   * @return An {@link Optional} value of the {@link V}.
   * @see "{@link Map#get(Object)}"
   */
  default Optional<V> find(K k) {
    return Optional.ofNullable(get().get(k));
  }

  /**
   * Adds a {@link V} keyed with the given {@link K} to the {@link Map} repository.
   *
   * @param k The {@link V}'s key.
   * @param v The {@link V} keyed with the given {@link K}.
   * @see "{@link Map#put(Object, Object)}"
   */
  default void add(K k, V v) {
    get().put(k, v);
  }

  /**
   * Removes a {@link V} keyed with the given {@link K} from the {@link Map} repository.
   *
   * @param k The {@link V}'s key.
   * @see "{@link Map#remove(Object)}"
   */
  default void remove(K k) {
    get().remove(k);
  }

  /**
   * Checks if there's a {@link V} with the given {@link K} into the {@link Map} repository.
   *
   * @param k The {@link V}'s key.
   * @return True if present, otherwise false.
   * @see "{@link Map#containsKey(Object)}"
   */
  default boolean exists(K k) {
    return get().containsKey(k);
  }

  /**
   * Clears the {@link Map} repository.
   *
   * @see "{@link Map#clear()}"
   */
  default void clear() {
    get().clear();
  }

}
