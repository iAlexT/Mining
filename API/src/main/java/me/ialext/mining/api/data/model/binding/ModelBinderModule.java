package me.ialext.mining.api.data.model.binding;

import me.ialext.mining.api.data.model.Model;
import me.yushust.inject.Binder;
import me.yushust.inject.key.TypeReference;

import java.util.function.Consumer;

/**
 * A custom {@link Binder} special for {@link Model}s.
 */
public interface ModelBinderModule {

  Binder getBinder();

  default <M extends Model> ModelBind<M> bindModel(Class<M> clazz) {
    return ModelBind.of(getBinder(), clazz);
  }

  default <M extends Model> ModelBind<M> bindModel(TypeReference<M> typeReference) {
    return ModelBind.of(getBinder(), typeReference);
  }

  default <M extends Model> void bindModel(Class<M> clazz, Consumer<ModelBind<M>> consumer) {
    consumer.accept(ModelBind.of(getBinder(), clazz));
  }

  default <M extends Model> void bindModel(TypeReference<M> typeReference, Consumer<ModelBind<M>> consumer) {
    consumer.accept(ModelBind.of(getBinder(), typeReference));
  }
}
