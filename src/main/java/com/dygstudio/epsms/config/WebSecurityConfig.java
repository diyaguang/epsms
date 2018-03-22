package com.dygstudio.epsms.config;

import com.dygstudio.epsms.service.SecurityUserService;
import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: diyaguang
 * @date: 2018/03/13 下午8:12
 * @description: com.dygstudio.epsms.config
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{  //1扩展 SpringSecurity配置需要继承 WebSecurityConfigurerAdapter
    @Bean
    UserDetailsService customUserService(){  //2 注册 CustomUserService 的 Bean
        return new SecurityUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserService());  //3  添加我们自定义的 user detail service 认证
    }
    // 配置用户目录访问权限，注：对于不同的目录的权限不可以放到一个 http.authorizeRequests中，需要分开绑定
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/test/**").anonymous();
        http.authorizeRequests().antMatchers("/api/**").anonymous();
        http.authorizeRequests().antMatchers("/rest/**").anonymous();
        http.authorizeRequests()
                .anyRequest().authenticated()  //4 所有请求需要认证登录后才能访问
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()  //5  定制登录行为，登录页面可任意访问
                .and()
                .logout().permitAll();  //6 定制注销行为，注销请求可任意访问
    }
}
