package com.huuthuong.main.controllers;

import com.huuthuong.main.model.Offer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;


public class OfferSreen extends StackPane{

	OfferScreenController controller;
    private TableView<Offer> tableView = new TableView<Offer>();

    @SuppressWarnings("deprecation")
	public OfferSreen(OfferScreenController controller, String headerPath) {
        this.controller = controller;
        getChildren().add(VBoxBuilder.create()
            .children(
                createHeader(headerPath),
                createToolbar(),
                createDataTable())
            .build());
    }

    private Node createHeader(String headerPath) {
        return new ImageView(getClass().getResource(headerPath).toString());
    }

    private Node createToolbar() {
        Button removeButton;
        ToolBar toolBar = ToolBarBuilder.create()
            .items(
                ButtonBuilder.create()
                    .text("Add Offer")
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent actionEvent) {
                            controller.addOffer();
                            updateTable();
                        }
                    })
                    .build(),
                removeButton = ButtonBuilder.create()
                    .text("Remove Customer")
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent actionEvent) {
                            try {
                                controller.removeOffer(tableView.getSelectionModel().getSelectedItem());
                                tableView.getSelectionModel().select(Math.min(tableView.getSelectionModel().getSelectedIndex(),
                                    tableView.getItems().size() - 1));
                                updateTable();
                            } catch (AccessDeniedException e) {
                                controller.showErrorDialog();
                            }
                        }
                    })
                    .build()
            )
            .build();
        removeButton.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull());
        return toolBar;
    }

    @SuppressWarnings("unchecked")
    private Node createDataTable() {
        StackPane dataTableBorder = new StackPane();
        dataTableBorder.getChildren().add(tableView);
        dataTableBorder.setPadding(new Insets(8));
        dataTableBorder.setStyle("-fx-background-color: lightgray");
        tableView.getItems().clear();
        tableView.setItems(controller.getOffers());
        tableView.getColumns().setAll(
            TableColumnBuilder.<Offer, String>create()
                .text("Name")
                .cellValueFactory(new PropertyValueFactory<Offer, String>("name"))
                .prefWidth(204)
                .build(),
            TableColumnBuilder.<Offer, String>create()
                .text("Mail")
                .cellValueFactory(new PropertyValueFactory<Offer, String>("mail"))
                .prefWidth(204)
                .build(),
            TableColumnBuilder.<Offer, String>create()
                .text("Content")
                .cellValueFactory(new PropertyValueFactory<Offer, String>("text"))
                .prefWidth(351)
                .build()
        );
        tableView.setPrefHeight(500);
        return dataTableBorder;
    }
    
    private void updateTable() {
    	tableView.getItems().clear();
    	tableView.getItems().addAll(controller.getOffers());
    }
    
}
