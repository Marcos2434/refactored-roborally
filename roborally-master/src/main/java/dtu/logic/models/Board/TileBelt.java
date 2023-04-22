package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.image.Image;

public class TileBelt extends Tile{
    private String name = "BT";
    private Direction dir;
    private int intensity;


    
    public TileBelt(TileType type, Direction dir,int intensity){
        super(type);
        this.dir = dir;
        this.image = new Image("tiles/" + intensity + "speedBelt" + dir.getId() + ".png");
        this.intensity = intensity;
        redraw();
	}
    
    public TileBelt(TileType type, Direction dir,int intensity, Boolean test){
        super(type);
        this.dir = dir;
        this.intensity = intensity;
        redraw();
	}
    public String getname(){
        return this.name;
    }
    public Direction getdir(){
        return dir;
    }
    public void effect(Robot robot,Board board){
        board.getTileAt(robot.getPos()).unOccupy();
       
        if (intensity == 2){
            pushRobot(robot,this.dir);
            
            if (board.getTileAt(robot.getPos()) instanceof TileBelt){
                TileBelt tileBelt = (TileBelt) board.getTileAt(robot.getPos());
                pushRobot(robot,tileBelt.getdir());
            }
        }
        else{ 
            pushRobot(robot, this.dir);
        }
        board.getTileAt(robot.getPos()).Occupy(image, dir.getId()); 
    }
    private void pushRobot(Robot robot,Direction dir){
        if (dir.getId() == 1){robot.getPos().addY(-1);}
            else if (dir.getId() == 2){robot.getPos().addX(1);}
            else if (dir.getId() == 3){robot.getPos().addY(1);}
            else if (dir.getId() == 4){robot.getPos().addX(-1);}
    }
}
