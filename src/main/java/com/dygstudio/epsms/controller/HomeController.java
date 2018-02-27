package com.dygstudio.epsms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: diyaguang
 * @date: 2018/02/27 下午4:00
 * @description: com.dygstudio.epsms
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    protected String Home(){
        return "This is epsms web site";
    }
}
