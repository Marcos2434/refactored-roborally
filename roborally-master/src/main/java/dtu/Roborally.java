package dtu;

import dtu.roborally.view.CardinalPoints;
import dtu.roborally.view.widgets.Board;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Roborally extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane container = new BorderPane();

		Board b = new Board(10, 15);
		b.setRobot(5, 7, CardinalPoints.E);
		
		ControlPanel cp = new ControlPanel(b);
		container.setCenter(b);
		container.setBottom(cp);
		
		Scene s = new Scene(container);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("RoboRally - v. 0.1");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
