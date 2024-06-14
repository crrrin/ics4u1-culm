/**
 * This class contains console delay utilities
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

public class Sleep {

  public static final int LONG_DELAY = 750;
  public static final int SHORT_DELAY = 300;
  public static final int TINY_DELAY = 15;

  /** 
   * delays the program for the provided amount of time, in milliseconds.
   * @param millis The amount of time to delay in milliseconds
   */
  public static void wait(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}