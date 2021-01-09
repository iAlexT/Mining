package me.ialext.mining.plugin.mongo.morphia;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class MorphiaDatastoreProvider implements Provider<Datastore> {

  @Inject
  private Morphia morphia;
  @Inject
  private JavaPlugin plugin;
  @Inject
  private MongoClient mongoClient;

  @Override
  public Datastore get() {
    return morphia.createDatastore(mongoClient, plugin.getConfig().getString("database.name", "MiningPlugin-Datastore"));
  }
}
