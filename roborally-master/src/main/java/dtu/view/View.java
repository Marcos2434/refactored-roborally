package dtu.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import javafx.event.Event;
import javafx.event.EventHandler;

import dtu.controller.*;

//import dtu.logic.Main;

public class View extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create controller
		Controller c = new Controller();
		// Launch controller
		c.launch(); // create board... etc.
		
		// Ex. Tell controller to move robot

		BorderPane container = new BorderPane();
		container.setPrefSize(500, 500);	
		// Board b = new Board(10, 15);
		// b.setRobot(5, 7, CardinalPoints.E);
		
		// ControlPanel cp = new ControlPanel(b);
		// container.setCenter(b);
		// container.setBottom(cp);

        RobotViewer rv = new RobotViewer();

		String colors[] = {"RED","ORANGE","YELLOW","BLUE","PURPLE","BLACK","WHITE","GREEN"};
		ChoiceBox colorChoice = new ChoiceBox(FXCollections.observableArrayList(colors));
 



        Button createPlayerButton = new Button();
        createPlayerButton.setText("Create player");
        createPlayerButton.setOnMouseClicked(new EventHandler<Event>() {
		
            @Override
            public void handle(Event event) {
                c.createPlayer(colorChoice.getValue().toString());
                c.getP().getRobot().registerObserver(rv);
                System.out.println("Player created:"+colorChoice.getValue().toString());
            }
		
        });

        container.setBottom(createPlayerButton);
		container.setCenter(colorChoice);
		
		
		Scene s = new Scene(container);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("RoboRally - v. 0.1 - Own");
		primaryStage.show();

	}

	public static void main(String[] args) {
		// Launch GUI
		launch(args);
	}
}
