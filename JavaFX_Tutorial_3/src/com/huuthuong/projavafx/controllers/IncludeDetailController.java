package com.huuthuong.projavafx.controllers;

import com.huuthuong.projavafx.models.Product;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class IncludeDetailController {

	@FXML
	private Label category;
	
	@FXML 
	private Label name;
	
	@FXML
	private TextArea description;
	
	private Product product;
	
	private ChangeListener<String> listener;
	
	public void setProduct(Product product) {
		if (this.product != null) 
			unHookListener();
		this.product = product;
		hookTo(product);
	}
	
	private void unHookListener() {
		description.textProperty().removeListener(listener);
	}
	
	private void hookTo(Product product) {
		if (product == null) {
			category.setText("");
			name.setText("");
			description.setText("");
			listener = null;
			return ;
		}
		
		category.setText(product.getCategory());
		name.setText(product.getName());
		description.setText(product.getDescription());
		listener = (ov, oldV, newV) -> product.setDescription(newV);
		description.textProperty().addListener(listener);
	}
}
