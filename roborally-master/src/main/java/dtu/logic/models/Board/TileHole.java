package dtu.logic.models.Board;

public class TileHole extends Tile{
    private String name = "TH";
    
    @Override
    public void effect() {
        System.out.println("HoleTile effect");
    }

    
}
