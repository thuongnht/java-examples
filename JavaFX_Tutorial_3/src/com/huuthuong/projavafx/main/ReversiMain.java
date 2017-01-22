package com.huuthuong.projavafx.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReversiMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(ReversiMain.class.getResource("/com/huuthuong/projavafx/fxmls/ReversiBoard.fxml"));
		AnchorPane anchorPane = fxmlLoader.load();
		
		Scene scene = new Scene(anchorPane, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Reversi Game");
		primaryStage.show();
	}

}
