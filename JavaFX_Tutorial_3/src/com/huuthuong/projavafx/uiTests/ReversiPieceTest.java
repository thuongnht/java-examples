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

public class ReversiPieceTest extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Node white = new StackPane(new ReversiSquare(), new ReversiPiece(Owner.WHITE));
		Node black = new StackPane(new ReversiSquare(), new ReversiPiece(Owner.BLACK));
		HBox hbox = new HBox(white, black);
		hbox.setSnapToPixel(false);
		primaryStage.setScene(new Scene(hbox));
		hbox.setHgrow(white, Priority.ALWAYS);
		hbox.setHgrow(black, Priority.ALWAYS);
		primaryStage.show();
	}

}
