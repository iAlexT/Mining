package me.ialext.mining.plugin.util.message;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

@Singleton
public class ActionBarMessenger {

  /**
   * Sends an ActionBar message to a {@link Player} via ActionBar.
   *
   * @param player  The target player.
   * @param message The message to be sent.
   */
  public static void sendMessage(Player player, String message) {
    IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}");
    Packet<?> packet = new PacketPlayOutChat(component, (byte) 2);
    PacketMessenger.sendPacket(player, packet);
  }
}
