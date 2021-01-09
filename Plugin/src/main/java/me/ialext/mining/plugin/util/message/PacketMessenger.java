package me.ialext.mining.plugin.util.message;

import me.ialext.mining.plugin.util.nms.NMSPlayerParser;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

@Singleton
public class PacketMessenger {

  /**
   * Sends a {@link Packet} to a Bukkit {@link Player}.
   *
   * @param player The target player.
   * @param packet The packet to be sent.
   */
  public static void sendPacket(Player player, Packet<?> packet) {
    NMSPlayerParser.getPlayerConnection(player).sendPacket(packet);
  }
}
