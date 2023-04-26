package dtu.view;

import javafx.scene.layout.BorderPane;

import java.lang.reflect.InvocationTargetException;

import dtu.controller.Controller;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.scene.Scene;
import dtu.logic.models.RobotColor;

class Tuple<A, B> {
    private A first;
    private B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

public class BoardScene extends Scene {

    Controller c;
    ControlPanel cp;

    public BoardScene(Controller c) {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }
    

    private void initialize() {
        BorderPane boardPane = (BorderPane) this.getRoot();

		String[][] board1 = {
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","C 1","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","BT 2 1","BT 2 1","BT 2 1","BT 2 1","BT 2 1","T","T","T"},
            {"T","T","BT 1 1","BT 4 1","LT 4","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","C 3","T"},
            {"C 2","T","HT","BT 1 2","BT 4 2","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            // Start Field
            {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
            {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
            {"S","T","T","S","T","T","S","T","T","S"},
        };
        

		// Robot robot = new Robot(RobotColor.BLUE, new Position(3, 10));
        // ControlPanel cp = new ControlPanel(c, robot);
        
        
        
        
        
        /*try {c.getBoardController().initPlayers();
            c.getBoardController().addPlayer(new Player(robot,"Casper"));
        }
        catch (Exception ex) { ex.getCause(); }
        c.getBoardController().moveRobot(robot,new Position(3, 10));*/
		
		
        //cp.addplayer(new Player(cp.getrobot(),"Casper"));
		// boardPane.setRight(cp);
        
        
        // Creating the board
        Board board = new Board(board1);
        c.setBoard(board);
		boardPane.setCenter(board);

        // Register control panel
        cp = new ControlPanel(c);
        boardPane.setRight(cp);
    }

    public ControlPanel getControlPanel() {
        return this.cp;
    }

}
