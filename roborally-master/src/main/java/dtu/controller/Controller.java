package dtu.controller;

import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.AI;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import java.util.ArrayList;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import javafx.stage.Stage;
import dtu.view.BoardScene;
import dtu.view.MenuScene;
import dtu.view.ProgrammingPhaseScene;
import dtu.view.StartMenuScene;
// import dtu.view.ProgrammingPhaseSceneSimple;
import javafx.scene.Scene;
import dtu.logic.models.Board.TileType;
import dtu.logic.models.Board.TileStart;

public class Controller {

    // --- Scenes ---
    private StartMenuScene startMenuScene;
    private MenuScene menuScene;
    private BoardScene boardScene;
    private ProgrammingPhaseScene programmingPhaseScene;
    
    // private ProgrammingPhaseSceneSimple programmingPhaseSceneSimple;
    // --------------
    private Stage primaryStage;
    
    private Board board;
    private String boardSelecter = null;
    private BoardController boardController;
    ArrayList<Position> availableBoardSpawns = new ArrayList<Position>();

    private Player currentPlayer;
    
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void launch() {
        //this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
        //this.setTheScene(this.getStartScene(), "Pick the type of play");
        //this.setTheScene(this.getProgrammingPhaseScene(), "Roborally - Programming Phase"); //for natalia
        // this.setTheScene(this.getProgrammingPhaseSceneSimple(), "Roborally - Programming Phase"); //for oli/gleb

    }
    //asd
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void createAI(RobotColor color){
        this.boardController.addAI(new AI(new Robot(color)));
    }

    public void setBoard(Board board) {
        this.board = board;
        //this.availableBoardSpawns = this.board.getStartFields();
        this.boardController = new BoardController(board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoardSelecter(String SelBoard) {
        this.boardSelecter = SelBoard;
    }

    public String getBoardSelecter(){
        return this.boardSelecter;
    }
    public void notifyAllRobotObservers() {
        for (int i = 0; i < this.boardController.getPlayers().size(); i++) {
            this.boardController.getPlayers().get(i).getRobot().robotNotify();
        }
    }

    public void createPlayer(RobotColor color, String name) {
        Robot robot = new Robot(color);
        robot.registerObserver(this.boardScene);
        this.boardController.addPlayer(new Player(robot, name));
        System.out.println(name + " has chosen color " + color);
    };

    public void changeToBoardScene() {
        this.boardScene.setPlayermats(this.boardController.getPlayers());
        this.setTheScene(this.getBoardScene(), "Roborally!");
        this.spawnRobots();
    }

    public void backToBoardScene() {
        this.setTheScene(this.getBoardScene(), "Roborally!");
    }

    public void setStartScene(StartMenuScene StartMenu){
        this.startMenuScene = StartMenu;
    }

    public StartMenuScene getStartScene(){
        return this.startMenuScene;
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
        // Register the scene as a robot observer
        for (int i = 0; i < this.boardController.getPlayers().size(); i++) {
            this.boardController.getPlayers().get(i).getRobot().registerObserver(this.programmingPhaseScene);
        }
    }

    public ProgrammingPhaseScene getProgrammingPhaseScene() {
        return programmingPhaseScene;
    }

  

    public BoardController getBoardController() {
        return boardController;
    }

    public ArrayList<String> getPlayersNames() {
        ArrayList<String> playerNames = new ArrayList<String>();
        for (Player i: this.boardController.getPlayers()) {
            if (i.isAI() == false) {
                playerNames.add(i.getName());
            }
        }
        return playerNames;
    }

    public void spawnRobots() {
        // Find spawn positions
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
                    this.availableBoardSpawns.add(new Position(i, j));               
                }
            }
        }
        
        // Set robot to positions
        for (int i = 0; i < this.boardController.getPlayers().size(); i++) {
            // place robot on scene
            // this.boardController.getBoard().getTileAt(this.availableBoardSpawns.get(i)).Occupy(this.boardController.getPlayers().get(i).getRobot().getImage(), this.boardController.getPlayers().get(i).getRobot().getDirID());
            this.boardController.getBoard().getTileAt(this.availableBoardSpawns.get(i)).Occupy();
            
            // place robot on board
            this.boardController.getPlayers().get(i).getRobot().setPos(this.availableBoardSpawns.get(i));
            
            // set initial checkpoint
            this.boardController.getPlayers().get(i).getRobot().addCheckpoint(this.availableBoardSpawns.get(i));
        }
    }
}
