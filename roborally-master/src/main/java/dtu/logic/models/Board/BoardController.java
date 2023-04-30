package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Observers.BoardObserver;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import dtu.logic.models.AI;
import dtu.logic.models.Direction;

public class BoardController {
    private ArrayList<Player> players = new ArrayList<Player>();
    private LinkedHashSet<BoardObserver> boardObservers = new LinkedHashSet<BoardObserver>(1);
    private Board board;

    //Constructor
    public BoardController(Board board) {
        this.board = board;
    }

    public void registerBoardObserver(BoardObserver o) {
        this.boardObservers.add(o);
    }

    public void notifyLaserObservers(Lazer laser) {
        for (BoardObserver o : this.boardObservers) {
            o.updateLaser(laser);
        }
    }

    public void notifyNewAction(ActionCard actionCard) {
        for (BoardObserver o : this.boardObservers) {
            o.updateNewAction(actionCard);
        }
    }

    public void notifyCardRemove(Player player, String cardImageString){
        for (BoardObserver o : this.boardObservers) {
            o.updateCardTaken(player, cardImageString);
        }
	}
    
    public void fireboardLazers() {
        for (int i=0; i<13; i++){
            for (int j=0; j<10; j++){
                Tile tile = this.getBoard().getTileAt(new Position(j,i));
                if (tile instanceof TileLazer){
                    
                    TileLazer TL = (TileLazer) tile;
                    TL.FIRE(this);
                }
            }
        }
    }

    public void emptyAllRegisters() {
        for (int i = 0; i < this.players.size(); i++) {
            Robot r = this.players.get(i).getRobot();
            r.setRegister(new ArrayList<ProgramCard>());
        }
    }

    public void runAllRegisters() {
        for (int i=0; i<5;i++){
            for (int j = 0; j < this.players.size(); j++) {
                Robot r = this.players.get(j).getRobot();
               
                if (r.getRegister().size() > i){
                    notifyCardRemove(this.players.get(j), r.getRegister().get(i).getImage());
                    r.moveByCard(this, r.getRegister().get(i));
                }
                
                if (i == 4){
                    r.getRegister().clear();
                }
                try {
                   //Thread.sleep(2000);
                 } catch (Exception e) { System.err.println(e); }
            }
            RunAllEffects();
            fireRobotLazers();
            fireboardLazers();
            try {
               //Thread.sleep(100);
             } catch (Exception e) { System.err.println(e); }
        }
        this.emptyAllRegisters();
        for (Player p : players) {
            p.getRobot().robotNotify();
        }
    }

