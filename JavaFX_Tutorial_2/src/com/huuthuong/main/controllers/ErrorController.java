package com.huuthuong.main.controllers;


import javafx.fxml.FXML;


public class ErrorController implements DialogController {
    private FXMLDialog dialog;

    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @FXML
    public void close() {
        dialog.close();
    }
}
