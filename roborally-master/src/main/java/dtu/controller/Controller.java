package dtu.controller;

import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;

import java.util.ArrayList;

import dtu.logic.models.Color;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import javafx.stage.Stage;
import dtu.view.BoardScene;
import dtu.view.MenuScene;
import javafx.scene.Scene;

import dtu.logic.models.Board.TileType;
import dtu.logic.models.Board.TileStart;

public class Controller {

    private ArrayList<Player> players = new ArrayList<Player>();

    // --- Scenes ---
    private MenuScene menuScene;
    private BoardScene boardScene;
    // --------------
    private Stage primaryStage;

    private Board board;
    ArrayList<Position> availableBoardSpawns = new ArrayList<Position>();



    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void launch() {
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void createPlayer(Color color, String name) {
        this.players.add(new Player(new Robot(color), name));
        System.out.println(name + " has chosen color " + color + "!");
    };

    public void changeToBoardScene(){
        this.setTheScene(this.getBoardScene(), "Roborally!");
        this.startGame();
    }

    public void setMenuScene(MenuScene s) {
        this.menuScene = s;
    }

    public MenuScene getMenuScene() {
        return menuScene;
    }

    public void setTheScene(Scene s) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle("Roborally - v. 0.1");
        this.primaryStage.show();
    }

    public BoardScene getBoardScene() {
        return boardScene;
    }

    public void setBoardScene(BoardScene boardScene) {
        this.boardScene = boardScene;
    }

    public void setTheScene(Scene s, String title) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle(title);
        this.primaryStage.show();
    }



    private void startGame() {
        // Find spawn positions
        Board b = this.getBoard();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
                    this.availableBoardSpawns.add(new Position(i, j));                            
                }
            }
        }
        
        // Set robot to positions
        this.board.initPlayers();
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).getRobot().setPos(this.availableBoardSpawns.get(i));
            
            // TODO: temporary?
            this.board.addPlayer(this.players.get(i));
            this.board.getTileAt(this.availableBoardSpawns.get(i)).Occupy(
                this.players.get(i).getRobot().getImage(), this.players.get(i).getRobot().getDirID());;
        }


        // try {this.board.initPlayers();
        // }
        // catch (Exception ex) { ex.getCause(); }
        // board.moveRobot(robot, new Position(3, 10));

    }
}
