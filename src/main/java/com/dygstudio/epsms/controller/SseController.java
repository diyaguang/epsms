package com.dygstudio.epsms.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author: diyaguang
 * @date: 2018/03/02 下午4:27
 * @description: com.dygstudio.epsms.controller
 */
@Controller
public class SseController {

    //这里使用输出的媒体类型为 text/event-stream，这是服务器端SSE的支持。
    @RequestMapping(value = "/push",produces = "text/event-stream")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
    }
}
