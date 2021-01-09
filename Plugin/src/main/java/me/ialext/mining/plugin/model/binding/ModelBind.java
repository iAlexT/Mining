package me.ialext.mining.plugin.model.binding;

import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.model.Model;
import me.ialext.mining.plugin.data.MongoObjectRepository;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.Binder;
import me.yushust.inject.key.TypeReference;
/*
public class ModelBind<C extends Model> {

    private final TypeReference<C> completeTypeLiteral;

    public static <M extends Model> ModelBind<M, M> of(Binder binder, Class<M> M) {
        return of(binder, M, M);
    }

    public static <M extends Model> ModelBind<M, M> of(Binder binder, TypeReference<M> M) {
        return of(binder, M, M);
    }

    public static <M extends Model> ModelBind<M, P> of(Binder binder, Class<M> M) {
        return of(binder, TypeReference.of(M));
    }

    public static <M extends Model, P extends PartialModel> ModelBind<M, P> of(Binder binder, TypeReference<M> M, TypeReference<P> P) {
        return new ModelBind<>(binder, M, P);
    }

    private ModelBind(Binder binder, TypeReference<Complete> completeTypeLiteral, TypeReference<Partial> partialTypeLiteral) {
        this.completeTypeLiteral = completeTypeLiteral;
        this.partialTypeLiteral = partialTypeLiteral;
        binder.install(new PerModel());
    }

    private class PerModel extends AbstractModule {

        @Override
        protected void configure() {

            final TypeReference<ModelMeta<Complete>> meta = new ResolvableType<ModelMeta<Complete>>(){}.with(
                    new TypeArgument<Complete>(ModelBind.this.completeTypeLiteral) {}
            );

            final TypeReference<StorageService<Complete, Partial>> storage = new ResolvableType<StorageService<Complete, Partial>>() {}.with(
                    new TypeArgument<Complete>(ModelBind.this.completeTypeLiteral) {},
                    new TypeArgument<Partial>(ModelBind.this.partialTypeLiteral) {}
            );

            final TypeReference<MongoStorageService<Complete, Partial>> storageImpl = new ResolvableType<MongoStorageService<Complete, Partial>>() {}.with(
                    new TypeArgument<Complete>(ModelBind.this.completeTypeLiteral) {},
                    new TypeArgument<Partial>(ModelBind.this.partialTypeLiteral) {}
            );


            bind(meta).in(Scopes.SINGLETON);
            bind(storage).to(storageImpl).in(Scopes.SINGLETON);
        }
    }
}*/

public class ModelBind<O extends Model> {
  private final TypeReference<O> modelReference;

  private ModelBind(Binder binder, TypeReference<O> modelReference) {
    this.modelReference = modelReference;
  }

  public ModelBind(TypeReference<O> modelReference) {
    this.modelReference = modelReference;
  }

  public static <M extends Model> ModelBind<M> of(Binder binder, Class<M> clazz) {
    return of(binder, TypeReference.of(clazz));
  }

  public static <M extends Model> ModelBind<M> of(Binder binder, TypeReference<M> modelReference) {
    return new ModelBind<M>(binder, modelReference);
  }

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