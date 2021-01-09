package me.ialext.mining.plugin.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import me.ialext.mining.plugin.file.YamlFileCreator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class MongoClientProvider implements Provider<MongoClient> {

  @Inject
  @Named("config")
  private YamlFileCreator config;

  @Override
  public MongoClient get() {
    return new MongoClient(new MongoClientURI(config.getString("database.uri")));
  }
}
