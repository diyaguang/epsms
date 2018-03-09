package com.dygstudio.epsms.controller;

import com.dygstudio.epsms.entity.DygstudioMessage;
import com.dygstudio.epsms.entity.DygstudioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author: diyaguang
 * @date: 2018/03/07 上午10:14
 * @description: com.dygstudio.epsms.controller
 * 当服务端有消息时，会对订阅了 @SentTo 中的路径的浏览器发送消息。
 * 使用时需要将 stomp.min.js（STOMP 协议的客户端脚本），sockjs.min.js（SockJS的客户端脚本）一斤 JQuery放置在 src/main/resources/static 下。
 */
@Controller
public class WebStockMsController {
    @MessageMapping("/chat")  //当浏览器向服务器发送请求时，映射这个地址。
    @SendTo("/topic/getResponse")
    public DygstudioResponse say(DygstudioMessage message) throws Exception{
        Thread.sleep(3000);
        return new DygstudioResponse("Welcome, "+message.getName()+" ! ");
    }

    /*
    @Autowired
    private SimpMessagingTemplate messagingTemplate;   //通过这个对象，向浏览器发送消息

    public void HandleChat(Principal principal, String msg){   //Principal 中包含用户信息
        if(principal.getName().equals("dyg")){
            messagingTemplate.convertAndSendToUser("admin","/queue/notifications",principal.getName()+"-send:"+msg);
        }
        else {
            messagingTemplate.convertAndSendToUser("admin","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }
    */
}
