package com.huuthuong.projavafx.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SingleSelectionModel;

public class AudioConfigModel {

	public double minDecibels = 0.0;
	public double maxDecibels = 160.0;
	
	public BooleanProperty muting = new SimpleBooleanProperty(false);
	
	public IntegerProperty selectedDB = new SimpleIntegerProperty(0);
	
	public ObservableList genres = FXCollections.observableArrayList(
			"Chamber",
			"Country",
			"Cowbell",
			"Metal",
			"Polka",
			"Rock");
	
	private List<Integer> valueDBs = (List<Integer>) Arrays.asList(80, 100, 150, 140, 120, 130);
	 
	public SingleSelectionModel genreSelectionModel;
	
	public void addListenerToGenreSelectionModel() {
		genreSelectionModel.selectedIndexProperty().addListener((Observable o) -> {
			int index = genreSelectionModel.selectedIndexProperty().getValue();
			selectedDB.setValue(valueDBs.get(index));
		});
	}
	
}
