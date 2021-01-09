package me.ialext.mining.plugin.concurrent;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.concurrent.Executors;

@Singleton
public class
ListeningExecutorServiceProvider implements Provider<ListeningExecutorService> {

  @Override
  public ListeningExecutorService get() {
    return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
  }
}
