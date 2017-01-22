package com.huuthuong.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/huuthuong/spring/beans/Spring_Tutorial_2_Beans.xml");
		Jungle jungle = (Jungle)ctx.getBean("jungle");
		System.out.println(jungle);
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
