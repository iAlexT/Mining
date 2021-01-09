package me.ialext.mining.api.service;

/**
 * Represents an initializable and interruptible service, such as a Command Initializer.
 * In that case, the {@link Service} will be on charge of registering every Command into
 * the {@link org.bukkit.Bukkit}'s internal {@link javax.activation.CommandMap}.
 */
public interface Service {

  /**
   * Initializes the {@link Service}, loading everything related to it.
   */
  void initialize();

  /**
   * Interrupts the {@link Service}, unloading everything related to it.
   */
  void interrupt();
}
