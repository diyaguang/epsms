package com.dygstudio.epsms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: diyaguang
 * @date: 2018/02/27 下午4:43
 * @description: com.dygstudio.epsms.controller
 * 配置类，可以使用在 没有使用 @Service，@Autowired，等其他注解的基础上，通过配置的方式 使用Bean，在配置类中使用 @Bean注解
 * 其中返回 Bean 的 方法名就是 Bean的类名
 * 在Spring中，只要容器中存在某个Bean，就可以在另外一个Bean的声明方法的参数中写入。
 */
@Configuration
@ComponentScan("com.dygstudio.epsms.entity")
public class EpsmsConfig {
}
