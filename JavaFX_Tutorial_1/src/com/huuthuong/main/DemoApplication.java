package com.huuthuong.main;

import com.huuthuong.main.controllers.DemoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.huuthuong.main")
@PropertySource("classpath:resources/application.properties")
public class DemoApplication
        extends Application {

    private static final Logger LOG = Logger.getLogger(DemoApplication.class.getName());

    private ApplicationContext appContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        appContext = new AnnotationConfigApplicationContext(DemoApplication.class);
        String name = appContext.getEnvironment().getProperty("application.name");
        String version = appContext.getEnvironment().getProperty("application.version");

        DemoController demoController = appContext.getBean(DemoController.class);

        primaryStage.setScene(new Scene((Parent) demoController.getView()));
        primaryStage.setTitle(String.format("%s %s", name, version));
        primaryStage.show();

        LOG.log(Level.INFO, String.format("%s %s wurde gestartet", name, version));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}