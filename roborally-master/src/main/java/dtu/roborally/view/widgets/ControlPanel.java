package dtu.roborally.view.widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;

public class ControlPanel extends GridPane {

	private Board board;
	private Robot robot;
	
	private Button moveF1 = new Button("\u2191");
	private Button moveF2 = new Button("\u21D1");
	private Button moveF3 = new Button("\u290A");
	private Button moveB1 = new Button("\u2193");
	private Button moveB2 = new Button("\u21D3");
	private Button moveB3 = new Button("\u290B");
	private Button turnL = new Button("\u21B6");
	private Button turnR = new Button("\u21B7");
	private Button uTurn = new Button("\u27F2");
	private Button rekt = new Button("\u2716");
	
	public ControlPanel(Board board, Robot robot) {
		this.board = board;
		this.robot = robot;
		
		configure();
		addListeners();
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
		add(rekt, 4, 1);
		
		ColumnConstraints firstCol = new ColumnConstraints();
		firstCol.setHgrow(Priority.ALWAYS);
		ColumnConstraints lastCol = new ColumnConstraints();
		lastCol.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(firstCol, new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), lastCol);
		
	}
	
	private void addListeners() {
		uTurn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.turn(2, board);;
			}
		});
		
		moveF1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.moveforward(true, board);
			}
		});
		moveF2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 2; i++){
				robot.moveforward(true, board);
				}
			}
		});
		moveF3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 3; i++){
					robot.moveforward(true, board);
					}
			}
		});
		
		moveB1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.moveforward(false, board);
			}
		});
		moveB2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 2; i++){
				robot.moveforward(false, board);
				}
			}
		});
		moveB3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 3; i++){
					robot.moveforward(false, board);
					}
			}
		});
		
		turnL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.turn(-1, board);
			}
		});
		
		turnR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.turn(1, board);;
			}
		});

		rekt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.Death(board);
			}
		});
	}
}
