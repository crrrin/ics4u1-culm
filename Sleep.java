public class Sleep {

    protected static final int GENERIC_LONG_DELAY_MS = 750;
    protected static final int GENERIC_SHORT_DELAY_MS = 350;
    protected static final int GENERIC_TINY_DELAY_MS = 100;

    public static void wait(int timeMilli) {
        try {
            Thread.sleep(timeMilli);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
