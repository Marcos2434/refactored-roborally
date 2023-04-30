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
import javafx.scene.Scene;
import dtu.logic.models.Board.TileType;
import dtu.logic.models.Board.TileStart;
import dtu.view.WinScene;
public class Controller {

    // --- Scenes ---
    private StartMenuScene startMenuScene;
    private MenuScene menuScene;
    private BoardScene boardScene;
    private ProgrammingPhaseScene programmingPhaseScene;
    private static int count;
    // --- Scenes ---
    private Stage primaryStage;
    private WinScene winScene;
    private Board board;
    private int boardSelecter = 0;
    private BoardController boardController;
    ArrayList<Position> availableBoardSpawns = new ArrayList<Position>();
    private ArrayList<Player> realPlayers = new ArrayList<Player>();
    private ArrayList<Player> Ais = new ArrayList<Player>();
    private Player winner=null;
    private Player currentPlayer;
    private ArrayList<Player> playersAlive= new ArrayList<Player>();

    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    //Starting from the start menu scene
    public void launch() {
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
    }

    //Setting current player
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    //Setting current player
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //Creating list of alive players
    public void checkPlayersAlive(){
        playersAlive.clear();
        for (Player i : boardController.getPlayers()) {
            if (i.getRobot().getLives()>0) {
                playersAlive.add(i);
            }
        }
    }

    //Creating AI and adding to all players
    public void createAI(RobotColor color, String name){
        Robot robot = new Robot(color);
        robot.registerObserver(this.boardScene);
        if (name.isEmpty()){
        this.boardController.addPlayer(new AI(robot));
        }
        else{
            this.boardController.addPlayer(new AI(robot,name));
        }
    }

    //Returning winner
    public Player getWinner(){
        return winner;
    }

    public void addCount(){
        count+=1;
    }

    public void count0(){
        count=0;
    }

    public int getCount(){
        return count;
    }

    //Creating player and adding to all players
    public void createPlayer(RobotColor color, String name) {
        Robot robot = new Robot(color);
        robot.registerObserver(this.boardScene);
        if (name.isEmpty()) {

            name=color.toString();
        }
        this.boardController.addPlayer(new Player(robot, name));
    };

    //Setting board in board controller
    public void setBoard(Board board) {
        this.board = board;
        this.boardController = new BoardController(board);
    }

    //Returning board
    public Board getBoard() {
        return board;
    }

    public void setBoardSelecter(int SelBoard) {
        this.boardSelecter = SelBoard;
    }

    public int getBoardSelecter(){
        return this.boardSelecter;
    }

    //Notifying all robot observers
    public void notifyAllRobotObservers() {
        for (int i = 0; i < this.boardController.getPlayers().size(); i++) {
            this.boardController.getPlayers().get(i).getRobot().robotNotify();
        }
    }

    //Switching to board scene
    public void changeToBoardScene() {
        boardScene.setPlayermats(boardController.getPlayers());
        this.setTheScene(this.getBoardScene(), "Roborally!");
        this.spawnRobots();
    }

    //Returning to board scene
    public void backToBoardScene() {
        this.setTheScene(this.getBoardScene(), "Roborally!");
    }

    //Setting start scene
    public void setStartScene(StartMenuScene StartMenu){
        this.startMenuScene = StartMenu;
    }

    //Getting start scene
    public StartMenuScene getStartScene(){
        return this.startMenuScene;
    }

    //Setting menu
    public void setMenuScene(MenuScene s) {
        this.menuScene = s;
    }

    //Getting menu
    public MenuScene getMenuScene() {
        return menuScene;
    }


    public void setTheScene(Scene s) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle("Roborally!");
        this.primaryStage.show();
    }

    public BoardScene getBoardScene() {
        return boardScene;
    }
    public void setWinScene(){
        this.winScene=new WinScene(this);
    }
    public WinScene getWinScene(){
        return winScene;
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
            if (!i.isAI()) {
                playerNames.add(i.getName());
            }
        }
        return playerNames;
    }

	public void nextScene(){
        checkPlayersAlive();
        if (playersAlive.size()==1){
            winner=playersAlive.get(0);
            this.realPlayers= new ArrayList<Player>();
            this.playersAlive= new ArrayList<Player>();
            setWinScene();
            setTheScene(getWinScene(), "Winner!!!");
            return;
        }
        if (playersAlive.size()==0){
            winner=null;
            this.realPlayers= new ArrayList<Player>();
            this.playersAlive= new ArrayList<Player>();
            setWinScene();
            setTheScene(getWinScene(), "Winner!!!");
            return;
        }
        
        this.boardScene.clearAllActiveCards();
		if (getCount()==realPlayers.size()){
			count0();
   
            getBoardScene().getControlPanel().setChoose(true);
            for (Player ai : Ais) {

                    ai.drawProgrammingCards();
                    ai.chooseProgrammingCards();
                    notifyAllRobotObservers();
                
            }
            this.getBoardController().registerBoardObserver(this.getBoardScene());
			setTheScene(getBoardScene(),"RoboRally!!");
		}
		else{
			setCurrentPlayer(realPlayers.get(getCount()));
			addCount();
			setProgrammingPhaseScene(new ProgrammingPhaseScene(this));
			setTheScene(getProgrammingPhaseScene(), getCurrentPlayer().getName());
		}   
        notifyAllRobotObservers();
        
    }
    public void getRealPlayers(){
		for (Player i : getBoardController().getPlayers()) {
			if (!i.isAI()){
				realPlayers.add(i);
			}
            else {
                Ais.add(i);
            }
		}

    }

    public void spawnRobots() {
        // Find spawn positions
        for (int j = 0; j < 13; j++){
            for (int i = 0; i < 10; i++) {
             
                if (this.getBoard().getTileAt(new Position(i,j)).equals(new TileStart(TileType.START))) {
                    this.availableBoardSpawns.add(new Position(i, j));               
                }
            }
        }
        // Set robot to positions
        for (int i = 0; i < this.boardController.getPlayers().size(); i++){

            // place robot on scene
            // this.boardController.getBoard().getTileAt(this.availableBoardSpawns.get(i)).Occupy(this.boardController.getPlayers().get(i).getRobot().getImage(), this.boardController.getPlayers().get(i).getRobot().getDirID());
            this.boardController.getBoard().getTileAt(this.availableBoardSpawns.get(i)).Occupy();
            
            // place robot on board
            try{
            this.boardController.getPlayers().get(i).getRobot().setPos(this.availableBoardSpawns.get(i));
            }catch(Exception e){;}
            
            
            // set initial checkpoint
            this.boardController.getPlayers().get(i).getRobot().addCheckpoint(this.availableBoardSpawns.get(i));
        }
    }
}
