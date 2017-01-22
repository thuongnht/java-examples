package com.huuthuong.projavafx.controllers;

import java.lang.reflect.Parameter;
import java.util.*;

import com.huuthuong.projavafx.models.Product;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.VBox;

public class IncludeTreeController {

	@FXML
	private TreeTableView<Product> treeTableView;
	
	@FXML 
	private TreeTableColumn<Product, String> category, name;
	
	@FXML
	private VBox details;
	
	@FXML 
	private IncludeDetailController detailsController;
	
	@FXML
	public void initialize() {
		List<Product> products = new ArrayList<>();
		for (int i=0; i<=100; i++) {
			Product product = new Product();
			product.setCategory("Category " + (i/10));
			product.setName("Name " + i);
			product.setDescription("Description " + i);
			products.add(product);
		}
		
		TreeItem<Product> root = new TreeItem<>(products.get(products.size()-1));
		root.setExpanded(true);
		for (int i=0; i<10; i++) {
			TreeItem<Product> firstLevel = new TreeItem<>(products.get(i*10));
			firstLevel.setExpanded(true);
			for (int j=1; j<10; j++) {
				TreeItem<Product> secondLevel = new TreeItem<>(products.get(i*10+j));
				secondLevel.setExpanded(true);
				firstLevel.getChildren().add(secondLevel);
			}
			root.getChildren().add(firstLevel);
		}
		
		category.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getValue().getCategory()));
		name.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getValue().getName()));
		
		treeTableView.setRoot(root);
		treeTableView.getSelectionModel().selectedItemProperty().addListener((ov, oldV, newV) -> {
			Product product = null;
			if (newV != null) 
				product = newV.getValue();
			
			detailsController.setProduct(product);
		});
	}
	
	
	
}
