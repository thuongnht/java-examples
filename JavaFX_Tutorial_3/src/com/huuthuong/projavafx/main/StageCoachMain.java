package com.huuthuong.projavafx.main;

import java.util.List;

import com.huuthuong.projavafx.controllers.StageCoachController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageCoachMain extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		final StageStyle stageStyle = configStageStyle();
		
		FXMLLoader fxmlLoader = new FXMLLoader(StageCoachMain.class.getResource("/com/huuthuong/projavafx/fxmls/StageCoach.fxml"));
		Group rootGroup = fxmlLoader.load();
		final StageCoachController stageCoachController = fxmlLoader.getController();
		stageCoachController.setStage(stage);
		stageCoachController.setBindings(stageStyle);
		
		Scene scene = new Scene(rootGroup, 250, 350);
		scene.setFill(Color.TRANSPARENT);
		
		stage.setScene(scene);
		stage.setOnCloseRequest(we -> System.out.println("Stage is closing!!!"));
		stage.show();
		Rectangle2D primaryScreenBounds =  Screen.getPrimary().getVisualBounds();
		stage.setX((primaryScreenBounds.getWidth() - stage.getWidth())/2);
		stage.setY((primaryScreenBounds.getHeight() - stage.getHeight())/4);

	}

	private StageStyle configStageStyle() {
		StageStyle stageStyle = StageStyle.DECORATED;
		
		List<String> unnammedParams = getParameters().getUnnamed();
		if (unnammedParams.size() > 0) {
			String stageStyleParam = unnammedParams.get(0);
			if (stageStyleParam.equalsIgnoreCase("transparent")) {
				stageStyle = StageStyle.TRANSPARENT;
			} else if (stageStyleParam.equalsIgnoreCase("undecorated")) {
				stageStyle = StageStyle.UNDECORATED;
			} else if (stageStyleParam.equalsIgnoreCase("utility")) {
				stageStyle = StageStyle.UTILITY;
			}
		}
		
		return stageStyle;
	}

}
