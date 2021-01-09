package me.ialext.mining.plugin.mongo.morphia;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import me.ialext.mining.plugin.file.YamlFileCreator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class MorphiaDatastoreProvider implements Provider<Datastore> {

  @Inject
  private Morphia morphia;
  @Inject
  @Named("config")
  private YamlFileCreator config;

  @Inject
  private MongoClient mongoClient;

  @Override
  public Datastore get() {
    return morphia.createDatastore(mongoClient, config.getString("database.name"));
  }
}
