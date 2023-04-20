package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileHole extends Tile{
    private String name = "HT";
    
    public TileHole(TileType type) {
	    super(type);
	}

    @Override
    public void effect(Robot robot,Board board) {
        robot.Death(board);
    }

    @Override
    public String getname(){
    
    return this.name;
}

}
