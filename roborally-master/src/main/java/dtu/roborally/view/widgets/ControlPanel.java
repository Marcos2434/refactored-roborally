package dtu.roborally.view.widgets;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import dtu.controller.Controller;
import dtu.view.ProgrammingPhaseScene;
import dtu.logic.models.Cards.MovementCards.*;

public class ControlPanel extends GridPane {

	private Controller c;
	
	
	// ObservableList<String> players = FXCollections.observableArrayList();
	final ComboBox<String> comboBox = new ComboBox<String>();
	

	
	private Button ChooseCards = new Button("Choose cards");
	private Button moveF1 = new Button("\u2191");
	private Button moveF2 = new Button("\u21D1");
	private Button moveF3 = new Button("\u290A");
	private Button moveB1 = new Button("\u2193");
	private Button moveB2 = new Button("\u21D3");
	private Button moveB3 = new Button("\u290B");
	private Button turnL = new Button("\u21B6");
	private Button turnR = new Button("\u21B7");
	private Button uTurn = new Button("\u27F2");
	private Button Activate = new Button("Activate register");
	
	public ControlPanel(Controller c) {
		this.c = c;
		configure();
		addListeners();
	}

	public void notifyCardRan(){

	}

	
	public void addPlayerNamesToDropdown() {
		
		comboBox.getItems().addAll(c.getPlayersNames());
		comboBox.setValue("Select a player");
		comboBox.setOnAction(event -> {
			
			String selectedOption = comboBox.getSelectionModel().getSelectedItem();
			System.out.println("Selected register: " + selectedOption);

			c.setCurrentPlayer(c.getBoardController().getPlayerByName(selectedOption));

		});
	}

	private void configure() {
		add(moveF1, 2, 0);
		add(moveF2, 1, 0);
		add(moveF3, 3, 0);
		add(turnL, 1, 1);
		add(uTurn, 2, 1);
		add(turnR, 3, 1);
		add(moveB1, 2, 2);
		add(moveB2, 1, 2);
		add(moveB3, 3, 2);
		add(Activate, 4, 1);
		add(ChooseCards,0,7);

		add(comboBox, 0, 5);
		
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
				c.setProgrammingPhaseScene(new ProgrammingPhaseScene(c));
				c.setTheScene(c.getProgrammingPhaseScene(), "Choose Cards!!");
				c.notifyAllRobotObservers();
			}
		});
		uTurn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Uturn());
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		
		moveF1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Forward(1));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
				
			}
		});
		moveF2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Forward(2));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		moveF3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Forward(3));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		
		moveB1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(1));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		moveB2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(2));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		moveB3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new Backwards(3));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		
		turnL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new TurnLeft(1));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});
		
		turnR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentPlayer().getRobot().AddToRegister(new TurnRight(1));
				c.getBoardScene().getPlayermat(c.getCurrentPlayer().getName()).addRegister();
			}
		});

		Activate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (c.getCurrentPlayer().getRobot().register.size() > 0) {
					Task<Void> task = new Task<Void>() {
						@Override
						protected Void call() throws Exception {
							c.getBoardController().runAllRegisters();
							return null;
						}
					};
					new Thread(task).start();}
				else{
					System.out.println("Register is empty");
				}
				
				
			}
		});
	}
}
