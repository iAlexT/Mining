package me.ialext.mining.plugin.module;

import me.ialext.mining.api.user.User;
import me.ialext.mining.api.data.model.binding.ModelBinderModule;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.Binder;

public class ModelModule extends AbstractModule implements ModelBinderModule {


  @Override
  protected void configure() {
    bindModel(User.class);
  }

  @Override
  public Binder getBinder() {
    return binder();
  }
}
