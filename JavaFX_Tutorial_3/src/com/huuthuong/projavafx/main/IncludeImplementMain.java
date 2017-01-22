package com.huuthuong.projavafx.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IncludeImplementMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(IncludeImplementMain.class.getResource("/com/huuthuong/projavafx/fxmls/IncludeTree.fxml"));
		final BorderPane borderPane = fxmlLoader.load();
		Scene scene = new Scene(borderPane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Include Example");
		primaryStage.show();
	}

}
