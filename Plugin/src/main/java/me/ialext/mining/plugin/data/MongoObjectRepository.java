package me.ialext.mining.plugin.data;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import dev.morphia.Datastore;
import me.ialext.mining.api.data.ObjectRepository;
import me.ialext.mining.api.model.Model;
import me.ialext.mining.plugin.model.SimpleStampedModel;
import me.ialext.mining.plugin.model.binding.ModelMeta;
import org.bson.types.ObjectId;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MongoObjectRepository<O extends Model> implements ObjectRepository<O> {

  private final JavaPlugin plugin;
  private final ListeningExecutorService executorService;
  private final ModelMeta<O> modelMeta;
  private final Datastore datastore;

  @Inject
  public MongoObjectRepository(JavaPlugin plugin, ListeningExecutorService executorService, ModelMeta<O> modelMeta, Datastore datastore) {
    this.plugin = plugin;
    this.executorService = executorService;
    this.modelMeta = modelMeta;
    this.datastore = datastore;
  }

  @Override
  public ListenableFuture<Optional<O>> findOne(String id) {
    return executorService.submit(() -> {
      O document = datastore.find(modelMeta.getSerializable()).field("_id").equal(new ObjectId(id)).first();

      return Optional.ofNullable(document);
    });

  }

  @Override
  public ListenableFuture<List<Optional<O>>> find(List<String> ids) {
    return executorService.submit(() -> {
      List<Optional<O>> documents = new ArrayList<>();

      ids.forEach(id -> {
        O document = datastore.find(modelMeta.getSerializable()).field("_id").equal(new ObjectId(id)).first();
        if (document != null) {
          documents.add(Optional.of(document));
        }
      });

      return documents;
    });
  }

  @Override
  public ListenableFuture<List<O>> find(int limit, int skip) {
    return executorService.submit(() -> {
      List<O> documents = new ArrayList<>();
      MongoCollection<O> mongoCollection = datastore.getDatabase()
          .getCollection(plugin.getConfig().getString("database.collection-name", "MiningPlugin-Data"), modelMeta.getSerializable());
      FindIterable<O> iterator = mongoCollection.find();
      if (limit < Integer.MAX_VALUE && limit > 0) {
        iterator = iterator.limit(limit);
      }
      if (skip > 0) {
        iterator = iterator.skip(skip);
      }

      iterator.into(documents);

      return documents;
    });
  }

  @Override
  public ListenableFuture<Void> update(O o) {
    return executorService.submit(() -> {
      if (modelMeta.getSerializable().isAssignableFrom(Model.Stamped.class)) {
        SimpleStampedModel model = (SimpleStampedModel) o;
        model.setLastUpdate(new Date());
      }
      datastore.save(o);

      return null;
    });
  }

  @Override
  public ListenableFuture<Void> save(O o) {
    return executorService.submit(() -> {
      if (modelMeta.getSerializable().isAssignableFrom(Model.Stamped.class)) {
        SimpleStampedModel model = (SimpleStampedModel) o;
        model.setCreatedAt(new Date());
        model.setLastUpdate(new Date());
      }

      datastore.save(o);

      return null;
    });
  }

  @Override
  public ListenableFuture<Void> delete(O o) {
    return executorService.submit(() -> {
      datastore.delete(datastore.find(modelMeta.getSerializable()).field("_id").equal(o.getObjectId()));

      return null;
    });
  }

}
