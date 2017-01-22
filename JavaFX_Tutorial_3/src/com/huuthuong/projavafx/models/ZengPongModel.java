package com.huuthuong.projavafx.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Circle;

public class ZengPongModel {

	public DoubleProperty centerX = new SimpleDoubleProperty();
	public DoubleProperty centerY = new SimpleDoubleProperty();
	
	public DoubleProperty leftPaddleY = new SimpleDoubleProperty();
	public DoubleProperty rightPaddleY = new SimpleDoubleProperty();
	
	public double leftPaddleDragAnchorY;
	public double rightPaddleDragAnchorY;
	
	public double initLeftPaddleTranslateY;
	public double initRightPaddleTranslateY;
	
	public BooleanProperty startVisible = new SimpleBooleanProperty(true);
	
	public boolean movingRight;
	public boolean movingDown;
	
	public void initialize() {
		
	}
	
}
