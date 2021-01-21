package me.ialext.mining.api.data.model.binding;

import lombok.Getter;
import me.ialext.mining.api.data.model.Model;
import me.ialext.mining.api.data.model.annotation.ModelImplementation;
import me.yushust.inject.key.TypeReference;

import javax.inject.Inject;

public class ModelMeta<T extends Model> {

  @Getter private final Class<T> implementation;

  @SuppressWarnings("unchecked")
  @Inject
  public ModelMeta(TypeReference<T> type) {
    this.implementation = (Class<T>) type.getRawType().getAnnotation(ModelImplementation.class).value();
  }

}
