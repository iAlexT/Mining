package me.ialext.mining.plugin.util.nms.nbt;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import javax.inject.Singleton;

import static org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asBukkitCopy;
import static org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy;

@Singleton
public class NBTTagWriter {

  /**
   * Writes a Bukkit {@link ItemStack} using a {@link net.minecraft.server.v1_8_R3.NBTTagString}.
   *
   * @param itemStack The item to be wrote.
   * @param key       The {@link net.minecraft.server.v1_8_R3.NBTTagCompound}'s key.
   * @param value     The {@link net.minecraft.server.v1_8_R3.NBTTagCompound}'s value.
   * @return The written item.
   */
  public static ItemStack writeItem(ItemStack itemStack, String key, String value) {
    net.minecraft.server.v1_8_R3.ItemStack nmsItem = asNMSCopy(itemStack);
    nmsItem.getTag().setString(key, value);

    return asBukkitCopy(nmsItem);
  }

  /**
   * Writes a Bukkit {@link Entity} using a {@link net.minecraft.server.v1_8_R3.NBTTagString}.
   *
   * @param entity The entity to be wrote.
   * @param key    The {@link net.minecraft.server.v1_8_R3.NBTTagCompound}'s key.
   * @param value  The {@link net.minecraft.server.v1_8_R3.NBTTagCompound}'s value.
   * @return The written entity.
   */
  public static Entity writeEntity(Entity entity, String key, String value) {
    net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) entity).getHandle();
    nmsEntity.getNBTTag().setString(key, value);

    return CraftEntity.getEntity(nmsEntity.getWorld().getServer(), nmsEntity);
  }

  /**
   * Checks if the given Bukkit {@link Entity} contains the given {@link String}
   * key in its {@link net.minecraft.server.v1_8_R3.NBTTagCompound}.
   *
   * @param itemStack The item to be checked.
   * @param key       The key to be searched.
   * @return True if the key was found, otherwise false.
   */
  public static boolean isItemWritten(ItemStack itemStack, String key) {
    net.minecraft.server.v1_8_R3.ItemStack nmsItem = asNMSCopy(itemStack);

    return nmsItem.getTag().hasKey(key);
  }

  /**
   * Checks if the given Bukkit {@link Entity} contains the given {@link String}
   * key in its {@link net.minecraft.server.v1_8_R3.NBTTagCompound}.
   *
   * @param entity The entity to be checked.
   * @param key    The key to be searched.
   * @return True if the key was found, otherwise false.
   */
  public static boolean isEntityWritten(Entity entity, String key) {
    net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) entity).getHandle();

    return nmsEntity.getNBTTag().hasKey(key);
  }
}
