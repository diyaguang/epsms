package com.dygstudio.epsms.entity;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author: diyaguang
 * @date: 2018/03/14 下午4:36
 * @description: com.dygstudio.epsms.entity
 */
public class ActiveMQMsg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException{
        return session.createTextMessage("测试消息");
    }
}
