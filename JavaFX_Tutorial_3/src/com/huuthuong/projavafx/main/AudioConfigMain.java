package com.huuthuong.projavafx.main;


import com.huuthuong.projavafx.models.AudioConfigModel;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class AudioConfigMain extends Application {

	AudioConfigModel acModel = new AudioConfigModel();
	
	Text text;
	Slider slider;
	CheckBox mutingCheckbox;
	ChoiceBox genreChoicebox;
	Color color = Color.color(.66, .67, .69);
	
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Text title = new Text(65,12,"Audio Configuration");
		title.setTextOrigin(VPos.TOP);
		title.setFill(Color.WHITE);
		title.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));
		
		text = new Text();
		text.setLayoutX(18);
		text.setLayoutY(69);
		text.setTextOrigin(VPos.TOP);
		text.setFill(Color.web("#131021"));
		text.setFont(Font.font("SansSerif", FontWeight.BOLD, 18));
		
		Text mutingText = new Text(18, 113, "Muting");
		mutingText.setTextOrigin(VPos.TOP);
		mutingText.setFill(Color.web("#131021"));
		mutingText.setFont(Font.font("SansSerif", FontWeight.BOLD, 18));
		
		Text genreText = new Text(18, 154, "Genres");
		genreText.setTextOrigin(VPos.TOP);
		genreText.setFill(Color.web("#131021"));
		genreText.setFont(Font.font("SansSerif", FontWeight.BOLD, 18));
		
		slider = new Slider();
		slider.setLayoutX(135);
		slider.setLayoutY(69);
		slider.setPrefWidth(162);
		slider.setMin(acModel.minDecibels);
		slider.setMax(acModel.maxDecibels);
		
		mutingCheckbox = new CheckBox();
		mutingCheckbox.setLayoutX(280);
		mutingCheckbox.setLayoutY(113);
		
		genreChoicebox = new ChoiceBox();
		genreChoicebox.setLayoutX(204);
		genreChoicebox.setLayoutY(154);
		genreChoicebox.setPrefWidth(93);
		genreChoicebox.setItems(acModel.genres);
		Stop[] stops = new Stop[]{new Stop(0, Color.web("0xAEBBCC")), new Stop(1, Color.web("0x6D84A3"))};
		
		LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
		Rectangle rectangle1 = new Rectangle(0, 0, 320, 45);
		rectangle1.setFill(linearGradient);
		
		Rectangle rectangle2 = new Rectangle(0, 43, 320, 300);
		rectangle2.setFill(Color.rgb(199, 206, 213));
		
		Rectangle rectangle3 = new Rectangle(8, 54, 300, 130);
		rectangle3.setArcHeight(20);
		rectangle3.setArcWidth(20);
		rectangle3.setFill(Color.WHITE);
		rectangle3.setStroke(color);
		
		Line line1 = new Line(9, 97, 309, 97);
		line1.setStroke(color);
		
		Line line2 = new Line(9, 141, 309, 141);
		line2.setFill(color);
		
		Group group = new Group(rectangle1, title, rectangle2, rectangle3, 
				text, slider, line1,
				mutingText, mutingCheckbox, line2, 
				genreText, genreChoicebox);
		Scene scene = new Scene(group, 320, 343);
		
		text.textProperty().bind(acModel.selectedDB.asString().concat(" dB"));
		slider.valueProperty().bindBidirectional(acModel.selectedDB);
		slider.disableProperty().bind(acModel.muting);
		mutingCheckbox.selectedProperty().bindBidirectional(acModel.muting);
		acModel.genreSelectionModel = genreChoicebox.getSelectionModel();
		acModel.addListenerToGenreSelectionModel();
		acModel.genreSelectionModel.selectFirst();
		
		stage.setScene(scene);
		stage.setTitle("Audio Configuration");
		stage.show();
		
		
		
	}

}
