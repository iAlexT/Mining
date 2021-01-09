package me.ialext.mining.plugin.util.message;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.entity.Player;

import javax.inject.Singleton;

@Singleton
public class TitleMessenger {

  /**
   * Sends a Title message to a {@link Player}.
   *
   * @param player      The target player.
   * @param message     The message to be sent.
   * @param titleAction The title action type.
   * @param enter       The delay to send the title.
   * @param fadeIn      The delay to start fading the title.
   * @param out         The delay to finish the title.
   */
  public static void sendMessage(Player player,
                                 String message,
                                 PacketPlayOutTitle.EnumTitleAction titleAction,
                                 int enter,
                                 int fadeIn,
                                 int out) {
    Packet<?> packet = new PacketPlayOutTitle(
        titleAction,
        IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}"),
        enter,
        fadeIn,
        out
    );
    PacketMessenger.sendPacket(player, packet);
  }

}