    //Checking all holes posiitions
    public void runAllHoles(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 13; j++){
                if (this.getBoard().getTileAt(new Position(i,j)) instanceof TileHole){
                    if (this.getBoard().getTileAt(new Position(i,j)).isOcupied()) {
                        this.getBoard().getTileAt(new Position(i,j)).effect(getRobotAt(new Position(i,j)), this);
                    }
                }
            }
        }
    }

    //Going through effects on board
    public void RunAllEffects(){
    int r;
    int c;
       
        for (int i = 0; i < 10; i++){
            if (i % 3 == 1){
                c = 2 - (int)Math.floor(i/3);}
            else if (i % 3 == 2){
                c = 5 - (int)Math.floor(i/3);}
            else{c = 9 - i/3;}
               
            for (int j = 0; j < 13; j++){
               
                if (j % 3 == 1){
                    r = 3 - (int)Math.floor(j/3);}
                else if (j % 3 == 2){
                    r = 7 - (int)Math.floor(j/3);}
                else{r = 12 - j/3;}
                   
               
                if (this.getBoard().getTileAt(new Position(c,r)).isOcupied()) {
                    this.getBoard().getTileAt(new Position(c,r)).effect(getRobotAt(new Position(c,r)), this);
                }
            }
        }
        for (Player p : players) {
            getBoard().getTileAt(p.getRobot().getPos()).Occupy();
            p.getRobot().robotNotify();
        }
    }
    
    public void fireRobotLazers(){
        for (int i = 0; i < this.players.size(); i++){
            players.get(i).getRobot().FIRE(this);
        }
    }

    public void addAI(AI ai){
        for (int i = 0; i < this.players.size(); i++){
            if (players.get(i).getName()  ==  (ai.getName())){
                ai = new AI(new Robot(ai.getRobot().getRobotColor())); 
            }
        }

        addPlayer(ai);
        return;
    }

    public void addPlayer(Player player){
        boolean allowed = true;

        for (int i = 0; i < this.players.size(); i++){
            if (players.get(i).getRobot().getRobotColor()  ==  (player.getRobot().getRobotColor())){
                allowed = false;   
            }
        }

        if (allowed){ 
            players.add(player);
        }
    }

    public void moveRobot(Robot robot,Position pos){
        this.board.getTileAt(robot.getPos()).unOccupy();
        robot.setPos(pos);
        this.board.getTileAt(robot.getPos()).Occupy();
    }

    public void wipePlayers(){
        players=new ArrayList<Player>();
    }

    // check if a robot is allowed a move
    public boolean allowmove(Robot robot, Direction dir){
        
        Position toPos = robot.getPosInDir(dir);
        
        if (toPos.getRow()>=0 && toPos.getColumn()>=0 && toPos.getColumn()<10 && toPos.getRow()<13){
                
                if (this.board.getTileAt(robot.getPos()) instanceof TileWall){
                    TileWall WT = (TileWall) this.board.getTileAt(robot.getPos());
                    if (dir.getId() == WT.getDirID()){
                        return false;
                    } 
                    
                }
               
                if (this.board.getTileAt(toPos) instanceof TileWall){
                    TileWall WT = (TileWall) this.board.getTileAt(toPos);

                    if (Math.abs(dir.getId() - WT.getDirID()) == 2){return false;} 
                    
                }

                
                if (getRobotAt(toPos) != null){
                    if (this.board.getTileAt(toPos).isOcupied()){getRobotAt(toPos).takeDmg(this);
                                                   
                                                    
                                                    if (getRobotAt(toPos) != null){
                                                        return allowmove(getRobotAt(toPos),dir);
                                                    }
                                                    else{
                                                        return true;
                                                    }
                    }
                    else{return true;}
                }
                else{return true;}  
                
        }
        else{return true;} 
    }

    public boolean allowmove(Lazer lazer){
        if (this.getBoard().getTileAt(lazer.getPos()) instanceof TileWall){
            TileWall WT = (TileWall) this.getBoard().getTileAt(lazer.getPos());
            if (lazer.getdir().getId() == WT.getDirID()){return false;}   
        }
        if (this.getBoard().getTileAt(lazer.getPosInDir(lazer.getdir())) instanceof TileWall){
            TileWall WT = (TileWall) this.getBoard().getTileAt(lazer.getPosInDir(lazer.getdir()));
            if (Math.abs(lazer.getdir().getId() - WT.getDirID()) == 2){return false;}
            else{return true;}
        }
        else {return true;} 
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public Player getPlayerByName(String name) {
        for (int i = 0; i < this.players.size(); i++){
            if (players.get(i).getName().equals(name)){
                return players.get(i);
            }
        }
        return null;
    }

    public Robot getRobotAt(Position pos){
      
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<10 && pos.getRow()<13) {
            
            for (int i = 0; i < this.players.size(); i++){
                if (players.get(i).getRobot().getPos().equals(pos)){
                    return players.get(i).getRobot();
                }   
            }
            return null;
        }
        else{
            return null;
        }
    }
    
    public Player getPlayerByColor(RobotColor color){
            for (int i = 0; i < this.players.size(); i++){
                if (players.get(i).getRobot().getRobotColor().equals(color)){
                    return players.get(i);
                }   
            }
            return null;
    }
}
