package me.ialext.mining.plugin.file;

import me.yushust.inject.Module;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileBinder {

  private final Map<String, YamlFileCreator> files = new HashMap<>();

  public FileBinder bind(String name, YamlFileCreator file) {
    files.put(name, file);

    return this;
  }

  public Optional<YamlFileCreator> get(String name) {
    return Optional.ofNullable(files.get(name));
  }

  public Module build() {
    return binder -> files.forEach((name, file) -> binder.bind(YamlFileCreator.class).named(name).toInstance(file));
  }

}
