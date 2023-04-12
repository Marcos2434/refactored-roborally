package dtu.logic.models.Board;

import dtu.logic.models.Direction;

public class TileFactory {
    public static Tile createtile(String T){
        String[] tiles = T.split(" ");
        
        
        if  (tiles[0].equals("HT")){
            
            return new TileHole();}
        
        if (tiles[0].trim().equals("WT")){ 
            
            return new TileWall(Direction.getDirById(Integer.parseInt(tiles[1])));
            
        }
            
        else{return new Tile();}
    }
}

