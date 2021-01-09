package me.ialext.mining.api.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.ialext.mining.api.user.User;
import org.bukkit.event.Event;

@AllArgsConstructor
public abstract class UserEvent extends Event {

  @Getter protected final User user;
}
