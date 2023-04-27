package dtu.view;

import javafx.application.Application;
import javafx.stage.Stage;
import dtu.controller.*;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

public class View extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller c = new Controller(primaryStage);
		
		// --- Define Scenes ---
		StartMenuScene Start = new StartMenuScene(c);
		c.setStartScene(Start);
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		
		BoardScene boardScene = new BoardScene(c);
		c.setBoardScene(boardScene);
		// ProgrammingPhaseSceneSimple programmingPhaseSceneSimple = new ProgrammingPhaseSceneSimple(c);
		// c.setProgrammingPhaseSceneSimple(programmingPhaseSceneSimple);

		// ---------------------

		c.launch(); // => Launches main menu screen
	}
	
	public static void main(String[] args) {
		launch(args); // Launch GUI
	}
}
