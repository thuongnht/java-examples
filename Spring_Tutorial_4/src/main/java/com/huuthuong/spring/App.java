package com.huuthuong.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/huuthuong/spring/beans/Spring_Tutorial_4_Beans.xml");
		
//		Robot robot = (Robot) ctx.getBean("robot");
//		robot.speak();
		
		OffersDAO offersDao = (OffersDAO) ctx.getBean("offersDao");
        try {
        	offersDao.createOffer(new Offer("kevin","keven@nowhereatall","Web Dev"));
        	
        	System.out.println(offersDao);
        	System.out.println(offersDao.getOffer(2, "Thuong"));
        	
        	offersDao.deleteOffer(7);
        	offersDao.updateOffer(new Offer(8,"kefler","kefler@nowhereatall","Web Dev"));
        	
        	List<Offer> ids = new ArrayList<Offer>();
        	ids.add(new Offer(){{setId(33);}});
        	offersDao.deleteOffers(ids);
        	
        	System.out.println(offersDao);

        	List<Offer> offers = new ArrayList<Offer>();
        	offers.add(new Offer(8,"kevin","keven@nowhereatall","Web Dev"));
        	offers.add(new Offer(10,"kevin","keven@nowhereatall","Web Dev"));
        	offersDao.createOffers(offers);
        	
    
        } 
        catch (Exception e) {
        	System.out.println(e.getMessage() + "\n" + e.getClass());
        }
        
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
