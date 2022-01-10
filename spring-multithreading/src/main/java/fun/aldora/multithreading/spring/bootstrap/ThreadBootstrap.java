package fun.aldora.multithreading.spring.bootstrap;

import fun.aldora.multithreading.spring.task.RunnableTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ThreadBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final ThreadPoolTaskExecutor simpleTaskExecutor;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        for (int i = 0; i < 5; i++) {
            Runnable runnableTask = new RunnableTask(i + 1);
            simpleTaskExecutor.submit(runnableTask);
        }
        log.info("task submitted");
    }
}
