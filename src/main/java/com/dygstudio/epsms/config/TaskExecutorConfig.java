package com.dygstudio.epsms.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author: diyaguang
 * @date: 2018/02/28 下午5:41
 * @description: com.dygstudio.epsms.config
 * 创建 任务的配置类，并集成 AsyncConfigurer。   Public class TaskExecutorConfig implements AsyncConfigurer{ ...} 。
 * 并重写 getAsyncExecutor方法，该方法返回一个 Executor对象，我们返回 ThreadPoolTaskExecutor 对象，这样就能获取一个基于线程池的 TaskExecutor对象了。
 * 在这个配置类中，要使用 @EnableAsync 类启用异步的支持。
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
