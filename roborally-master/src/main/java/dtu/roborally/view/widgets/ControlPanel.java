package dtu.roborally.view.widgets;


import dtu.roborally.view.CardinalPoints;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ControlPanel extends GridPane {

	private Board board;
	
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
				CardinalPoints newDirection = CardinalPoints.N;
				switch (board.getCurrentRobotDirection()) {
				case N:
					newDirection = CardinalPoints.E;
					break;
				case E:
					newDirection = CardinalPoints.S;
					break;
				case S:
					newDirection = CardinalPoints.W;
					break;
				case W:
					newDirection = CardinalPoints.N;
					break;

				}
				board.setRobot(board.getCurrentRobotRow(), board.getCurrentRobotColumn(), newDirection);
			}
		});
		
		moveN.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				board.setRobot(
						Math.max(0, board.getCurrentRobotRow() - 1),
						board.getCurrentRobotColumn(),
						board.getCurrentRobotDirection());
			}
		});
		
		moveS.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				board.setRobot(
						Math.min(board.getRowCount() - 1, board.getCurrentRobotRow() + 1),
						board.getCurrentRobotColumn(),
						board.getCurrentRobotDirection());
			}
		});
		
		moveW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				board.setRobot(
						board.getCurrentRobotRow(),
						Math.max(0, board.getCurrentRobotColumn() - 1),
						board.getCurrentRobotDirection());
			}
		});
		
		moveE.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				board.setRobot(
						board.getCurrentRobotRow(),
						Math.min(board.getColumnCount() - 1, board.getCurrentRobotColumn() + 1),
						board.getCurrentRobotDirection());
			}
		});
	}
}
