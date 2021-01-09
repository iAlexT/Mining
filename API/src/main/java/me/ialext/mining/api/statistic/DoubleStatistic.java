package me.ialext.mining.api.statistic;

public class DoubleStatistic implements Statistic {

  private double value;

  public DoubleStatistic(double value) {
    this.value = value;
  }

  public DoubleStatistic() {
    this(0);
  }

  public void increment(double amount) {
    value += amount;
  }

  public void decrement(double amount) {
    value -= amount;
  }

  public void set(double amount) {
    value = amount;
  }

  public double get() {
    return value;
  }
}
