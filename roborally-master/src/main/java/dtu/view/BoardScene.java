package dtu.view;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.css.Size;
import dtu.controller.Controller;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    BorderPane boardPane;
    Controller c;
    HBox leftSide = new HBox();
    ArrayList<Playermat> pMats = new ArrayList<>();
    VBox playersUIright = new VBox();
    VBox playersUIleft = new VBox();

    public void setPlayermats(ArrayList<Player> players){
        if (players.size() <= 4){
            for (int i = 0; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }
            boardPane.setRight(playersUIright);
        } 
        
        else {
            for (int i = 0; i < 4; i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }
            boardPane.setRight(playersUIright);
            for (int i = 4; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIleft.getChildren().add(p1);
                pMats.add(p1);
            }
            boardPane.setLeft(playersUIleft);
        }
        // boardPane.setRight(playersUIright);
        // leftSide.getChildren().add(playersUIleft);

    }

    public BoardScene(Controller c) throws IOException {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }
    

    private void initialize() throws IOException {
        boardPane = (BorderPane) this.getRoot();



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
        

        Board board = new Board(board1);
		Robot robot = new Robot(RobotColor.BLUE, new Position(3, 10));
        ControlPanel cp = new ControlPanel(c, robot);


        c.setBoard(board);

        

        /*try {c.getBoardController().initPlayers();
             c.getBoardController().addPlayer(new Player(robot,"Casper"));
         }
        catch (Exception ex) { ex.getCause(); }
        c.getBoardController().moveRobot(robot,new Position(3, 10));*/
		
		
        //cp.addplayer(new Player(cp.getrobot(),"Casper"));
		boardPane.setCenter(board);
        // leftSide.getChildren().add(cp);

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(robot, "Komv"));
        players.add(new Player(robot, "Egle"));
        players.add(new Player(robot, "Malév"));
        players.add(new Player(robot, "GT"));
        players.add(new Player(robot, "Komv"));
        players.add(new Player(robot, "Egle"));
        players.add(new Player(robot, "Malév"));
        players.add(new Player(robot, "GT"));
        setPlayermats(players);

		boardPane.setBottom(cp);
    }
}
