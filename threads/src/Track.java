import javax.sound.sampled.*;
import java.net.URL;

public class Track {
  private final Clip clip;
  private volatile boolean active = true;
  private final GlobalTime globalTime;
  private final Object clipLock = new Object();
  private final String name;

  public Track(String name, String file, GlobalTime globalTime) throws Exception {
    this.name = name;
    this.globalTime = globalTime;
    URL url = ClassLoader.getSystemResource(file);
    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
    this.clip = AudioSystem.getClip();
    this.clip.open(audio);
  }

  public void start() {
    new Thread(() -> {
      try {
        synchronized (clipLock) {
          clip.setMicrosecondPosition(0);
          clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        while (true) {
          synchronized (clipLock) {
            if (active) {
              if (!clip.isRunning()) {
                clip.setMicrosecondPosition(
                  globalTime.get() % clip.getMicrosecondLength()
                );
                clip.loop(Clip.LOOP_CONTINUOUSLY);
              }
              globalTime.set(clip.getMicrosecondPosition());
            } else {
              if (clip.isRunning()) {
                clip.stop();
              }
            }
          }
          Thread.sleep(10);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }

  public synchronized void pause() {
    active = false;
  }

  public synchronized void resume() {
    active = true;
  }

  public synchronized boolean isActive() { return active; }
  public String getName() { return name; }
}