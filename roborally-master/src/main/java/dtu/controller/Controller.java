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
        // this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void createPlayer(Color color, String name) {
        // this.players.add(new Player(new Robot(color, new Position(2, 2)),name));
        System.out.println(name + " has chosen color " + color);
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
        // Board b = this.getBoard();
        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 14; j++) {
        //         if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
        //             this.availableBoardSpawns.add(new Position(i, j));                 
        //             System.out.println(i);
        //             System.out.println(j);                
        //         }
        //     }
        // }
        // spawn players
        // for (int i = 0; i < this.players.size(); i++) {
        //     this.players.get(i).getRobot().setPosition(this.availableBoardSpawns.get(i));
        //     this.getBoard().setTileAt(this.players.get(i).getRobot().getPosition(), this.players.get(i).getRobot().getColor());
        // }

    }
}
