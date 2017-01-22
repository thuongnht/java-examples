package com.huuthuong.main.config;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.net.URL;

import com.huuthuong.main.controllers.*;


@Configuration
@Lazy
//@Component("offerScreenConfiguration")
@PropertySource("classpath:resources/application.properties")
public class OfferScreenConfiguration {
    private Stage primaryStage;
    
    @Autowired
    @Value("${fxml.login.view}")
    private String loginPath;
    
    @Value("${fxml.error.view}")
    private String errPath;
    
    @Value("${fxml.addOffer.view}")
    private String addOfferPath;
    
    @Value("${fxml.header.image}")
    private String header;
    
    @Value("${fxml.logo.image}")
    private String logo;
    
    @Value("${application.name}")
    private String appName;
    
    @Value("${application.version}")
    private String appVersion;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
 
        primaryStage.setScene(new Scene(screen, 777, 500));
        primaryStage.setTitle(String.format("%s %s", appName, appVersion));
        primaryStage.show();
    }

    @Bean
    public OfferSreen offerDataScreen() {
        return new OfferSreen(offerDataScreenController(), this.header);
    }

    @Bean
    public OfferScreenController offerDataScreenController() {
        return new OfferScreenController();
    }

    @Bean
    @Scope("prototype")
	public FXMLDialog errorDialog() {
        return new FXMLDialog(errorController(), getClass().getResource(this.errPath), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    public ErrorController errorController() {
        return new ErrorController();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog addOfferDialog() {
        return new FXMLDialog(addOfferController(), getClass().getResource(this.addOfferPath), primaryStage);
    }

    @Bean
    @Scope("prototype")
    public AddOfferController addOfferController() {
        return new AddOfferController();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog loginDialog() {
        return new FXMLDialog(loginController(), getClass().getResource(this.loginPath), primaryStage, StageStyle.UTILITY);
    }

    @Bean
    @Scope("prototype")
    public LoginController loginController() {
        return new LoginController();
    }
}