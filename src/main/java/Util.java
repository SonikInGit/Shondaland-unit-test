public class Util {

    public static void waiter(int timeSeconds) {
        try {
            Thread.sleep(timeSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
