package models.Board;

public class Board {

    private Tile[][] grid = new Tile[14][10];

    
    public Board(String[][] stringGrid){
        if (stringGrid.length != 10 || stringGrid[0].length != 10){
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

    public Tile getTileAt(int i, int j) {
        return this.grid[i][j];
    }

}

