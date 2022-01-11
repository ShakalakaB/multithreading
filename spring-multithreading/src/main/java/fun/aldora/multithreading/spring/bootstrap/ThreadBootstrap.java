package fun.aldora.multithreading.spring.bootstrap;

import fun.aldora.multithreading.spring.SpringMultithreadingApplication;
import fun.aldora.multithreading.spring.task.RunnableTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Slf4j
@Component
@RequiredArgsConstructor
public class ThreadBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final ThreadPoolTaskExecutor simpleTaskExecutor;
    private final ConfigurableApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        for (int i = 0; i < 1; i++) {
            Runnable runnableTask = new RunnableTask(i + 1, BigInteger.valueOf(2), BigInteger.valueOf(Integer.MAX_VALUE));
            simpleTaskExecutor.submit(runnableTask);
        }
        log.info("task submitted");
        applicationContext.close();
    }
}
