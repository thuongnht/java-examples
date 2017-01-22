package com.huuthuong.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jungle {
    private Animal largest;
    private Map<String, Animal> animals = new HashMap<String, Animal>();
    private Map<String, String> foods = new HashMap<String, String>();
    
    public Jungle() {}

	public void setLargest(Animal largest) {
		this.largest = largest;
	}

	public void setAnimals(Map<String, Animal> animals) {
		this.animals = animals;
	}

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		String s = "Jungle [largest=" + largest + "\nList of Animals: \n";
		for (Map.Entry<String, Animal> entry : this.animals.entrySet()) {
			s += entry.getKey() + ": " + entry.getValue() + "\n";
		}
		for (Map.Entry<String, String> entry : this.foods.entrySet()) {
			s += entry.getKey() + " eats " + entry.getValue() + "\n";
		}
		return s;
	}
    
    
}
