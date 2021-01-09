package me.ialext.mining.plugin.module;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.ialext.mining.plugin.mongo.MongoClientProvider;
import me.ialext.mining.plugin.mongo.morphia.MorphiaDatastoreProvider;
import me.ialext.mining.plugin.mongo.morphia.MorphiaProvider;
import me.yushust.inject.AbstractModule;

public class DataModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Morphia.class).toProvider(MorphiaProvider.class);
    bind(Datastore.class).toProvider(MorphiaDatastoreProvider.class);
    bind(MongoClient.class).toProvider(MongoClientProvider.class);
  }
}
