package dtu.controller;

import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;

import java.util.ArrayList;

import dtu.logic.models.RobotColor;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import javafx.stage.Stage;
import dtu.view.BoardScene;
import dtu.view.MenuScene;
import dtu.view.ProgrammingPhaseScene;
// import dtu.view.ProgrammingPhaseSceneSimple;
import javafx.scene.Scene;

import dtu.logic.models.Board.TileType;
import dtu.logic.models.Board.TileStart;

public class Controller {

    private ArrayList<Player> players = new ArrayList<Player>();

    // --- Scenes ---
    private MenuScene menuScene;
    private BoardScene boardScene;
    private ProgrammingPhaseScene programmingPhaseScene;
    // private ProgrammingPhaseSceneSimple programmingPhaseSceneSimple;
    // --------------
    private Stage primaryStage;

    private Board board;
    ArrayList<Position> availableBoardSpawns = new ArrayList<Position>();



    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void launch() {
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");

        //this.setTheScene(this.getProgrammingPhaseScene(), "Roborally - Programming Phase"); //for natalia
        // this.setTheScene(this.getProgrammingPhaseSceneSimple(), "Roborally - Programming Phase"); //for oli/gleb

    }

    public void setBoard(Board board) {
        this.board = board;
        this.availableBoardSpawns = this.board.getStartFields();
    }

    public Board getBoard() {
        return board;
    }

    private Position randomSpawn(){
        int randID = (int)(Math.random() * availableBoardSpawns.size()-1);
        Position randPos = availableBoardSpawns.get(randID);
        availableBoardSpawns.remove(randID);
        return randPos;

    }

    public void createPlayer(RobotColor color, String name) {
        this.players.add(new Player(new Robot(color, randomSpawn()), name));
        // this.players.add(new Player(new Robot(color, new Position(2, 2)),name));
        System.out.println(name + " has chosen color " + color);
    };

    public void changeToBoardScene(){
        // this.boardScene.setPlayermats(players);
        this.setTheScene(this.getBoardScene(), "Roborally!");
        // this.startGame();
    }

    public void setMenuScene(MenuScene s) {
        this.menuScene = s;
    }

    public MenuScene getMenuScene() {
        return menuScene;
    }

    public void setTheScene(Scene s) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle("Roborally - 0.5 - Playermat update");
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

    public void setProgrammingPhaseScene(ProgrammingPhaseScene programmingPhaseScene) {
        this.programmingPhaseScene = programmingPhaseScene;
    }

    public ProgrammingPhaseScene getProgrammingPhaseScene() {
        return programmingPhaseScene;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    // public void setProgrammingPhaseSceneSimple(ProgrammingPhaseSceneSimple programmingPhaseSceneSimple) {
    //     this.programmingPhaseSceneSimple = programmingPhaseSceneSimple;
    // }

    // public ProgrammingPhaseSceneSimple getProgrammingPhaseSceneSimple() {
    //     return programmingPhaseSceneSimple;
    // }



    private void startGame() {
        Board b = this.getBoard();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
                    this.availableBoardSpawns.add(new Position(i, j));                            
                }
            }
        }
  

    }
}
