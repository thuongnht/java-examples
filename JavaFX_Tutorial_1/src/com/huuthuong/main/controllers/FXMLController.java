package com.huuthuong.main.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import org.springframework.beans.factory.InitializingBean;

public abstract class FXMLController
        implements InitializingBean, Initializable {

    public FXMLController() {
        super();
    }

    protected Node view;

    protected String fxmlFilePath;

    public abstract void setFxmlFilePath(String filePath);

//    Wenn diese Methode bereitstellt wird kann auf das Interface "Initializable" verzichten
//    public abstract void initialize();
    @Override
    public void afterPropertiesSet() throws Exception {
        loadFXML();
    }

    protected final void loadFXML() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
            loader.setController(this);
            this.view = loader.load();
        } catch (Exception e) {
        	System.out.println("FXMLController: \n"+ Arrays.toString(e.getStackTrace()));
        }
    }

    public Node getView() {
        return view;
    }
}