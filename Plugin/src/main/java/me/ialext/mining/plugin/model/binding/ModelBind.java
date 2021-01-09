package me.ialext.mining.plugin.model.binding;

import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.model.Model;
import me.ialext.mining.plugin.data.MongoObjectRepository;
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
   * @see "{@link me.ialext.mining.plugin.model.binding}."
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