public class SingletonTest {
    public static void main(String[] args) {
        // Get two references to Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use them
        logger1.log("First log message");
        logger2.log("Second log message");

        // Verify both are the SAME instance
        if (logger1 == logger2) {
            System.out.println("Both variables point to the SAME Logger instance.");
        } else {
            System.out.println("Different instances — Singleton failed!");
        }
    }
}