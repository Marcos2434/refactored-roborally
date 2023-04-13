package dtu;

//import dtu.roborally.view.CardinalPoints;
import dtu.logic.models.Board.Board;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import dtu.controller.*;

//import dtu.logic.Main;

public class Roborally extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
        Controller c = new Controller();
		// Launch controller
		c.launch(); // create board... etc.
		
		BorderPane container = new BorderPane();

		String[][] board1 = {
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"}
        };

        Board board = new Board(board1);
		
		ControlPanel cp = new ControlPanel(board);
		container.setCenter(board);
		container.setBottom(cp);
		// Create controller
		
		
		// Ex. Tell controller to move robot

		
		// Board b = new Board(10, 15);
		// b.setRobot(5, 7, CardinalPoints.E);
		
		// ControlPanel cp = new ControlPanel(b);
		// container.setCenter(b);
		// container.setBottom(cp);
		
		
		
		
		Scene s = new Scene(container);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("RoboRally - v. 0.1 - Tiles update");
		primaryStage.show();

	}

	public static void main(String[] args) {


		// Launch GUI
		launch(args);
	}
}
