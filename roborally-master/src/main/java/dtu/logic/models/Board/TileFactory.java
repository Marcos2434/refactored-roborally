package dtu.logic.models.Board;

import dtu.logic.models.Position;

public class TileFactory {
    public static Tile createtile(String T, int X, int Y){
        String[] tiles = T.split(" ");
        
        
        if  (tiles[0].equals("HT")){
            
            return new TileHole(TileType.HOLE);
        }
        
        else if (tiles[0].trim().equals("WT")){ 
            
            return new TileWall(TileType.WALL, Integer.parseInt(tiles[1]));
            
        }
         
        else if (tiles[0].trim().equals("S")){ 
            
            return new TileStart(TileType.START);
            
        }

        else if (tiles[0].trim().equals("C")){ 
            
            return new TileCheckpoint(TileType.CHECKPOINT, Integer.parseInt(tiles[1]), new Position(X, Y));
            
        }

        else{return new Tile(TileType.FLOOR);}
    }
    public static Tile createtile(String T, int X, int Y, Boolean test){
        String[] tiles = T.split(" ");
        
        
        if  (tiles[0].equals("HT")){
            
            return new TileHole(TileType.HOLE);
        }
        
        else if (tiles[0].trim().equals("WT")){ 
            
            return new TileWall(TileType.WALL, Integer.parseInt(tiles[1]), test);
            
        }
         
        else if (tiles[0].trim().equals("S")){ 
            
            return new TileStart(TileType.START);
            
        }

        else if (tiles[0].trim().equals("C")){ 
            
            return new TileCheckpoint(TileType.CHECKPOINT, Integer.parseInt(tiles[1]), new Position(X, Y));
            
        }

        else{return new Tile(TileType.FLOOR);}
    }
}

