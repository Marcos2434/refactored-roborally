package dtu.controller;

import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;

import java.util.ArrayList;

import dtu.logic.models.RobotColor;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
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
    private BoardController boardController;
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
        this.boardController = new BoardController(board);
    }

    public Board getBoard() {
        return board;
    }

    public void createPlayer(RobotColor color, String name) {
        this.players.add(new Player(new Robot(color), name));
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

    public void setProgrammingPhaseScene(ProgrammingPhaseScene programmingPhaseScene) {
        this.programmingPhaseScene = programmingPhaseScene;
    }

    public ProgrammingPhaseScene getProgrammingPhaseScene() {
        return programmingPhaseScene;
    }

    // public void setProgrammingPhaseSceneSimple(ProgrammingPhaseSceneSimple programmingPhaseSceneSimple) {
    //     this.programmingPhaseSceneSimple = programmingPhaseSceneSimple;
    // }

    // public ProgrammingPhaseSceneSimple getProgrammingPhaseSceneSimple() {
    //     return programmingPhaseSceneSimple;
    // }

    public BoardController getBoardController() {
        return boardController;
    }

    private void startGame() {

        // Find spawn positions
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
                    this.availableBoardSpawns.add(new Position(i, j));                            
                }
            }
        }
        
        // Set robot to positions
        this.boardController.initPlayers();
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).getRobot().setPos(this.availableBoardSpawns.get(i));            
            this.boardController.addPlayer(this.players.get(i));
            this.boardController.getBoard().getTileAt(this.availableBoardSpawns.get(i)).Occupy(
                this.players.get(i).getRobot().getImage(), this.players.get(i).getRobot().getDirID());;
        }

        
        // try {this.board.initPlayers();
        // }
        // catch (Exception ex) { ex.getCause(); }
        // board.moveRobot(robot, new Position(3, 10));

    }
}
