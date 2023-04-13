package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.Robot.Robot;
import javafx.scene.layout.GridPane;

public class Board extends GridPane{

    private Tile[][] grid = new Tile[14][10];

    
    public Board(String[][] stringGrid){
        if (stringGrid.length != 14 || stringGrid[0].length != 10){
            System.out.println("Invalid size of grid");
        }
        else{
            for (int row = 0; row < 10; row++) { 
                for (int col = 0; col < 10; col++) {
                        String T = stringGrid[row][col];
                        this.grid[row][col] = TileFactory.createtile(T);
                        add(this.grid[row][col], row, col);
                        
                }
            }
        }
        
    }

    public Tile[][] getGrid() {
        return this.grid;
    }

    public Tile getTileAt(Position pos) {
        if (pos.getY()>=0 && pos.getX()>=0 && pos.getX()<14 && pos.getY()<10){
            return this.grid[pos.getX()][pos.getY()];
        }
        else{
            return null;
            
        }
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

}

