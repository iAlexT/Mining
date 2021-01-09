package me.ialext.mining.plugin.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class MongoClientProvider implements Provider<MongoClient> {

  @Inject
  private JavaPlugin plugin;

  @Override
  public MongoClient get() {
    return new MongoClient(new MongoClientURI(plugin.getConfig().getString("database.uri")));
  }
}
