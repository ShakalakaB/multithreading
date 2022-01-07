package fun.aldora.multithreading.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleExecutorServiceException {
    private static Logger logger = Logger.getLogger("HandleExecutorServiceException");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> callableTask = () -> {
            System.out.println("inside " + Thread.currentThread().getName());
            if (1 == 1) {
                throw new RuntimeException("TEST");
            }
            return 3;
        };

        List<Callable<Integer>> callableTaskList = new ArrayList<>(Arrays.asList(callableTask, callableTask, callableTask));

        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Future<Integer> future = executorService.submit(callableTask);
            futureList.add(future);
        }

        for (Future<Integer> future : futureList) {
            try {
                Integer result = future.get();
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage());
            } catch (ExecutionException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }

    }
}
