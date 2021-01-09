package me.ialext.mining.plugin.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class MiningPlaceholderExpansion extends PlaceholderExpansion {

  @Inject
  private JavaPlugin plugin;

  @Override
  public @NotNull String getIdentifier() {
    return "Mining";
  }

  @Override
  public @NotNull String getAuthor() {
    return "iAlexT";
  }

  @Override
  public @NotNull String getVersion() {
    return plugin.getDescription().getVersion();
  }

  @Override
  public String onPlaceholderRequest(Player player, @NotNull String params) {
    if (player == null) {
      return "";
    }

    return ";";
  }
}
