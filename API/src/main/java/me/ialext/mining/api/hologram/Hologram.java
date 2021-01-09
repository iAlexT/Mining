package me.ialext.mining.api.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Represents an hologram, which uses an {@link org.bukkit.entity.ArmorStand} to be displayed.
 */
public interface Hologram {

  @NotNull ArmorStand getArmorStand();

  /**
   * Provides the {@link Hologram}'s {@link Location}.
   *
   * @return The location.
   */
  @NotNull Location getLocation();

  /**
   * Provides a {@link Map} containing all the {@link HologramLine}s in this {@link Hologram}
   * indexed using its {@link HologramLine#getLine()}.
   *
   * @return A map containing the indexed lines.
   */
  Map<@Nullable Integer, @Nullable HologramLine> getLines();

  /**
   * Provides the action that will be executed whenever an {@link me.ialext.mining.api.user.User} interacts with
   * the {@link Hologram}.
   *
   * @return The action.
   */
  Predicate<PlayerInteractAtEntityEvent> getClickAction();

  interface Builder {

    Builder setArmorStand(ArmorStand armorStand);

    Builder setLocation(Location location);

    Builder addLine(int index, String text);

    Builder setLines(Map<Integer, HologramLine> lines);

    Builder setClickAction(Predicate<PlayerInteractAtEntityEvent> clickAction);

    Hologram build();

  }
}
