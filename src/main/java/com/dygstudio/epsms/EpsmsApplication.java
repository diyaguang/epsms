package com.dygstudio.epsms;

import com.dygstudio.epsms.config.EpsmsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EpsmsApplication {

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
