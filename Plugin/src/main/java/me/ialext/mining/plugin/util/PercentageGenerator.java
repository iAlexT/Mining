package me.ialext.mining.plugin.util;

import java.util.concurrent.ThreadLocalRandom;

public interface PercentageGenerator {

  /**
   * Generates a random decimal number representing a percentage.
   *
   * @param range The bound of this percentage.
   * @return A random decimal number.
   */
  static double newDoublePercentage(int range) {
    return ThreadLocalRandom.current().nextDouble(range);
  }

  static int newIntegerPercentage(int range) {
    return ThreadLocalRandom.current().nextInt(range);
  }
}
