package com.dygstudio.epsms.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author: diyaguang
 * @date: 2018/03/07 上午9:39
 * @description: com.dygstudio.epsms.config
 */
@Controller
//通过这个注解，开启使用 STOMP 协议来传输基于代理（message broker）的消息。这时控制前支持使用 @MessageMapping，就像使用 @RequestMapping一样。
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){  //注册 STOMP 协议的节点，并映射的指定的 URL
        registry.addEndpoint("/endpointDygstudio").withSockJS();  //注册一个 STOMP 的 endpoint，并指定使用 SockJS协议。
        //registry.addEndpoint("/endpointChatRoom").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){   //配置消息代理（Message Broker）
        registry.enableSimpleBroker("/topic","/queue");   //广播式应配置一个 /topic 消息代理
    }
}
