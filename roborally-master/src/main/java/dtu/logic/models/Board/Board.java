package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;
import javafx.scene.layout.GridPane;

public class Board extends GridPane{

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
    public void initPlayers(){
        players = new Player[4];
        nextPlayerIdx = 0;
    }
    
    public Tile[][] getGrid() {
        return this.grid;
    }

    public void addPlayer(Player player){
        boolean allowed = true;

        for (int j = 0; j < nextPlayerIdx; j++){
            if (players[j].getRobot().getColor()  ==  (player.getRobot().getColor())){
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
    public boolean allowmove(Robot robot){
        if (getTileAt(robot.getPos()) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(robot.getPos());
            if (robot.getDirID() == WT.getDirID()){return false;}   
        }
        
        if (getTileAt(robot.getPosAhead()) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(robot.getPosAhead());
            if (Math.abs(robot.getDirID() - WT.getDirID()) == 2){return false;}
            else{return true;}
        }
        else {return true;} 
    }

    //@Overload
    public boolean allowmove(Lazer lazer){
        if (getTileAt(lazer.getPos()) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(lazer.getPos());
            if (lazer.getDir().getId() == WT.getDirID()){return false;}   
        }
        if (getTileAt(lazer.getPosAhead()) instanceof TileWall){
            TileWall WT = (TileWall) getTileAt(lazer.getPosAhead());
            if (Math.abs(lazer.getDir().getId() - WT.getDirID()) == 2){return false;}
            else{return true;}
        }
        else {return true;} 
    }


    public Robot getRobotAt(Position pos){
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<13 && pos.getRow()<10 && getTileAt(pos).isOcupied() == true){
            
            for (int i=0; i<nextPlayerIdx; i++){
                if (players[i].getRobot().getPos().getColumn() == pos.getColumn() && players[i].getRobot().getPos().getRow() == pos.getRow()){
                    return players[i].getRobot();
                }
                else{;}
            }
            return null;

        }
        else{
            return null;
        }
    }
}

