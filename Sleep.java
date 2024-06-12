public class Sleep {
  
  public static final int LONG_DELAY = 750;
  public static final int SHORT_DELAY = 300;

  public static void wait(int millis) {
    try {
      Thread.sleep(millis);
    } 
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    finally {
      System.out.println();
    }
  }
}