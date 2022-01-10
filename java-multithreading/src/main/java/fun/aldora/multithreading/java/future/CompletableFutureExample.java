package fun.aldora.multithreading.java.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        Integer b = 1;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 1 + b;
        }).thenCompose(s -> {
            return CompletableFuture.supplyAsync(() -> {
                return s + 1;
            });
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
                    return 1;
                }), (s1, s2) -> s1 + s2
        ).thenApply(supplier -> {
            return supplier + 1;
        });
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
