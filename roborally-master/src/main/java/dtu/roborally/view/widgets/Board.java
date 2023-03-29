package dtu.roborally.view.widgets;

import java.util.Random;

import dtu.roborally.view.CardinalPoints;
import dtu.roborally.view.TileType;
import javafx.scene.layout.GridPane;

public class Board extends GridPane {

	private Random rnd = new Random();
	private Tile[][] board;
	private int rows;
	private int cols;
	private int currentRobotRow, currentRobotColumn;
	private CardinalPoints currentRobotDirection;
	
	public Board(int rows, int cols) {
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;

		loadBoard(); 
	}
	
	public void setRobot(int row, int col, CardinalPoints direction) {
		board[currentRobotRow][currentRobotColumn].unsetRobot();
		this.currentRobotColumn = col;
		this.currentRobotRow = row;
		this.currentRobotDirection = direction;
		board[row][col].setRobot(direction);
	}
	
	private void loadBoard() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(getRandomTileType());
				board[j][i] = t;
				add(t, i, j);
			}
		}
	}
	
	private TileType getRandomTileType() {
		double val = rnd.nextDouble();
		if (val < 0.88) {
			return TileType.OPEN_FLOOR;
		} else if (val < 0.92) {
			return TileType.PIT;
		} else if (val < 0.96) {
			return TileType.ACID;
		} else {
			return TileType.RADIATION;
		}
	}

	public CardinalPoints getCurrentRobotDirection() {
		return currentRobotDirection;
	}

	public int getCurrentRobotRow() {
		return currentRobotRow;
	}

	public int getCurrentRobotColumn() {
		return currentRobotColumn;
	}
}
