package com.huuthuong.main.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huuthuong.main.model.Offer;
import com.huuthuong.main.model.OffersDAO;


public class AddOfferController implements DialogController {
    @Autowired
    private OffersDAO model;
    
    private FXMLDialog dialog;
    private boolean isAddClicked = false;

    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @FXML
    TextField name;
    @FXML
    TextField mail;
    @FXML
    TextField text;
    
    
    @FXML
    public void add() {
        model.createOffer(new Offer(name.getText(), mail.getText(), text.getText()));
        
        this.isAddClicked = true;
        dialog.close();
    }
    
    public boolean isAddClicked() {
    	return this.isAddClicked;
    }

    @FXML
    public void cancel() {
        dialog.close();
    }
}
