package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileStart extends Tile {
    private String name = "Start";
    
    public TileStart(TileType type) {
	    super(type);
	}

    @Override
    public void effect(Robot robot, Board board) {;}
    
    @Override
    public String getname(){
    
    return this.name;
    }

}
