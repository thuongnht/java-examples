package com.huuthuong.main.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.huuthuong.main.config.OfferScreenConfiguration;


public class LoginController implements DialogController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private OfferScreenConfiguration screens;
    
    private FXMLDialog dialog;

    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    public LoginController() {}

    @FXML
    Label header;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    public void login() {
        Authentication authToken = new UsernamePasswordAuthenticationToken(username.getText(), password.getText());
        try {
            authToken = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authToken);
        } catch (AuthenticationException e) {
            header.setText("Login failure, please try again:");
            header.setTextFill(Color.DARKRED);
            return;
        }
        dialog.close();
        screens.showScreen(screens.offerDataScreen());
    }

    @FXML
    public void employee() {
        username.setText("employee");
        password.setText("employee");
    }

    @FXML
    public void manager() {
        username.setText("manager");
        password.setText("manager");
    }
    
    @FXML
    public void exitApplication(ActionEvent event) {
    	dialog.close();
    }
    
}

