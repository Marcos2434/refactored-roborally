package dtu.logic.models.Board;
import java.util.ArrayList;

import dtu.logic.models.Position;
import javafx.scene.layout.GridPane;

public class Board extends GridPane {

    private Tile[][] grid = new Tile[13][10];
    
    
    
    public Board(String[][] boardGrid){
        if (boardGrid.length != 13 || boardGrid[0].length != 10){
            System.out.println("Invalid size of grid");
        }
        else{
            for (int row = 0; row < 13; row++) { 
                for (int col = 0; col < 10; col++) {
                        String T = boardGrid[row][col];
                        this.grid[row][col] = TileFactory.createtile(T, col, row);
                        // add(this.grid[row][col], col, row);
                }
            }
        }
    }

   // public Board(String[][] boardGrid, Boolean test){
   //     if (boardGrid.length != 13 || boardGrid[0].length != 10){
   //         System.out.println("Invalid size of grid");
   //     }
   //     else{
   //         for (int row = 0; row < 13; row++) { 
   //             for (int col = 0; col < 10; col++) {
   //                     String T = boardGrid[row][col];
   //                     this.grid[row][col] = TileFactory.createtile(T, col, row, test);
   //                     // add(this.grid[row][col], col, row);
   //                     
   //             }
   //         }
   //     }
   // }

    public Tile[][] getGrid() {
        return this.grid;
    }

    public Tile getTileAt(Position pos) {
        if (pos.getRow()>=0 && pos.getColumn()>=0 && pos.getColumn()<10 && pos.getRow()<13){
            return this.getGrid()[pos.getRow()][pos.getColumn()];
        }
        return null;
    }
}

