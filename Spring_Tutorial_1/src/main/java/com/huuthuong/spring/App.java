package com.huuthuong.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/huuthuong/spring/beans/spring_tutorial_1_beans.xml");
		Person p = (Person)context.getBean("person");
        p.speak();
        System.out.println(p);
        
        ((ClassPathXmlApplicationContext)context).close();
        
	}

}
