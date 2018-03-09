package com.dygstudio.epsms.common;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: diyaguang
 * @date: 2018/03/01 下午5:22
 * @description: com.dygstudio.epsms.common
 * 继承 HandlerInterceptorAdapter 实现自定义拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{
    @Override  //重写 preHandle 方法，在请求发生之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override  //重写 postHandle 方法，在请求完成后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        long startTime=(Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为:"+new Long(endTime-startTime)+"ms");
        //request.setAttribute("handlingTime",endTime-startTime);
    }
}
