package com.huuthuong.projavafx.models;

public class Product {

	private String category;
	private String name;
	private String description;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
