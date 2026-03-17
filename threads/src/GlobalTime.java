public class GlobalTime {
  private long time = 0;

  public synchronized void set(long time) {
    this.time = time;
  }

  public synchronized long get() {
    return time;
  }
}