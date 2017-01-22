package com.huuthuong.projavafx.main;

import com.huuthuong.projavafx.models.ZengPongModel;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ZengPongMain extends Application {

	ZengPongModel zpModel = new ZengPongModel();
	
	Circle ball;
	Group pongComponent;
	Button startButton;
	Timeline pongAnimation;
	Rectangle topWall, bottomWall, rightWall, leftWall;
	Rectangle leftPaddle, rightPaddle;
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		pongAnimation = new Timeline(
				new KeyFrame(new Duration(10.0), t -> {
					checkCollision();
					int horzPixel = zpModel.movingRight ? 1 : -1;
					int vertPixel = zpModel.movingDown ? 1 : -1;
					zpModel.centerX.setValue(zpModel.centerX.getValue() + horzPixel);
					zpModel.centerY.setValue(zpModel.centerY.getValue() + vertPixel);
				}));
		pongAnimation.setCycleCount(Timeline.INDEFINITE);
		
		ball = new Circle(0, 0, 5, Color.WHITE);
		topWall = new Rectangle(0, 0, 500, 1);
		leftWall = new Rectangle(0, 0, 1, 500);
		rightWall = new Rectangle(500, 0, 1, 500);
		bottomWall = new Rectangle(0, 500, 500, 1);
		
		leftPaddle = new Rectangle(20, 0, 10, 30);
		leftPaddle.setFill(Color.LIGHTBLUE);
		leftPaddle.setCursor(Cursor.HAND);
		leftPaddle.setOnMousePressed(me -> {
			zpModel.initLeftPaddleTranslateY = leftPaddle.getTranslateY();
			zpModel.leftPaddleDragAnchorY = me.getSceneY();
		});
		leftPaddle.setOnMouseDragged(me -> {
			double dragY = me.getSceneY() - zpModel.leftPaddleDragAnchorY;
			zpModel.leftPaddleY.setValue(zpModel.initLeftPaddleTranslateY + dragY);
		});
		
		rightPaddle = new Rectangle(470, 0, 10, 30);
		rightPaddle.setFill(Color.LIGHTBLUE);
		rightPaddle.setCursor(Cursor.CLOSED_HAND);
		rightPaddle.setOnMousePressed(me -> {
			zpModel.initRightPaddleTranslateY = rightPaddle.getTranslateY();
			zpModel.rightPaddleDragAnchorY = me.getSceneY();
		});
		rightPaddle.setOnMouseDragged(me -> {
			double dragY = me.getSceneY() - zpModel.rightPaddleDragAnchorY;
			zpModel.rightPaddleY.setValue(zpModel.initRightPaddleTranslateY + dragY);
		});
		
		startButton = new Button("Start");
		startButton.setLayoutX(225);
		startButton.setLayoutY(470);
		startButton.setOnAction(me -> {
			zpModel.startVisible.set(false);
			pongAnimation.playFromStart();
			pongComponent.requestFocus();
		});
		
		pongComponent = new Group(ball,
				topWall, leftWall, rightWall, bottomWall,
				leftPaddle, rightPaddle,
				startButton);
		pongComponent.setFocusTraversable(true);
		pongComponent.setOnKeyPressed(ke -> {
			if (ke.getCode() == KeyCode.SPACE && pongAnimation.statusProperty().equals(Animation.Status.STOPPED)) {
				zpModel.rightPaddleY.setValue(zpModel.rightPaddleY.getValue() - 6);
			} else if (ke.getCode() == KeyCode.L
					&& !rightPaddle.getBoundsInParent().intersects(topWall.getBoundsInLocal())) {
				zpModel.rightPaddleY.setValue(zpModel.rightPaddleY.getValue() - 6);
			} else if (ke.getCode() == KeyCode.COMMA
					&& !rightPaddle.getBoundsInParent().intersects(bottomWall.getBoundsInLocal())) {
				zpModel.rightPaddleY.setValue(zpModel.rightPaddleY.getValue() + 6);
			} else if (ke.getCode() == KeyCode.A
					&& !leftPaddle.getBoundsInParent().intersects(topWall.getBoundsInLocal())) {
				zpModel.leftPaddleY.setValue(zpModel.leftPaddleY.getValue() - 6);
			} else if (ke.getCode() == KeyCode.Z
					&& !leftPaddle.getBoundsInParent().intersects(bottomWall.getBoundsInLocal())) {
				zpModel.leftPaddleY.setValue(zpModel.leftPaddleY.getValue() + 6);
			}
		});
		
		Scene scene = new Scene(pongComponent, 500, 500);
		scene.setFill(Color.GRAY);
		
		ball.centerXProperty().bind(zpModel.centerX);
		ball.centerYProperty().bind(zpModel.centerY);
		leftPaddle.translateYProperty().bind(zpModel.leftPaddleY);
		rightPaddle.translateYProperty().bind(zpModel.rightPaddleY);
		startButton.visibleProperty().bind(zpModel.startVisible);
		
		stage.setScene(scene);
		initialize();
		stage.setTitle("Zeng Pong");
		stage.show();
		
	}
	
	public void initialize() {
		zpModel.centerX.setValue(250);
		zpModel.centerY.setValue(250);
		zpModel.leftPaddleY.setValue(235);
		zpModel.rightPaddleY.setValue(235);
		zpModel.startVisible.setValue(true);
		pongComponent.requestFocus();
	}
	
	public void checkCollision() {
		if (ball.intersects(rightWall.getBoundsInLocal()) || ball.intersects(leftWall.getBoundsInLocal())) {
			pongAnimation.stop();
			initialize();
		} else if (ball.intersects(topWall.getBoundsInLocal()) || ball.intersects(bottomWall.getBoundsInLocal())) {
			zpModel.movingDown = !zpModel.movingDown;
		} else if (ball.intersects(leftPaddle.getBoundsInParent()) && !zpModel.movingRight) {
			zpModel.movingRight = !zpModel.movingRight;
		} else if (ball.intersects(rightPaddle.getBoundsInParent()) && zpModel.movingRight) {
			zpModel.movingRight = !zpModel.movingRight;
		}
	}

}
