package me.ialext.mining.plugin.hologram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.ialext.mining.api.hologram.HologramLine;

@Getter
@AllArgsConstructor
public class SimpleHologramLine implements HologramLine {

  private final int line;
  private final String text;

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements HologramLine.Builder {

    private String text;
    private int line;

    @Override
    public HologramLine.Builder setText(String text) {
      this.text = text;

      return this;
    }

    @Override
    public HologramLine.Builder setLine(int line) {
      this.line = line;

      return this;
    }

    @Override
    public HologramLine build() {
      return new SimpleHologramLine(
          line,
          text
      );
    }
  }
}
