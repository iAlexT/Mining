package me.ialext.mining.plugin.model.binding;

import me.ialext.mining.api.model.Model;
import me.ialext.mining.api.model.annotation.MaterializeClass;
import me.yushust.inject.key.TypeReference;

import javax.inject.Inject;

public class ModelMeta<T extends Model> {

  private final Class<T> serializable;

  @SuppressWarnings("unchecked")
  @Inject
  public ModelMeta(TypeReference<T> completeType) {
    this.serializable = (Class<T>) completeType.getRawType().getAnnotation(MaterializeClass.class).value();
  }

  public Class<T> getSerializable() {
    return serializable;
  }

}
