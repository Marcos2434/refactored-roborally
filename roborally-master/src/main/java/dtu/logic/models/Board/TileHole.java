package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileHole extends Tile {
    private String name = "HT";
    
    public TileHole(TileType type) {
	    super(type);
        super.setImageString("tiles/pit.png");
	}

    @Override
    public void effect(Robot robot, BoardController boardController) {
        robot.setPrevPos(robot.getPos());
        robot.Death(boardController);
    }

    @Override
    public String getname(){
    
    return this.name;
    }
}
