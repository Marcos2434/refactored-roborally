package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileStart extends Tile{
    private String name = "S";
    
    public TileStart(TileType type) {
	    super(type);
	}

    @Override
    public void effect(Robot robot) {
    }
    @Override
    public String getname(){
    
    return this.name;
    }

}
