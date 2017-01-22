package com.huuthuong.projavafx.uiTests;

import com.huuthuong.projavafx.models.Owner;
import com.huuthuong.projavafx.models.ReversiPiece;
import com.huuthuong.projavafx.models.ReversiSquare;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReversiSquareTest extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(new StackPane(new ReversiSquare())));
		primaryStage.show();
	}

}
