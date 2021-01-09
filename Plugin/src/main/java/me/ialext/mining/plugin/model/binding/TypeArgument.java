package me.ialext.mining.plugin.model.binding;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import me.yushust.inject.key.TypeReference;

/**
 * A {@link TypeParameter} that contains an actual type argument for itself.
 * Useful for passing a param -> arg mapping around as a single object.
 */
@SuppressWarnings("all")
public abstract class TypeArgument<T> extends TypeParameter<T> {

  private final TypeToken<? extends T> actual;

  public TypeArgument(TypeToken<? extends T> actual) {
    this.actual = actual;
  }

  public TypeArgument(TypeReference<? extends T> actual) {
    this(Types.toToken(actual));
  }

  public TypeArgument(Class<? extends T> actual) {
    this(TypeToken.of(actual));
  }

  public TypeToken<? extends T> actual() {
    return actual;
  }
}