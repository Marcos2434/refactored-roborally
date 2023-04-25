package dtu.view;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import dtu.controller.Controller;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import dtu.logic.models.Color;


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

    public BoardScene(Controller c) throws IOException {
        super(new BorderPane());
        this.initialize();
        this.c = c;
    }
    

    private void initialize() throws IOException {
        BorderPane boardPane = (BorderPane) this.getRoot();



		String[][] board1 = {
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","C 1","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","BT 2 1","BT 2 1","BT 2 1","HT","T","T","T","T"},
            {"T","T","BT 1 1","BT 4 1","LT 4","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","C 3","T"},
            {"C 2","T","HT","BT 1 2","BT 4 2","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            // Start Field
            {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
            {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
            {"T","T","T","S","T","T","S","T","T","T"},
        };
        

        Board board = new Board(board1);
		Robot robot = new Robot(Color.BLUE, new Position(3, 12));
		// Pane p1 = FXMLLoader.load(getClass().getClassLoader().getResource("playermat/playermat.fxml"));
        // Pane p2 = FXMLLoader.load(getClass().getClassLoader().getResource("playermat/playermat.fxml"));
        // Pane p3 = FXMLLoader.load(getClass().getClassLoader().getResource("playermat/playermat.fxml"));
        // Pane p4 = FXMLLoader.load(getClass().getClassLoader().getResource("playermat/playermat.fxml"));

        Playermat p1 = new Playermat(new Player(robot, "Egle"));

        // StackPane p1 = new StackPane();
        // Image backgroundpic = new Image("playermat/playermat.png");
        // ImageView background = new ImageView(backgroundpic);
        // Label pName = new Label("Komv");
        // p1.getChildren().addAll(background, pName);
        VBox playersUI = new VBox(p1);

		ControlPanel cp = new ControlPanel(board, robot);
		boardPane.setCenter(board);
		boardPane.setBottom(cp);
        boardPane.setRight(playersUI);

        
    }
}
