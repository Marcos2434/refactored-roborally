package dtu.logic.models.Board;

public class TileFactory {
    public static Tile createtile(String T){
        String[] tiles = T.split(" ");
        
        
        if  (tiles[0].equals("HT")){
            
            return new TileHole(TileType.HOLE);}
        
        else if (tiles[0].trim().equals("WT")){ 
            
            return new TileWall(TileType.WALL, Integer.parseInt(tiles[1]));
            
        }
         
        else if (tiles[0].trim().equals("S")){ 
            
            return new TileStart(TileType.START);
            
        }

        else{return new Tile(TileType.FLOOR);}
    }
}

