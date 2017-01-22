package com.huuthuong.projavafx.controllers;

import com.huuthuong.projavafx.models.Owner;
import com.huuthuong.projavafx.models.ReversiModel;
import com.huuthuong.projavafx.models.ReversiPiece;
import com.huuthuong.projavafx.models.ReversiSquare;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class ReversiBoardController {

	private final ReversiModel model = ReversiModel.getInstance();
	
	@FXML
	private TilePane titlePane, scorePane;
	
	@FXML 
	private StackPane centerPane;
	
	@FXML
	private Text scoreBlack, scoreWhite, remainingBlack, remainingWhite;
	
	@FXML 
	private Region blackRegion, whiteRegion;
	
	@FXML 
	private Ellipse blackEllipse, whiteEllipse;
	
	@FXML
	private Button restartBtn;
	
	
	@FXML
	public void restart() {
		System.out.println("Restart");
		
		int scoreBlack = model.getScore(Owner.BLACK).intValue();
		int scoreWhite = model.getScore(Owner.WHITE).intValue();
		int turnBlack = model.getTurnRemaining(Owner.BLACK).intValue();
		int turnWhite = model.getTurnRemaining(Owner.WHITE).intValue();
		
		String winner = "";
		if (scoreBlack > 0 && scoreWhite > 0) {
			if (scoreBlack > scoreWhite) {
				winner = "Black";
			} else if (scoreBlack < scoreWhite)  {
				winner = "White";
			} else if (turnBlack > turnWhite)  {
				winner = "Black";
			} else if (turnBlack < turnWhite)  {
				winner = "White";
			} else if (turnBlack == turnWhite)  {
				winner = "draw";
			}				
		} else if (scoreBlack > 0 && scoreWhite <= 0) {
			winner = "Black";
		} else if (scoreBlack <= 0 && scoreWhite > 0) {
			winner = "White";
		} else if (scoreBlack <= 0 && scoreWhite <= 0) {
			if (turnBlack > turnWhite)  {
				winner = "Black";
			} else if (turnBlack < turnWhite)  {
				winner = "White";
			} else if (turnBlack == turnWhite)  {
				winner = "draw";
			}
		}
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Result Before Restart");
		a.setHeaderText("Winner " + winner.toUpperCase());
		a.setContentText(String.format("Statistics: \nScore of Black %d \nTurn remaining of Black %d \nScore of White %d \nTurn remaining of White %d", scoreBlack, turnBlack, scoreWhite, turnWhite));
		a.showAndWait()
		.filter(res -> res == ButtonType.OK)
		.ifPresent(res -> model.restart());
		
	}
	
	@FXML
	public void initialize() {
		titlePane.prefTileWidthProperty().bind(Bindings.selectDouble(titlePane.parentProperty(), "width").divide(2));
		scorePane.prefTileWidthProperty().bind(Bindings.selectDouble(scorePane.parentProperty(), "width").divide(2));
		
		centerPane.getChildren().add(tiles());
				
		scoreBlack.textProperty().bind(model.getScore(Owner.BLACK).asString());
		scoreWhite.textProperty().bind(model.getScore(Owner.WHITE).asString());	
		remainingBlack.textProperty().bind(model.getTurnRemaining(Owner.BLACK).asString().concat(" turn remaining"));
		remainingWhite.textProperty().bind(model.getTurnRemaining(Owner.WHITE).asString().concat(" turn remaining"));
		
		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setColor(Color.DODGERBLUE);
		innerShadow.setChoke(.5);
		whiteRegion.setEffect(innerShadow);
		whiteRegion.effectProperty().bind(Bindings.when(model.turn.isEqualTo(Owner.BLACK))
				.then(innerShadow)
				.otherwise((InnerShadow) null));
		blackRegion.effectProperty().bind(Bindings.when(model.turn.isEqualTo(Owner.WHITE))
				.then(innerShadow)
				.otherwise((InnerShadow) null));
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.DODGERBLUE);
		dropShadow.setSpread(.2);
		blackEllipse.setEffect(dropShadow);
		whiteEllipse.effectProperty().bind(Bindings.when(model.turn.isEqualTo(Owner.WHITE))
				.then(dropShadow)
				.otherwise((DropShadow) null));
		blackEllipse.effectProperty().bind(Bindings.when(model.turn.isEqualTo(Owner.BLACK))
				.then(dropShadow)
				.otherwise((DropShadow) null));
	}
	
	private Node tiles() {
		GridPane board = new GridPane();
		
		for (int i = 0; i < ReversiModel.BOARD_SIZE; i++)
			for (int j = 0; j < ReversiModel.BOARD_SIZE; j++) {
				ReversiSquare reversiSquare = new ReversiSquare(i, j);
				ReversiPiece reversiPiece = new ReversiPiece();
				reversiPiece.ownerProperty().bind(model.board[i][j]);
				board.add(new StackPane(reversiSquare, reversiPiece), i, j);
			}
				
		return board;
	}

	
	
}
