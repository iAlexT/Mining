package me.ialext.mining.api.item;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a money item that is dropped whenever an {@link me.ialext.mining.api.user.User}
 * mines and the required percentage is reached or supered.
 */
public interface MoneyItem {

  /**
   * Provides the {@link ItemStack} type of this {@link MoneyItem}, usually a {@link org.bukkit.block.Skull}.
   *
   * @return The {@link MoneyItem}'s {@link ItemStack}.
   */
  ItemStack getItem();

  float getMoney();

}
