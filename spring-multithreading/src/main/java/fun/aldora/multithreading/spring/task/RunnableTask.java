package fun.aldora.multithreading.spring.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
@Getter
@AllArgsConstructor
public class RunnableTask implements Runnable{
    private Integer taskKey;
    private BigInteger base;
    private BigInteger power;

    @Override
    public void run() {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)) {
            if (Thread.currentThread().isInterrupted()) {
                log.info("interrupted");
                return;
            }
            result = result.multiply(base);
        }
        log.info("task {} executed successfully by thread-{}", taskKey, Thread.currentThread().getName());
    }
}
