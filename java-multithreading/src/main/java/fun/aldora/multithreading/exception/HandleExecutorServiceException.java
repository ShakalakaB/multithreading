package fun.aldora.multithreading.exception;

import fun.aldora.multithreading.config.AppThreadFactory;
import fun.aldora.multithreading.executor.AppThreadPoolExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleExecutorServiceException {
    private static final Logger logger = Logger.getLogger(HandleExecutorServiceException.class.getSimpleName());

    public static void main(String[] args) {
//        handleWithTryCatch();
//        handleWithExceptionHandler();
        handleWithThreadPoolExecutor();

    }

    private static void handleWithTryCatch() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = getCallableTask();

        Future<Integer> callablefuture = executorService.submit(callableTask);
        try {
            Integer result = callablefuture.get();
            System.out.println("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        Runnable runnableTask = getRunnableTask();
        Future<?> runnableFuture = executorService.submit(runnableTask);
        try {
            runnableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private static void handleWithExceptionHandler() {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new AppThreadFactory());

        Runnable runnableTask = getRunnableTask();
        executorService.execute(runnableTask);
    }



    private static void handleWithThreadPoolExecutor() {
        ExecutorService executorService = new AppThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        executorService.execute(getRunnableTask());
    }

    private static Runnable getRunnableTask() {
        return () -> {
            System.out.println("inside " + Thread.currentThread().getName());
            if (1 == 1) {
                throw new RuntimeException("TEST");
            }
        };
    }

    private static Callable<Integer> getCallableTask() {
        Callable<Integer> callableTask = () -> {
            System.out.println("inside " + Thread.currentThread().getName());
            if (1 == 1) {
                throw new RuntimeException("TEST");
            }
            return 3;
        };
        return callableTask;
    }
}
