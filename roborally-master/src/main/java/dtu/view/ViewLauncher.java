package dtu.view;

import javafx.application.Application;
import javafx.stage.Stage;
import dtu.controller.*;

public class ViewLauncher extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller c = new Controller(primaryStage);
		
		// --- Define Scenes ---
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		c.launch(); // => Launches main menu screen
	}
	
	public static void main(String[] args) {
		launch(args); // Launch GUI
	}
}
