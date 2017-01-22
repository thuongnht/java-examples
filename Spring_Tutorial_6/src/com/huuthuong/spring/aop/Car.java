package com.huuthuong.spring.aop;

import org.springframework.stereotype.Component;

@Component("car")
@Deprecated
public class Car {
//	public Car() {
//		System.out.println("hello car here");
//	}
	
	public void start() {
		System.out.println("Start car");
		
	}
}
