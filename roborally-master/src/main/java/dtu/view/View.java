package dtu.view;

import javafx.application.Application;
import javafx.stage.Stage;
import dtu.controller.*;

public class View extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller c = new Controller(primaryStage);
		
		// --- Define Scenes ---
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		
		BoardScene boardScene = new BoardScene(c);
		c.setBoardScene(boardScene);
		try{
			ProgrammingPhaseScene programmingPhaseScene = new ProgrammingPhaseScene(c);
			c.setProgrammingPhaseScene(programmingPhaseScene);
		}
		catch(Exception e){System.out.println(e);}
		

		// ProgrammingPhaseSceneSimple programmingPhaseSceneSimple = new ProgrammingPhaseSceneSimple(c);
		// c.setProgrammingPhaseSceneSimple(programmingPhaseSceneSimple);

		// ---------------------

		c.launch(); // => Launches main menu screen
	}
	
	public static void main(String[] args) {
		launch(args); // Launch GUI
	}
}
