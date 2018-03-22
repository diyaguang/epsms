package com.dygstudio.epsms.common;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: diyaguang
 * @date: 2018/03/14 下午4:57
 * @description: com.dygstudio.epsms.common
 */
@Component
public class ReceiverActiveMq {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.out.println("接收到：<"+message+">");
    }
}
