package fun.aldora.multithreading.java.config;

import fun.aldora.multithreading.java.exception.AppExceptionHandler;

import java.util.concurrent.ThreadFactory;

public class AppThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        final Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new AppExceptionHandler());
        return thread;
    }
}
