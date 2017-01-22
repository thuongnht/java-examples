package com.huuthuong.main.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.XmlValue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoController
        extends FXMLController {

    public DemoController() {
        super();
    }

    private static final AtomicLong counter = new AtomicLong(1);

    @FXML
    Button btn;

    @FXML
    TextField input;

    @FXML
    Label btnMessage;

    @FXML
    Label output;

    @FXML
    public void showOutput() {
        btnMessage.setText(String.format("Counter: %d", counter.getAndIncrement()));
    }

    @Value("${fxml.demo.view}")
    @Override
    public void setFxmlFilePath(String filePath) {
        this.fxmlFilePath = filePath;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        output.textProperty().bind(input.textProperty());
    }
}