package com.dygstudio.epsms;

import com.dygstudio.epsms.config.EpsmsConfig;
import com.dygstudio.epsms.entity.ActiveMQMsg;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class EpsmsApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void run(String... args) throws Exception{
		jmsTemplate.send("my-destination",new ActiveMQMsg());
		rabbitTemplate.convertAndSend("my-queue","这个是来自 RabbitMQ 的消息");
	}

	@Autowired
    RabbitTemplate rabbitTemplate;

	@Bean
    public Queue dygstudioQueue(){
	    return new Queue("my-queue");
    }

	public static void main(String[] args) {
		SpringApplication.run(EpsmsApplication.class, args);

		/* 在 ApplicationContext 上下文中获取对象并使用
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EpsmsConfig.class);
		XxxxService xxxxService = context.getBean(XxxxxService.class);
		xxxxService.SayHello("java config");
		context.close();
		*/
	}
}
