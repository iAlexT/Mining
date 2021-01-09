package me.ialext.mining.plugin.service.initializer;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.ialext.mining.api.service.Service;
import me.ialext.mining.plugin.util.message.LoggingMessenger;

public class CommandInitializer implements Service {

  @Override
  public void initialize() {

  }

  private void registerCommands(CommandClass... commandClasses) {
    LoggingMessenger.info("Starting command initializer...");
    CommandManager manager = new BukkitCommandManager("mining");
    PartInjector injector = PartInjector.create();
    injector.install(new DefaultsModule());
    injector.install(new BukkitModule());
    AnnotatedCommandTreeBuilder builder = AnnotatedCommandTreeBuilder.create(injector);

    for (CommandClass commandClass : commandClasses) {
      manager.registerCommands(builder.fromClass(commandClass));
    }
  }
}
