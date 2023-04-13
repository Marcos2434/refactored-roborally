package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;

public class TileHole extends Tile{
    private String name = "HT";
    
    @Override
    public void effect(Robot robot) {
        robot.Death();
    }
    @Override
    public String getname(){
    
    return this.name;
}

}
