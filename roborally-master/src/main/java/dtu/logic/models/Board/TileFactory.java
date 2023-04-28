package dtu.logic.models.Board;

import dtu.logic.models.Position;
import dtu.logic.models.Direction;
public class TileFactory {
    public static Tile createtile(String T, int col, int row){
        String[] tiles = T.split(" ");
        
        
        if  (tiles[0].equals("HT")){
            
            return new TileHole(TileType.HOLE);
        }
        
        else if (tiles[0].trim().equals("WT")){ 
            
            return new TileWall(TileType.WALL, Integer.parseInt(tiles[1]));
            
        }

        else if (tiles[0].trim().equals("LT")){ 
           
            return new TileLazer(TileType.LAZER, Direction.getDirById(Integer.parseInt(tiles[1])),new Position(col,row));
            
        }
        else if (tiles[0].trim().equals("BT")){ 
            
            return new TileBelt(TileType.BELT, Direction.getDirById(Integer.parseInt(tiles[1])),Integer.parseInt(tiles[2]));
        }
         
        else if (tiles[0].trim().equals("S")){ 
            
            return new TileStart(TileType.START);
            
        }

        else if (tiles[0].trim().equals("C")){ 
            
            return new TileCheckpoint(TileType.CHECKPOINT, Integer.parseInt(tiles[1]), new Position(col, row));
            
        }

        else if (tiles[0].trim().equals("RT")){ 
            
            return new TileRepair(TileType.REPAIR);
        }

        else if (tiles[0].trim().equals("AT")){ 
            
            return new TileAction(TileType.ACTION);
        }

        else{return new Tile(TileType.FLOOR);}
    }

}

