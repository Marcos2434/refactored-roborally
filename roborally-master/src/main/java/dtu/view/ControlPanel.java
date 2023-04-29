package dtu.view;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

import dtu.controller.Controller;
import dtu.logic.models.Cards.MovementCards.*;
import dtu.logic.models.Player.Player;

public class ControlPanel extends GridPane {

	private Controller c;
	
	
	// ObservableList<String> players = FXCollections.observableArrayList();
	// final ComboBox<String> comboBox = new ComboBox<String>();
	

	
	private Button ChooseCards = new Button("Choose cards");
	private Button Activate = new Button("Activate register");
	
	public ControlPanel(Controller c) {
		this.c = c;
		configure();
		addListeners();
	}




	private void configure() {
		add(Activate, 0, 0);
		add(ChooseCards,1,0);
	

		// add(comboBox, 0, 5);
		
		ColumnConstraints firstCol = new ColumnConstraints();
		firstCol.setHgrow(Priority.ALWAYS);
		ColumnConstraints lastCol = new ColumnConstraints();
		lastCol.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(firstCol, new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), lastCol);
		
	}
	
	private void addRegisterListeners() {
	}


	private void addListeners() {
		ChooseCards.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				c.getBoardScene().clearAllActiveCards();
				c.nextScene();
				c.notifyAllRobotObservers();
				
				// c.setProgrammingPhaseScene(new ProgrammingPhaseScene(c));
				// c.setTheScene(c.getProgrammingPhaseScene(), "Choose Cards!!");
				// c.notifyAllRobotObservers();
			}
		});

		// uTurn.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Uturn());
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		
		// moveF1.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Forward(1));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
				
		// 	}
		// });
		// moveF2.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Forward(2));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		// moveF3.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Forward(3));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		
		// moveB1.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(1));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		// moveB2.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(2));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		// moveB3.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(3));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		
		// turnL.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new TurnLeft(1));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });
		
		// turnR.setOnAction(new EventHandler<ActionEvent>() {
		// 	@Override
		// 	public void handle(ActionEvent event) {
		// 		c.getCurrentPlayer().getRobot().AddToRegister(new TurnRight(1));
		// 		c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
		// 	}
		// });

		Activate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {

					Task<Void> task = new Task<Void>() {
						@Override
						protected Void call() throws Exception {
							c.getBoardController().runAllRegisters();
							return null;
						}
					};
					new Thread(task).start();}
		});
	}
}
