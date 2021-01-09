package me.ialext.mining.api.statistic;

public class FloatStatistic implements Statistic {

  private float value;

  public FloatStatistic(float value) {
    this.value = value;
  }

  public FloatStatistic() {
    this(0);
  }

  public void increment(float amount) {
    value += amount;
  }

  public void decrement(float amount) {
    value -= amount;
  }

  public void set(float amount) {
    value = amount;
  }

  public float get() {
    return value;
  }
}
