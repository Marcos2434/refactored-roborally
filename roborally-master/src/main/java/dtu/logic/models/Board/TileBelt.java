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
    public void effect(Robot robot, BoardController boardController){
        
        boardController.getTileAt(robot.getPos()).unOccupy();
        System.out.println("before 2");
        if (intensity == 2){
            System.out.println("in 2");
            if (boardController.getTileAt(robot.getPos()) instanceof TileBelt){
                System.out.println("in instance 1");
                TileBelt currtile = (TileBelt)boardController.getTileAt(robot.getPos());
                pushRobot(robot,currtile.getdir());
                boardController.getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getdir().getId()); 
                try{Thread.sleep(500);}
                catch(Exception e){System.out.println(e);}

                if (boardController.getTileAt(robot.getPos()) instanceof TileBelt){
                    System.out.println("in instance 2");
                    TileBelt nextTileBelt = (TileBelt) boardController.getTileAt(robot.getPos());
                    boardController.getTileAt(robot.getPos()).unOccupy();
                    pushRobot(robot,nextTileBelt.getdir());
                }
            }
        }
        else{ 
            pushRobot(robot, this.dir);
        }
        board.getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getdir().getId()); 
       
    
}

    private void pushRobot(Robot robot,Direction dir){
        if (dir.getId() == 1){robot.getPos().addY(-1);}
            else if (dir.getId() == 2){robot.getPos().addX(1);}
            else if (dir.getId() == 3){robot.getPos().addY(1);}
            else if (dir.getId() == 4){robot.getPos().addX(-1);}
    }
    
}
