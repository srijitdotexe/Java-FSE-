public class Logger {
    // Private static instance of the class
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {
            // Synchronize to prevent multiple threads from creating multiple instances
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
