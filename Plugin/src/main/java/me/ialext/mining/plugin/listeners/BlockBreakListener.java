package me.ialext.mining.plugin.listeners;

import me.ialext.mining.plugin.util.PercentageGenerator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    double random = PercentageGenerator.newPercentage(100);

  }
}
