package fun.aldora.multithreading.java.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final Logger logger = Logger.getLogger(AppExceptionHandler.class.getSimpleName());
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.log(Level.SEVERE, String.format("Thread-%s, error-%s", t.getName(), e.getMessage()));
    }
}
