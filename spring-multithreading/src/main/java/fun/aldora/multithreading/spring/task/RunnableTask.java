package fun.aldora.multithreading.spring.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class RunnableTask implements Runnable{
    private Integer taskKey;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task {} executed successfully by thread-{}", taskKey, Thread.currentThread().getName());
    }
}
