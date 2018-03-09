package com.dygstudio.epsms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
@ComponentScan("com.dygstudio.epsms.common")
@EnableAspectJAutoProxy   //使用该注解开启 Spring 对 AspectJ 代理的支持。
@PropertySource("classpath:epsms.properties")   //这里配置使用指定的配置文件，配置 @Value注解一起使用
public class EpsmsConfig {

    @Value("${web.anthor}")
    public String webAnthor;

    @Value("${web.group}")
    public String webGroup;

    @Bean   //如果使用配置文件方式配合 @Value使用，需要配置一个 PropertySourcesPlaceholderConfigurer 的 Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
