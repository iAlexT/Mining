package me.ialext.mining.plugin.file;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlFileCreator extends YamlConfiguration {

  private final String fileName;
  private final Plugin plugin;
  private final File file;

  public YamlFileCreator(Plugin plugin, String fileName, String fileExtension, File folder){
    this.plugin = plugin;
    this.fileName = fileName + (fileName.endsWith(fileExtension) ? "" : fileExtension);
    this.file = new File(folder, this.fileName);
    this.createFile();
  }

  public YamlFileCreator(Plugin plugin, String fileName) {
    this(plugin, fileName, ".yml");
  }

  public YamlFileCreator(Plugin plugin, String fileName, String fileExtension) {
    this(plugin, fileName, fileExtension, plugin.getDataFolder());
  }

  public YamlFileCreator(Plugin plugin, String fileName, String fileExtension, String filePath) {
    this(plugin, fileName, fileExtension, new File(plugin.getDataFolder().getAbsolutePath() + "/" + filePath));
  }

  private void createFile() {
    try {
      if (!file.exists()) {
        if (this.plugin.getResource(this.fileName) != null) {
          this.plugin.saveResource(this.fileName, false);
        } else {
          this.save(file);
        }
        this.load(file);
        return;
      }
      this.load(file);

      this.save(file);
    } catch (InvalidConfigurationException | IOException e) {
      e.printStackTrace();
    }
  }

  public void reload() {
    try {
      load(file);
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public void save() {
    try {
      this.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getString(String path) {
    return ChatColor.translateAlternateColorCodes('&', super.getString(path));
  }

  @Override
  public String getString(String path, String def) {
    String s = super.getString(path, def);

    return s != null ? ChatColor.translateAlternateColorCodes('&', s) : def;
  }

  @Override
  public List<String> getStringList(String path) {
    List<String> list = super.getStringList(path);

    list.replaceAll(line -> ChatColor.translateAlternateColorCodes('&', line));

    return list;
  }
}
