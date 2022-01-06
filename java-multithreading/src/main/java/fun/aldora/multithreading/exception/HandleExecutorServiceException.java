package fun.aldora.multithreading.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HandleExecutorServiceException {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> callableTask = () -> {
            System.out.println("inside " + Thread.currentThread().getName());
            return 3;
        };

        List<Callable<Integer>> callableTaskList = new ArrayList<>(Arrays.asList(callableTask, callableTask, callableTask));

        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Future<Integer> future = executorService.submit(callableTask);
            futureList.add(future);
        }


    }
}
