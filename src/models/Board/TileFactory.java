package models.Board;

public class TileFactory {
    public static Tile createtile(String T){
        switch(T) {
            case "HT": 
                return new TileHole();            
            default:   
                return new Tile();
        }
    }
}
