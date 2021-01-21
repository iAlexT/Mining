package me.ialext.mining.api.data.model.binding;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeToken;
import me.yushust.inject.key.TypeReference;

import java.lang.reflect.TypeVariable;

/**
 * A kind of {@link TypeReference} with some extra methods to resolve generic types.
 */
@SuppressWarnings("All")
public abstract class ResolvableType<T> extends TypeReference<T> {

  /**
   * Fully resolve this type in the context of the given type
   */
  public TypeReference<T> in(Class<?> declaringClass) {
    return Types.assertFullySpecified(Types.resolve(this, declaringClass));
  }

  /**
   * Fully resolve this type by substituting this type's formal type
   * parameters with the given actual type arguments
   */
  public TypeReference<T> with(TypeArgument<?>... arguments) {
    TypeToken<T> token = Types.toToken(this);
    for (TypeArgument arg : arguments) {
      token = token.where(arg, arg.actual());
    }
    return Types.assertFullySpecified(Types.toLiteral(token));
  }

  public <X> TypeReference<T> where(TypeParameter<X> parameter, TypeReference<X> type) {
    return where(parameter, Types.toToken(type));
  }

  public <X> TypeReference<T> where(TypeParameter<X> parameter, TypeToken<X> type) {
    return Types.toLiteral(Types.assertFullySpecified(Types.toToken(this).where(parameter, type)));
  }

  public TypeReference<T> where(String name, TypeReference<?> type) {
    return where(Types.typeVariable(getRawType(), name), type);
  }

  public TypeReference<T> where(String name, TypeToken<?> type) {
    return where(Types.typeVariable(getRawType(), name), type);
  }

  public TypeReference<T> where(TypeVariable<?> typeVariable, TypeReference<?> type) {
    final TypeResolver resolver = new TypeResolver().where(typeVariable, type.getType());
    return TypeReference.of(resolver.resolveType(getType()));
  }

  public TypeReference<T> where(TypeVariable<?> typeVariable, TypeToken<?> type) {
    final TypeResolver resolver = new TypeResolver().where(typeVariable, type.getType());
    return TypeReference.of(resolver.resolveType(getType()));
  }

  /**
   * Fully resolve the given type in the context of this type
   */
  public <U> TypeReference<U> resolve(TypeReference<U> type) {
    return Types.assertFullySpecified(Types.resolve(type, getRawType()));
  }
}