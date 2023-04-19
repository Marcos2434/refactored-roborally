package dtu.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import dtu.controller.*;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dtu.logic.models.Color;
import dtu.logic.models.Position;

import java.io.IOException;

//import dtu.logic.Main;
class Tuple<A, B> {
    private A first;
    private B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

public class View extends Application {
	void launchBoard(Stage primaryStage)throws Exception{
		BorderPane menu = new BorderPane();

		String[][] board1 = {
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","C 1","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","C 3","T"},
            {"C 2","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            //Start Field
            {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
            {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
            {"T","T","T","S","T","T","S","T","T","T"},
        };

        Board board = new Board(board1);
		Robot robot = new Robot(Color.BLUE, new Position(3, 12), board);
		
		ControlPanel cp = new ControlPanel(board, robot);
		menu.setCenter(board);
		menu.setBottom(cp);
		
		
		Scene s = new Scene(menu);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Tylko jedno w głowie mam");
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		// Create controller
		Controller c = new Controller();
		// Launch controller
		c.launch(); // create board... etc.
		
		// Ex. Tell controller to move robot
		
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		



		primaryStage.setScene(c.getMenuScene());
		primaryStage.setTitle("RoboRally - v. 0.1");
		primaryStage.show();


		// Show game screen (board)


	}
	

	

	public static void main(String[] args) {
		// Launch GUI
		launch(args);
	}
}
