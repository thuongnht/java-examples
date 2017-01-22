package com.huuthuong.projavafx.controllers;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageCoachController {

	@FXML
	private Rectangle blue;

	@FXML
	private VBox contentBox;

	@FXML
	private HBox titleBox;

	@FXML
	private Text textStageX, textStageY, textStageH, textStageW, textStageF;

	@FXML
	private Button toBackBtn, toFrontBtn, closeBtn;

	@FXML
	private CheckBox checkBoxResizable, checkBoxFullscreen;

	@FXML
	private Label titleLabel;

	@FXML
	private TextField titleTextField;

	private Stage stage;
	private StringProperty title = new SimpleStringProperty();
	public double dragAnchorX, dragAnchorY;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setBindings(StageStyle stageStyle) {
		checkBoxResizable.setDisable(stageStyle == StageStyle.TRANSPARENT || stageStyle == StageStyle.UNDECORATED);
		textStageX.textProperty().bind(
				new SimpleStringProperty(textStageX.textProperty().getValue()).concat(stage.xProperty().asString()));
		textStageY.textProperty().bind(
				new SimpleStringProperty(textStageY.textProperty().getValue()).concat(stage.yProperty().asString()));
		textStageH.textProperty().bind(new SimpleStringProperty(textStageH.textProperty().getValue())
				.concat(stage.heightProperty().asString()));
		textStageW.textProperty().bind(new SimpleStringProperty(textStageW.textProperty().getValue())
				.concat(stage.widthProperty().asString()));
		textStageF.textProperty().bind(new SimpleStringProperty(textStageF.textProperty().getValue())
				.concat(stage.focusedProperty().asString()));
		
		NumberBinding anchorW = Bindings.add(-20.0, stage.widthProperty());
		NumberBinding anchorH = Bindings.add(-40.0, stage.heightProperty());
		blue.widthProperty().bind(anchorW);
		blue.heightProperty().bind(anchorH);
		
		stage.setResizable(true);
		stage.setMinHeight(350);
		stage.setMinWidth(250);
		checkBoxResizable.selectedProperty().bindBidirectional(stage.resizableProperty());
		checkBoxFullscreen.selectedProperty().addListener((ov, oldV, newV) -> {
			stage.setFullScreen(checkBoxFullscreen.selectedProperty().getValue());			
		});
		title.bind(titleTextField.textProperty());
		stage.titleProperty().bind(title);
		stage.initStyle(stageStyle);
	}

	@FXML
	public void toBackEventHandler(ActionEvent ae) {
		stage.toBack();
	}

	@FXML
	public void toFrontEventHandler(ActionEvent ae) {
		stage.toFront();
	}

	@FXML
	public void closeEventHandler(ActionEvent ae) {
		stage.close();
	}

	@FXML
	public void mouseDraggedHandler(MouseEvent me) {
		stage.setX(me.getSceneX() - dragAnchorX);
		stage.setY(me.getSceneY() - dragAnchorY);
	}

	@FXML
	public void mousePressedHandler(MouseEvent me) {
		dragAnchorX = me.getSceneX() - stage.getX();
		dragAnchorY = me.getSceneY() - stage.getY();
	}

}
