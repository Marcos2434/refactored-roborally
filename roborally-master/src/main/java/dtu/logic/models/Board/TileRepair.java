package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;

public class TileRepair extends Tile{
    
    public TileRepair(TileType type) {
        super(type);
        super.setImageString("tiles/Repair.png");
    }
    @Override
    public void effect(Robot robot,BoardController boardController){
        while (robot.getDamageTaken() > 0){
            robot.heal();
        }
    }
}
