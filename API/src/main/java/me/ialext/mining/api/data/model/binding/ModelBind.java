package me.ialext.mining.api.data.model.binding;

import me.ialext.mining.api.data.MongoObjectRepository;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.data.model.Model;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.Binder;
import me.yushust.inject.key.TypeReference;

public class ModelBind<O extends Model> {
  private final TypeReference<O> modelReference;

  private ModelBind(Binder binder, TypeReference<O> modelReference) {
    this.modelReference = modelReference;
    binder.install(new PerModelModule());
  }

  public static <M extends Model> ModelBind<M> of(Binder binder, Class<M> clazz) {
    return of(binder, TypeReference.of(clazz));
  }

  public static <M extends Model> ModelBind<M> of(Binder binder, TypeReference<M> modelReference) {
    return new ModelBind<>(binder, modelReference);
  }

  /**
   * This class auto-binds {@link Model}s.
   * @see "{@link ModelMeta}."
   * @see "{@link me.ialext.mining.api.data.model.binding}."
   */
  private class PerModelModule extends AbstractModule {

    @Override
    protected void configure() {

      TypeReference<ModelMeta<O>> metaTypeReference = new ResolvableType<ModelMeta<O>>() {
      }.with(new TypeArgument<O>(modelReference) {
      });

      TypeReference<ObjectRepository<O>> objectRepositoryTypeReference = new ResolvableType<ObjectRepository<O>>() {
      }.with(new TypeArgument<O>(modelReference) {
      });

      TypeReference<MongoObjectRepository<O>> mongoObjectRepositoryTypeReference = new ResolvableType<MongoObjectRepository<O>>() {
      }.with(new TypeArgument<O>(modelReference) {
      });

      bind(metaTypeReference).singleton();
      bind(objectRepositoryTypeReference).to(mongoObjectRepositoryTypeReference).singleton();
    }
  }
}