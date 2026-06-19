import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        // ERROR level 
        logger.error("This is an error message");

        // WARN level 
        logger.warn("This is a warning message");

        // INFO level 
        logger.info("This is an info message");

        // DEBUG level 
        logger.debug("This is a debug message");

        // TRACE level
        logger.trace("This is a trace message");

        logger.info("Application started successfully");
        logger.warn("Low memory warning: only 10MB remaining");
        logger.error("Database connection failed!");
    }
}