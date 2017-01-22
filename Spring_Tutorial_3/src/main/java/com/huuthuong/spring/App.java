package com.huuthuong.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/huuthuong/spring/beans/Spring_Tutorial_3_Beans_Component.xml");
//		Logger logger = (Logger) ctx.getBean("logger");
//		LoggerResource logger = (LoggerResource) ctx.getBean("logger");
		LoggerInject logger = (LoggerInject) ctx.getBean("loggerInject");
		logger.writeConsole("hello");
		logger.writeFile("hello");
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
