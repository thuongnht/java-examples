package com.huuthuong.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/huuthuong/spring/aop/beans.xml");
        
        Object obj = ctx.getBean("camera");
        System.out.println(obj instanceof Camera);
        
        CameraInterface camera = (CameraInterface) ctx.getBean("camera");
        try {
			camera.snap();
			camera.snapFX(1.8);
			camera.snapISO(500);
			camera.snapISOFX(800, 2.5);
			camera.snapCar(new Car());
		} catch (Exception e) {
			System.out.println("Caught Exception " + e.getMessage());
		}
        
        ctx.close();

	}

}
