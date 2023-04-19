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
	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller c = new Controller(primaryStage);
		
		// --- Define Scenes ---
		MenuScene menuScene = new MenuScene(c);
		c.setMenuScene(menuScene);
		
		BoardScene boardScene = new BoardScene(c);
		c.setBoardScene(boardScene);
		// ---------------------

		c.launch(); // => Launches main menu screen
	}
	
	public static void main(String[] args) {
		launch(args); // Launch GUI
	}
}
