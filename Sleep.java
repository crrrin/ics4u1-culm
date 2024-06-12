public class Sleep {
  
  public static void waitShort() {
    try {
      Thread.sleep(300);
    } 
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    finally {
      System.out.println();
    }
  }

  public static void waitLong() {
    try {
      Thread.sleep(750);
    } 
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    finally {
      System.out.println();
    }
  }
}