package me.ialext.mining.plugin.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import me.ialext.mining.api.hologram.Hologram;
import me.ialext.mining.plugin.hologram.SimpleHologram;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@Command(names = {"hologram", "holo", "h"})
public class HologramCommands implements CommandClass {

  @Command(names = "")
  public boolean mainCommand(@Sender Player sender) {
    return true;
  }

  @Command(names = "create")
  public boolean hologramCreateCommand(@Sender Player sender, String name) {
    ArmorStand armorStand = (ArmorStand) sender.getWorld().spawnEntity(sender.getLocation(), EntityType.ARMOR_STAND);
    armorStand.setCustomName(name);
    armorStand.setVisible(false);
    Hologram hologram = SimpleHologram
        .builder()
        .setArmorStand(armorStand)
        .setClickAction(playerInteractAtEntityEvent -> {
          sender.sendMessage("You've clicked an Armor Stand.");

          return false;
        })
        .addLine(1, "Text line")
        .build();
    return true;
  }

  @Command(names = "list")
  public void hologramListCommand(@Sender Player sender) {

  }

}
