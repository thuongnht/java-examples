package com.huuthuong.main;


import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huuthuong.main.config.OfferScreenConfiguration;
import com.huuthuong.main.controllers.OfferScreenController;
import com.huuthuong.main.model.OffersDAO;

import javafx.application.Application;
import javafx.stage.Stage;


public class OfferApplication extends Application {

	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ctx = new ClassPathXmlApplicationContext("/com/huuthuong/main/config/offer-app.xml");
        
		OfferScreenConfiguration screens = (OfferScreenConfiguration) ctx.getBean("offerScreenConfiguration");
        screens.setPrimaryStage(primaryStage);
        screens.loginDialog().show();
		
	}
	
	@Override
    public void stop() throws Exception {
        super.stop();
        ((ClassPathXmlApplicationContext)ctx).close();
    }

}
