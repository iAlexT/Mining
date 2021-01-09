package me.ialext.mining.plugin.util.nms;

import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

@Singleton
public class NMSPlayerParser {

  public static CraftPlayer getCraftPlayer(Player player) {
    return (CraftPlayer) player;
  }

  public static PlayerConnection getPlayerConnection(Player player) {
    return getCraftPlayer(player).getHandle().playerConnection;
  }

}
