package com.dygstudio.epsms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: diyaguang
 * @date: 2018/03/01 上午10:22
 * @description: com.dygstudio.epsms.config
 */
@Configuration
@EnableScheduling        //通过这个注解开启对计划任务的支持
public class TaskSchedulerConfig {
    //直接启动就会按照设定进行执行了
}
