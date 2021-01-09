package me.ialext.mining.api.placeholder;

import me.ialext.mining.api.user.User;

/**
 * Applies a PlaceholderAPI's Placeholder to an {@link User}.
 */
public interface PlaceholderApplier {

  String setPlaceholder(User user, String placeholder);

}
