package com.example.springasyncsample2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfig {
    private final int THREAD_POOL_SIZE = 10;

    @Bean(name = "myTaskExecutor")
    public Executor myTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(THREAD_POOL_SIZE);
        taskExecutor.setMaxPoolSize(THREAD_POOL_SIZE);
        taskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        taskExecutor.setThreadNamePrefix("MyExecutor-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
