package com.dygstudio.epsms.common;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: diyaguang
 * @date: 2018/03/15 上午9:14
 * @description: com.dygstudio.epsms.common
 */
@Component
public class ReceiverRabbitMq {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("Received"+message+">");
    }
}
