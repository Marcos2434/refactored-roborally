package dtu.view;

import javafx.application.Application;
import javafx.stage.Stage;
import dtu.controller.*;

public class View extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller c = new Controller(primaryStage);
		
		// --- Define Scenes ---
		StartMenuScene Start = new StartMenuScene(c);
		c.setStartScene(Start);
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		

		// ProgrammingPhaseScene programmingScene = new ProgrammingPhaseScene(c);
		// c.setProgrammingPhaseScene(programmingScene);
		// try {
		// } catch (Exception e) { System.err.println(e); }

		// ProgrammingPhaseSceneSimple programmingPhaseSceneSimple = new ProgrammingPhaseSceneSimple(c);
		// c.setProgrammingPhaseSceneSimple(programmingPhaseSceneSimple);

		// ---------------------

		c.launch(); // => Launches main menu screen
	}
	
	public static void main(String[] args) {
		launch(args); // Launch GUI
	}
}
