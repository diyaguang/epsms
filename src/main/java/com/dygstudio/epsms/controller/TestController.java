package com.dygstudio.epsms.controller;

import com.dygstudio.epsms.entity.Users;
import com.dygstudio.epsms.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: diyaguang
 * @date: 2018/03/21 下午5:38
 * @description: com.dygstudio.epsms.controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    RedisRepository redisRepository;

    @RequestMapping("/redis")
    public String testRedis(){
        String testStr = "This is Custom RedisHelper class";

        redisRepository.<String>add("test",10l,testStr);

        String result = redisRepository.get("test",String.class);

        return result;
    }
}
