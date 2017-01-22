package com.huuthuong.projavafx.models;

import javafx.scene.paint.Color;

public enum Owner {

	NONE,
	BLACK,
	WHITE;
	
	public Owner opposite() {
		return (this==WHITE) ? BLACK : (this==BLACK) ? WHITE : NONE;
	}
	
	public Color getColor() {
		return (this==Owner.WHITE) ? Color.WHITE : Color.BLACK;
	}
	
	public String getColorStyle() {
		return (this==Owner.WHITE) ? "white" : "black";
	}
}
