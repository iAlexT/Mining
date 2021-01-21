package me.ialext.mining.api.data;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.mongodb.client.FindIterable;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import me.ialext.mining.api.data.model.Model;
import me.ialext.mining.api.data.model.binding.ModelMeta;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.*;

public class MongoObjectRepository<O extends Model> implements ObjectRepository<O> {

  private final ListeningExecutorService executorService;
  private final Datastore datastore;
  private final ModelMeta<O> modelMeta;

  @Inject
  public MongoObjectRepository(ListeningExecutorService executorService,
                               Datastore datastore,
                               ModelMeta<O> modelMeta) {
    this.executorService = executorService;
    this.datastore = datastore;
    this.modelMeta = modelMeta;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<Optional<O>> findOne(String id) {
    return executorService.submit(() -> Optional.ofNullable(datastore.find(modelMeta.getImplementation()).field("_id").equal(new ObjectId(id)).first()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<List<O>> findOneByQuery(Filter query) {
    return executorService.submit(() -> toQuery(query).find().toList());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<List<O>> find(List<String> ids) {
    return executorService.submit(() -> {
      List<O> docs = new ArrayList<>();

      ids.forEach(id -> {
        Optional<O> optionalDoc = Optional.ofNullable(datastore.find(modelMeta.getImplementation()).field("_id").equal(new ObjectId(id))
            .first());
        optionalDoc.ifPresent(docs::add);
      });

      return docs;
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<List<O>> find(int limit, int skip) {
    return executorService.submit(() -> {
      List<O> docs = new ArrayList<>();

      FindIterable<O> findIterable = datastore.getDatabase().getCollection(modelMeta.getImplementation().getName(), modelMeta.getImplementation()).find();
      if (limit < Integer.MAX_VALUE && limit > 0) {
        findIterable = findIterable.limit(limit);
      }

      if (skip > 0) {
        findIterable = findIterable.skip(skip);
      }

      findIterable.into(docs);

      return docs;
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<Void> update(O o) {
    return executorService.submit(() -> {
      datastore.delete(o);
      o.setLastUpdate(new Date());
      datastore.save(o);

      return null;
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<Void> save(O o) {
    return executorService.submit(() -> {
      datastore.save(o);

      return null;
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ListenableFuture<Void> delete(O o) {
    return executorService.submit(() -> {
      datastore.delete(o);

      return null;
    });
  }

  /**
   * Converts a {@link Filter} to a Morphia {@link Query}.
   * @param filter The filter to be converted.
   * @return A query representing the given filter.
   */
  private Query<O> toQuery(Filter filter) {
    Query<O> query = datastore.find(modelMeta.getImplementation());

    for (Map.Entry<String, Object> entry : filter.getQuery().entrySet()) {
      query = query
          .field(entry.getKey())
          .equal(entry.getValue());
    }

    Optional<String> sortBy = filter.getSortBy();
    if (sortBy.isPresent()) {
      query = query.order(Sort.ascending(sortBy.get()));
    }

    return query;
  }
}
