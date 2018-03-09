package com.dygstudio.epsms.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: diyaguang
 * @date: 2018/02/28 上午10:04
 * @description: com.dygstudio.epsms.common
 */
@Aspect   //声明一个切面
@Component   //让此切面称为Spring容器管理的 Bean
public class LoginAspect {

    @Pointcut("@annotation(com.dygstudio.epsms.common.Action)")  //定义切点
    public void annotationPointCut(){};

    //通过 @After注解声明一个建言，使用 @PointCut定义的切点
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 "+action.name());  //通过反射获得注解上的属性，然后做日志记录相关的操作。
    }

    //通过 @Before 注解声明一个建言，直接使用拦截规则作为参数。
    @Before("execution(* com.dygstudio.epsms.service.HomeServiceImpl.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截,"+method.getName());
    }
}
