package dtu.roborally.view.widgets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import dtu.controller.Controller;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Cards.MovementCards.*;

public class ControlPanel extends GridPane {

	private Controller c;
	private Robot robot;
	
	// ObservableList<String> players = FXCollections.observableArrayList();
	final ComboBox<String> comboBox = new ComboBox<String>();


	private Button addPlayer = new Button("Add Player");
	
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

	public ControlPanel(Controller c, Robot robot) {
		this.c = c;
		this.robot = robot;
		//this.board.addPlayer(new Player(robot, "Casper"));
		
		configure();
		// addListeners();
		addRegisterListeners();
	}
	
	public void addPlayerNamesToDropdown() {
		System.out.println(c.getPlayersNames());
		comboBox.getItems().addAll(c.getPlayersNames());

		comboBox.setOnAction(event -> {
			String selectedOption = comboBox.getSelectionModel().getSelectedItem();
			System.out.println("Selected register: " + selectedOption);

			c.setCurrentRobot(c.getBoardController().getPlayerByName(selectedOption).getRobot());

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
		uTurn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Uturn());
			}
		});
		
		moveF1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				c.getCurrentRobot().AddToRegister(new Forward(1));
				
			}
		});
		moveF2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Forward(2));
			}
		});
		moveF3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Forward(3));
			}
		});
		
		moveB1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Backwards(1));
			}
		});
		moveB2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Backwards(2));
			}
		});
		moveB3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new Backwards(3));
			}
		});
		
		turnL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new TurnLeft(1));
			}
		});
		
		turnR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.getCurrentRobot().AddToRegister(new TurnRight(1));
			}
		});

		Activate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (c.getCurrentRobot().register.size() > 0) {
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
