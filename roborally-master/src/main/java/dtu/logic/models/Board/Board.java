package dtu.logic.models.Board;

import dtu.logic.models.Position;

public class Board {

    private Tile[][] grid = new Tile[14][10];

    
    public Board(String[][] stringGrid){
        if (stringGrid.length != 14 || stringGrid[0].length != 10){
            System.out.println("Invalid size of grid");
        }
        else{
            for (int i = 0; i < 10; i++) { 
                for (int j = 0; j < 10; j++) {
                        String T = stringGrid[i][j];
                        this.grid[i][j] = TileFactory.createtile(T);
                        
                }
            }
        }
        
    }

    public Tile[][] getGrid() {
        return this.grid;
    }

    public Tile getTileAt(Position pos) {
        if (pos.getY()>=0 && pos.getX()>=0 && pos.getY()<14 && pos.getX()<10){
            return this.grid[pos.getY()][pos.getX()];
        }
        else{
            return null;
            
        }
    }

}

