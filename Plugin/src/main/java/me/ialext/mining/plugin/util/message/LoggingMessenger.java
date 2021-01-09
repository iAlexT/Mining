package me.ialext.mining.plugin.util.message;

import org.bukkit.Bukkit;

import java.util.logging.Level;

public interface LoggingMessenger {

  static void info(String message) {
    Bukkit.getLogger().log(Level.INFO, message);
  }

  static void warning(String message) {
    Bukkit.getLogger().log(Level.WARNING, message);
  }

  static void severe(String message, Throwable... thrownExceptions) {
    Bukkit.getLogger().log(Level.SEVERE, message, thrownExceptions);
  }

}
