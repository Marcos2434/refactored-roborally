package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.image.Image;

public class TileBelt extends Tile{
    public Direction dir;
    public int intensity;

    public TileBelt(TileType type, Direction dir,int intensity){
        super(type);
        this.dir = dir;
        this.image = new Image("tiles/" + intensity + "speedBelt" + dir.getId() + ".png");
        redraw();
	}
    
    public TileBelt(TileType type, Direction dir,int intensity, Boolean test){
        super(type);
        this.dir = dir;
        redraw();
	}

    public void effect(Robot robot,Board board){
        board.getTileAt(robot.getPos()).unOccupy();
        if (this.dir.getId() == 1){robot.getPos().addY(-1);}
        else if (this.dir.getId() == 2){robot.getPos().addX(1);}
        else if (this.dir.getId() == 3){robot.getPos().addY(1);}
        else if (this.dir.getId() == 4){robot.getPos().addX(-1);}
        board.getTileAt(robot.getPos()).Occupy(image, dir.getId()); 
    }

    
}
