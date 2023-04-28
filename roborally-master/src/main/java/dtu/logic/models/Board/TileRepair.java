package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;
import javafx.scene.image.Image;

public class TileRepair extends Tile{
    
    public TileRepair(TileType type) {
        super(type);
        this.imageString = "tiles/Repair.png";
    }

    public void effect(Robot robot){
        while (robot.getDamageTaken() > 0){
            robot.heal();
        }
    }
}