package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileStart extends Tile {
    private String name = "Start";
    
    
    public TileStart(TileType type) {
	    super(type);
        super.setImageString("tiles/start.png");
	}

    @Override
    public void effect(Robot robot, BoardController boardController) { }
    
    @Override
    public String getname(){
    
    return this.name;
    }

}
