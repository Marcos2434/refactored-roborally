package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;
import javafx.scene.layout.GridPane;

import java.sql.Array;
import java.util.ArrayList;

import dtu.logic.models.Direction;

public class Board extends GridPane {

    private Tile[][] grid = new Tile[13][10];
    private Player[] players;
    private static int nextPlayerIdx = 0;
    
    public Board(String[][] boardGrid){
        if (boardGrid.length != 13 || boardGrid[0].length != 10){
            System.out.println("Invalid size of grid");
        }
        else{
            for (int row = 0; row < 13; row++) { 
                for (int col = 0; col < 10; col++) {
                        String T = boardGrid[row][col];
                        this.grid[row][col] = TileFactory.createtile(T, col, row);
                        add(this.grid[row][col], col, row);
                        
                }
            }
        }
    }
    public Board(String[][] boardGrid, Boolean test){
        if (boardGrid.length != 13 || boardGrid[0].length != 10){
            System.out.println("Invalid size of grid");
        }
        else{
            for (int row = 0; row < 13; row++) { 
                for (int col = 0; col < 10; col++) {
                        String T = boardGrid[row][col];
                        this.grid[row][col] = TileFactory.createtile(T, col, row, test);
                        add(this.grid[row][col], col, row);
                        
                }
            }
        }
    }

    public void fireboardLazers(){
        for (int i=0; i<13; i++){
            for (int j=0; j<10; j++){
                Tile tile = getTileAt(new Position(i,j));
                if (tile instanceof TileLazer){
                    TileLazer TL = (TileLazer)tile;
                    TL.FIRE(this);
                }

            }
        }
    }

    public void initPlayers(){
        players = new Player[4];
        nextPlayerIdx = 0;
    }
    
    public Tile[][] getGrid() {
        return this.grid;
    }

    public void runAllRegisters(){
        for (int i=0; i<5;i++){
            for (int j=0; j<nextPlayerIdx; j++){
                System.out.println("Running card " + (i+1));
                Robot r = players[j].getRobot();

                if (r.getRegister().size() > i){
                    r.moveByCard(this, r.getRegister().get(i));
                }

                if (i == 4){
                    r.setRegister(new ArrayList<ProgramCard>());
                }

                try{Thread.sleep(1000);}
                catch(Exception e){System.out.println(e);}
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
                if (getTileAt(new Position(i,j)).isOcupied()){
                    
                    getTileAt(new Position(i,j)).effect(getRobotAt(new Position(i,j)),this);
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
            if (players[j].getRobot().getColor()  ==  (player.getRobot().getColor())){
                allowed = false;
                System.out.println("false1");
            }
        }
        for (int i = 0; i < nextPlayerIdx; i++){
            if (players[i].getRobot().getPos()  .equals  (player.getRobot().getPos())){
                allowed = false;
                System.out.println("false1");
            }
        }
        if (allowed){
            players[nextPlayerIdx] = player;
            nextPlayerIdx++;
            System.out.println("Player added");
        }
    }
    public void moveRobot(Robot robot,Position pos){
        getTileAt(robot.getPos()).unOccupy();
        robot.setPos(pos);
        getTileAt(robot.getPos()).Occupy(robot.getImage(),robot.getDirID());
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
    public Tile getTileAt(Position pos) {
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<10 && pos.getRow()<13){
            return this.grid[pos.getRow()][pos.getColumn()];
        }
        else{
            return null;
        }
    }
    public int getplayeridx(){
        return nextPlayerIdx;
    }
    // check if a robot is allowed a move:
    public boolean allowmove(Robot robot,Direction dir){
        
        Position toPos = robot.getPosInDir(dir);
        
        if (toPos.getRow()>=0 && toPos.getColumn()>=0 && toPos.getColumn()<10 && toPos.getRow()<13){
                
                if (getTileAt(robot.getPos()) instanceof TileWall){
                    TileWall WT = (TileWall) getTileAt(robot.getPos());
                    if (dir.getId() == WT.getDirID()){return false;} 
                    
                }
               
                if (getTileAt(toPos) instanceof TileWall){
                    TileWall WT = (TileWall) getTileAt(toPos);

                    if (Math.abs(dir.getId() - WT.getDirID()) == 2){return false;} 
                    else{return true;}  
                }
        
                if (getTileAt(toPos).isOcupied()){getRobotAt(toPos).takeDmg(this);
                                                  return allowmove(getRobotAt(toPos),dir);}
                else{return true;}  
        }
        else{return true;} 
    }

    //@Overload
    public boolean allowmove(Lazer lazer){
        if (getTileAt(lazer.getPos()) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(lazer.getPos());
            if (lazer.getdir().getId() == WT.getDirID()){return false;}   
        }
        if (getTileAt(lazer.getPosInDir(lazer.getdir())) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(lazer.getPosInDir(lazer.getdir()));
            if (Math.abs(lazer.getdir().getId() - WT.getDirID()) == 2){return false;}
            else{return true;}
        }
        else {return true;} 
    }


    public Robot getRobotAt(Position pos){
        
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<10 && pos.getRow()<13){
            
            for (int i=0; i<nextPlayerIdx; i++){
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

