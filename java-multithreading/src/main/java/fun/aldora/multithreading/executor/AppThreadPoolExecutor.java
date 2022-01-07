package fun.aldora.multithreading.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThreadPoolExecutor extends ThreadPoolExecutor {
    private static final Logger logger = Logger.getLogger(AppThreadPoolExecutor.class.getSimpleName());

    public AppThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            logger.log(Level.SEVERE, String.format("Error-%s", t.getMessage()));
        }
    }
}
