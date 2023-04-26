package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;
import java.util.ArrayList;

import dtu.logic.models.Direction;

public class BoardController {
    private Player[] players;
    private Board board;
    private static int nextPlayerIdx = 0;

    public BoardController(Board board) {
        this.board = board;
    }

    public void fireboardLazers(){
        for (int i=0; i<13; i++){
            for (int j=0; j<10; j++){
                Tile tile = this.getBoard().getTileAt(new Position(i,j));
                if (tile instanceof TileLazer){
                    TileLazer TL = (TileLazer)tile;
                    TL.FIRE(this);
                }
            }
        }
    }

    public void initPlayers(){
        players = new Player[8];
        nextPlayerIdx = 0;
    }

    public void runAllRegisters(){
        for (int i=0; i<5;i++){
            for (int j=0; j<nextPlayerIdx; j++){
                
            
                Robot r = players[j].getRobot();

                if (r.getRegister().size() > i){
                    r.moveByCard(this, r.getRegister().get(i));
                }

                if (i == 4){
                    r.setRegister(new ArrayList<ProgramCard>());
                }

                //try{Thread.sleep(200);}
                //catch(Exception e){System.out.println(e);}
            }
            
            
            RunAllEffects();
            
            fireRobotLazers();
            fireboardLazers();
        }
    }
    public void RunAllEffects(){
        int c;
        int r;
        for (int i = 0; i < 10; i++){
           /* 
            if (i % 2 == 1){

                c = 4 - (int)Math.floor(i/2);
            }

            else{c = 9 - i/2;}
            */
            for (int j = 0; j < 13; j++){
               /* 
                if (i % 2 == 1){
                    r = 6 - (int)Math.floor(j/2);}
                else{r = 12 - j/2;}
               */
                if (this.getBoard().getTileAt(new Position(i,j)).isOcupied()){
                    
                    this.getBoard().getTileAt(new Position(i,j)).effect(getRobotAt(new Position(i,j)), this);
                }
                
            }
        }
    }
    public void fireRobotLazers(){
        for (int i = 0; i <nextPlayerIdx; i++){
            players[i].getRobot().FIRE(this);
        }
    }

    public void addPlayer(Player player){
        boolean allowed = true;
        
        for (int j = 0; j < nextPlayerIdx; j++){
            if (players[j].getRobot().getRobotColor()  ==  (player.getRobot().getRobotColor())){
                allowed = false;
                
            }
        }
        for (int i = 0; i < nextPlayerIdx; i++){
            if (players[i].getRobot().getPos()  .equals  (player.getRobot().getPos())){
                allowed = false;
               
            }
        }
        if (allowed){
            players[nextPlayerIdx] = player;
            nextPlayerIdx++;
            
        }
    }
    public void moveRobot(Robot robot,Position pos){
        this.board.getTileAt(robot.getPos()).unOccupy();
        robot.setPos(pos);
        robot.setCheckpoint(new Position(pos.getColumn(),pos.getRow()));
        this.board.getTileAt(robot.getPos()).Occupy(robot.getImage(),robot.getDirID());
    }
    public void removePlayer(Player player){
        for (int i = 0; i < players.length;i++){
            if (players[i].getName().equals(player.getName())){
                players[i] = null;
                nextPlayerIdx--;
            }
        }
        if (this.players[nextPlayerIdx] != null){
            for (int i = 0; i < nextPlayerIdx; i++){
                if (players[i] == null){
                    players[i] = players[i+1];
                    players[i+1] = null;
                }
            }
        }
    }

    public Player[] getPlayers(){
        return this.players;
    }
    
    // check if a robot is allowed a move:
    public boolean allowmove(Robot robot,Direction dir){
        
        Position toPos = robot.getPosInDir(dir);
        
        if (toPos.getRow()>=0 && toPos.getColumn()>=0 && toPos.getColumn()<10 && toPos.getRow()<13){
                
                if (this.board.getTileAt(robot.getPos()) instanceof TileWall){
                    TileWall WT = (TileWall) this.board.getTileAt(robot.getPos());
                    if (dir.getId() == WT.getDirID()){return false;} 
                    
                }
               
                if (this.board.getTileAt(toPos) instanceof TileWall){
                    TileWall WT = (TileWall) this.board.getTileAt(toPos);

                    if (Math.abs(dir.getId() - WT.getDirID()) == 2){return false;} 
                    else{return true;}  
                }
        
                if (this.board.getTileAt(toPos).isOcupied()){getRobotAt(toPos).takeDmg(this);
                                                  return allowmove(getRobotAt(toPos),dir);}
                else{return true;}  
        }
        else{return true;} 
    }

    //@Overload
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

    public Robot getRobotAt(Position pos){
        
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<10 && pos.getRow()<13){
            
            for (int i=0; i < nextPlayerIdx; i++){
                if (players[i].getRobot().getPos().equals(pos)){
                    return players[i].getRobot();
                }   
            }
            return null;
        }
        else{
            return null;
        }
    }
}