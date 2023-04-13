package dtu.roborally.view.widgets;


import dtu.roborally.view.CardinalPoints;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import dtu.logic.models.Direction;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;

public class ControlPanel extends GridPane {

	private Board board;
	private Robot robot;
	
	private Button rotate = new Button("\u2b6e");
	private Button moveN = new Button("\u2b9d");
	private Button moveS = new Button("\u2b9f");
	private Button moveW = new Button("\u2b9c");
	private Button moveE = new Button("\u2b9e");
	
	public ControlPanel(Board board) {
		this.board = board;
		
		configure();
		addListeners();
	}
	
	private void configure() {
		add(moveN, 2, 0);
		add(moveW, 1, 1);
		add(rotate, 2, 1);
		add(moveE, 3, 1);
		add(moveS, 2, 2);
		
		ColumnConstraints firstCol = new ColumnConstraints();
		firstCol.setHgrow(Priority.ALWAYS);
		ColumnConstraints lastCol = new ColumnConstraints();
		lastCol.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(firstCol, new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), lastCol);
		
	}
	
	private void addListeners() {
		rotate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.turn(1);
			}
		});
		
		moveN.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.setY(robot.getY()-1);
			}
		});
		
		moveS.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.setY(robot.getY()+1);
			}
		});
		
		moveW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.setX(robot.getX()-1);
			}
		});
		
		moveE.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				robot.setX(robot.getX()+1);
			}
		});
	}
}
