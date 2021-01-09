package me.ialext.mining.plugin.hologram;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.ialext.mining.api.hologram.Hologram;
import me.ialext.mining.api.hologram.HologramLine;
import me.ialext.mining.plugin.util.nms.nbt.NBTTagWriter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SimpleHologram implements Hologram {

  private static final Map<String, Hologram> HOLOGRAM_MAP = new HashMap<>();

  @Getter
  @NotNull
  private final ArmorStand armorStand;

  @Getter
  @NotNull
  private final Location location;

  @Getter
  @Nullable
  private final Map<Integer, HologramLine> lines;

  @Getter
  @Nullable
  private final Predicate<PlayerInteractAtEntityEvent> clickAction;

  public static Builder builder() {
    return new Builder();
  }

  public static Map<String, Hologram> getHologramMap() {
    return HOLOGRAM_MAP;
  }


  public static class Builder implements Hologram.Builder {

    private ArmorStand armorStand;
    private Location location;
    private Map<Integer, HologramLine> lines;
    private Predicate<PlayerInteractAtEntityEvent> clickAction;

    @Override
    public Hologram.Builder setArmorStand(ArmorStand armorStand) {
      this.armorStand = armorStand;
      NBTTagWriter.writeEntity(armorStand, "Hologram", "Hologram");

      return this;
    }

    @Override
    public Hologram.Builder setLocation(Location location) {
      this.location = location;

      return this;
    }

    @Override
    public Hologram.Builder addLine(int index, String text) {
      lines.put(index,
          SimpleHologramLine.builder()
              .setLine(index)
              .setText(text)
              .build()
      );

      return this;
    }

    @Override
    public Hologram.Builder setLines(Map<Integer, HologramLine> lines) {
      this.lines = lines;

      return this;
    }

    @Override
    public Hologram.Builder setClickAction(Predicate<PlayerInteractAtEntityEvent> clickAction) {
      this.clickAction = clickAction;

      return this;
    }

    @Override
    public Hologram build() {
      Hologram hologram = new SimpleHologram(
          armorStand,
          location,
          lines,
          clickAction
      );
      HOLOGRAM_MAP.put(armorStand.getName(), hologram);

      return hologram;
    }
  }
}
