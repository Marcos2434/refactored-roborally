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
        this.intensity = intensity;
        this.imageString = "tiles/" + intensity + "speedBelt" + dir.getId() + ".png";
       
	}
   //muahahahh

    public String getname(){
        return this.name;
    }
    public Direction getdir(){
        return dir;
    }
    public void effect(Robot robot, BoardController boardController){
        robot.setPrevPos(robot.getPos());
        boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
        
        if (intensity == 2){
           
            if (boardController.getBoard().getTileAt(robot.getPos()) instanceof TileBelt){
               
                TileBelt currtile = (TileBelt)boardController.getBoard().getTileAt(robot.getPos());
                pushRobot(robot,currtile.getdir());
                boardController.getBoard().getTileAt(robot.getPos()).Occupy();
                
                robot.robotNotify();
                try{Thread.sleep(500);}
                catch(Exception e){System.out.println(e);}

                if (boardController.getBoard().getTileAt(robot.getPos()) instanceof TileBelt){
                    robot.setPrevPos(robot.getPos());
                    TileBelt nextTileBelt = (TileBelt) boardController.getBoard().getTileAt(robot.getPos());
                    boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
                    pushRobot(robot,nextTileBelt.getdir());
                    robot.robotNotify();
                }
            }
        }
        else{ 
            try{Thread.sleep(500);}
                catch(Exception e){System.out.println(e);}
            pushRobot(robot, this.dir);
        }
        boardController.getBoard().getTileAt(robot.getPos()).Occupy(); 
        robot.robotNotify();

       
    
}

    private void pushRobot(Robot robot,Direction dir){
        if (dir.getId() == 1){robot.getPos().addY(-1);}
            else if (dir.getId() == 2){robot.getPos().addX(1);}
            else if (dir.getId() == 3){robot.getPos().addY(1);}
            else if (dir.getId() == 4){robot.getPos().addX(-1);}
    }
    
}
