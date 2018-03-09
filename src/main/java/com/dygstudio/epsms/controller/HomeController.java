package com.dygstudio.epsms.controller;

import com.dygstudio.epsms.config.EpsmsConfig;
import com.dygstudio.epsms.entity.Person;
import com.dygstudio.epsms.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/02/27 下午4:00
 * @description: com.dygstudio.epsms
 */
@Controller
@ControllerAdvice     //支持使用 Controller扩展，声明一个控制器建言
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    EpsmsConfig epsmsConfig;

    @Autowired  //Spring 推荐使用 enviroment这样的方式来访问资源文件，在代码中调用该对象的 getProperty方法来获取。
    private Environment environment;

    @RequestMapping("/")
    protected String Home(){
        homeService.Login("dygstudio","0000");
        String anthor = environment.getProperty("web.anthor");
        String group = environment.getProperty("web.group");
        return "This is epsms web site ! the site group is "+ epsmsConfig.webGroup +",the site anthor is "+epsmsConfig.webAnthor;
    }
    @RequestMapping("/advice")
    protected String advice(){
        throw new IllegalArgumentException("xxxxxx");
        //return "this is error page";
    }

    @ExceptionHandler(value=Exception.class)   //统一对 Exception进行处理，定义全局处理，通过 value属性可增加过滤拦截的条件。
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute   //将键值对添加到全局，所有注解的 @RequestMapping 的方法可获得此键值对。
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder    //初始化绑定，注解定制 WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");  //设置忽略 request 参数的id
    }

    @RequestMapping("/index")
    public String index(Model model){
        Person single = new Person("aa",11);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);

        return "index";
    }
}
