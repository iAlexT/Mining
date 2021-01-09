package me.ialext.mining.api.hologram;

/**
 * Represents a text line stored in a {@link Hologram}.
 */
public interface HologramLine {

  String getText();

  int getLine();

  interface Builder {

    Builder setText(String text);

    Builder setLine(int line);

    HologramLine build();

  }
}

