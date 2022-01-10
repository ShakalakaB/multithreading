package fun.aldora.multithreading.spring.config;

import fun.aldora.multithreading.spring.exception.handler.AsyncTaskRejectedExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadExecutorConfig {
    @Bean("simpleTaskExecutor")
    public ThreadPoolTaskExecutor simpleTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("simpleTaskExecutor-");
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(3);
        executor.setKeepAliveSeconds(5);
        executor.setAllowCoreThreadTimeOut(true);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        executor.setRejectedExecutionHandler(new AsyncTaskRejectedExceptionHandler());
        return executor;
    }
}
