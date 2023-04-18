package dtu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

import dtu.logic.models.Color;
import dtu.logic.models.Position;
//import dtu.roborally.view.CardinalPoints;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//import dtu.controller.Controller;

//import dtu.logic.Main;

public class Roborally extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
        // // Create controller
        // Controller c = new Controller();
		// // Launch controller
		// c.launch(); // create board... etc.
		
		BorderPane container = new BorderPane();

		String[][] board1 = {
            {"T","T","HT","T","T","C 2","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","C 1","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","C 3","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            //Start Field
            {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
            {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
            {"T","T","T","S","T","T","S","T","T","T"},
        };

        Board board = new Board(board1);
        Robot robot2 = new Robot(Color.BLUE, new Position(3, 12), board);
        
        // Position[] startPositions = new Position[6];    

        // startPositions[0] = new Position(1, 11);
        // startPositions[1] = new Position(3, 12);
        // startPositions[2]= new Position(4, 11);
        // startPositions[3]= new Position(5, 11);
        // startPositions[4] = new Position(6, 12);
        // startPositions[5] = new Position(8, 11);

        // Random randInt = new Random();
        // int randomIndex = randInt.nextInt(startPositions.length);
        // Position randomPosition = startPositions[randomIndex];
        // Robot robot = new Robot(Color.RED, startPositions[0], board);

        // randomIndex = randInt.nextInt(startPositions.length);
        // randomPosition = startPositions[randomIndex];
        // Robot robot2 = new Robot(Color.BLUE, startPositions[1], board);

        // randomIndex = randInt.nextInt(startPositions.length);
        // randomPosition = startPositions[randomIndex];
        // Robot robot3 = new Robot(Color.GREEN, startPositions[2], board);

        // randomIndex = randInt.nextInt(startPositions.length);
        // randomPosition = startPositions[randomIndex];
        // Robot robot4 = new Robot(Color.BLACK, startPositions[3], board);

        // randomIndex = randInt.nextInt(startPositions.length);
        // randomPosition = startPositions[randomIndex];
        // Robot robot5 = new Robot(Color.PURPLE, startPositions[4], board);

        // randomIndex = randInt.nextInt(startPositions.length);
        // randomPosition = startPositions[randomIndex];
        // Robot robot6 = new Robot(Color.YELLOW, startPositions[5], board);
        

        
		ControlPanel cp = new ControlPanel(board, robot2);
		container.setCenter(board);
		container.setBottom(cp);
		
		
		Scene s = new Scene(container);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Tylko jedno w głowie mam");
		primaryStage.show();

	}

	public static void main(String[] args) {


		// Launch GUI
		launch(args);
	}
}
