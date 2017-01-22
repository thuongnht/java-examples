package com.huuthuong.main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.huuthuong.main.config.OfferScreenConfiguration;
import com.huuthuong.main.model.Offer;
import com.huuthuong.main.model.OffersDAO;


public class OfferScreenController {

	@Autowired
    private OffersDAO offerModel;

	@Autowired
    private OfferScreenConfiguration screens;

    public OfferScreenController() {}

    public void showErrorDialog() {
        screens.errorDialog().show();
    }

    public ObservableList<Offer> getOffers() {
        return FXCollections.observableArrayList(offerModel.getOffers());
    }

    @Secured({"ROLE_MANAGER", "ROLE_EMPLOYEE"})
    public void addOffer() {
        FXMLDialog addOfferDialog = screens.addOfferDialog();
        addOfferDialog.showAndWait();
    }
    
    public void removeOffer(Offer offer) {
        offerModel.deleteOffer(offer);
    }
    
}
