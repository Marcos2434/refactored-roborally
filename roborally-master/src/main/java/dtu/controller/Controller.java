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
import javafx.scene.Scene;
import dtu.logic.models.Board.TileType;
import dtu.logic.models.Board.TileStart;
import dtu.view.WinScene;


public class Controller {

    // -------------- Scenes --------------
    private Stage primaryStage;
    private MenuScene menuScene;
    private BoardScene boardScene;
    private ProgrammingPhaseScene programmingPhaseScene;
    // ------------------------------------

    
    private static int count;
    private WinScene winScene;
    private Board board;
    private int boardSelecter = 0;
    private BoardController boardController;
    private ArrayList<Player> realPlayers = new ArrayList<Player>();
    private ArrayList<Player> Ais = new ArrayList<Player>();
    private Player winner=null;
    private Player currentPlayer;
    private ArrayList<Player> playersAlive = new ArrayList<Player>();
    private MusicController musicController;
    ArrayList<Position> availableBoardSpawns = new ArrayList<Position>();

    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    // Starting from the start menu scene
    public void launch() {
        this.musicController = new MusicController();
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
    }

    // Creating list of alive players
    public void checkPlayersAlive(){
        playersAlive.clear();
        for (Player i : boardController.getPlayers()) {
            if (i.getRobot().getLives() > 0) {
                playersAlive.add(i);
            }
        }
    }

    // Creating AI and adding it to all the players
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

    //Creating player and adding to all players
    public void createPlayer(RobotColor color, String name) {
        Robot robot = new Robot(color);
        robot.registerObserver(this.boardScene);
        if (name.isEmpty()) {

            name=color.toString();
        }
        this.boardController.addPlayer(new Player(robot, name));
    };

    //Notifying all robot observers
    public void notifyAllRobotObservers() {
        for (int i = 0; i < this.boardController.getPlayers().size(); i++) {
            this.boardController.getPlayers().get(i).getRobot().robotNotify();
        }
    }

    public void setTheScene(Scene s) {
        // We set THE Scene, meaning we show the scene on the stage
        this.primaryStage.setScene(s);
        primaryStage.setTitle("Roborally!");
        this.primaryStage.show();
    }

    public void setTheScene(Scene s, String title) {
        // We set THE Scene, meaning we show the scene on the stage
        // We used method overloading in case we want to specify a title for the scene
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
        
        for (Player p : getBoardController().getPlayers()){
            if (p.getRobot().getCheckpointCount() == 3){
            winner=p;
            this.realPlayers= new ArrayList<Player>();
            this.playersAlive= new ArrayList<Player>();
            setWinScene();
            setTheScene(getWinScene(), "Winner!!!");
            return;
            }
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
        if (getCount() < realPlayers.size()-1){
            if (realPlayers.get(getCount()+1).getRobot().getLives()<=0){
                addCount();
            }
        }
      
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

    public ArrayList<String> getPlayersNames() {
        ArrayList<String> playerNames = new ArrayList<String>();
        for (Player i: this.boardController.getPlayers()) {
            if (!i.isAI()) {
                playerNames.add(i.getName());
            }
        }
        return playerNames;
    }

    public void changeToBoardScene() {
        boardScene.setPlayermats(boardController.getPlayers());
        this.setTheScene(this.getBoardScene(), "Roborally!");
        this.spawnRobots();
    }

    public void backToBoardScene() {
        this.setTheScene(this.getBoardScene(), "Roborally!");
    }

    public void setMenuScene(MenuScene s) {
        this.menuScene = s;
    }

    //Getting menu
    public MenuScene getMenuScene() {
        return menuScene;
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

    public ProgrammingPhaseScene getProgrammingPhaseScene() {
        return programmingPhaseScene;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public void setRealPlayers(){
		for (Player i : getBoardController().getPlayers()) {
			if (!i.isAI()){
				realPlayers.add(i);
			}
            else {
                Ais.add(i);
            }
		}
    }

    public ArrayList<Player> getRealPlayers(){
        return this.realPlayers;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
        // A board controller is created along with the board
        this.boardController = new BoardController(board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoardSelecter(int SelBoard) {
        this.boardSelecter = SelBoard;
    }

    public int getBoardSelecter(){
        return this.boardSelecter;
    }

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
}
