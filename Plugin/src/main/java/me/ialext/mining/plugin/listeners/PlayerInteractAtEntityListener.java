package me.ialext.mining.plugin.listeners;

import me.ialext.mining.api.hologram.Hologram;
import me.ialext.mining.plugin.hologram.SimpleHologram;
import me.ialext.mining.plugin.util.nms.nbt.NBTTagWriter;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.Optional;

public class PlayerInteractAtEntityListener implements Listener {

  @EventHandler
  public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
    Entity entity = event.getRightClicked();

    if (entity instanceof ArmorStand) {
      if (NBTTagWriter.isEntityWritten(entity, "Hologram")) {
        Optional<Hologram> optionalHologram = Optional.ofNullable(SimpleHologram.getHologramMap().get(entity.getName()));
        if (!optionalHologram.isPresent()) {
          return;
        }

        optionalHologram.get().getClickAction().test(event);
      }
    }
  }
}
