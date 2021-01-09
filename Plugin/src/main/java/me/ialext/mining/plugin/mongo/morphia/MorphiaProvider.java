package me.ialext.mining.plugin.mongo.morphia;

import dev.morphia.Morphia;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class MorphiaProvider implements Provider<Morphia> {

  @Override
  public Morphia get() {
    return new Morphia().mapPackage("me.ialext.mining");
  }
}
