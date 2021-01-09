package me.ialext.mining.api.statistic;

public class IntegerStatistic implements Statistic {

  private int value;

  public IntegerStatistic(int value) {
    this.value = value;
  }

  public IntegerStatistic() {
    this(0);
  }

  public void increment(int amount) {
    value += amount;
  }

  public void decrement(int amount) {
    value -= amount;
  }

  public void set(int amount) {
    value = amount;
  }

  public int get() {
    return value;
  }

}
