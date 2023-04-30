package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;

public class TileBelt extends Tile{
    private String name = "BT";
    private Direction dir;
    private int intensity;


    
    public TileBelt(TileType type, Direction dir,int intensity){
        super(type);
        this.dir = dir;
        this.intensity = intensity;
        super.setImageString("tiles/" + intensity + "speedBelt" + dir.getId() + ".png");
       
	}

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
                
                

                try{
                    Thread.sleep(50);
                }
                catch(Exception e){System.out.println(e);}

                robot.robotNotify();

                try{
                //    Thread.sleep(500);
                }
                catch(Exception e){System.out.println(e);}
                robot.setPrevPos(robot.getPos());
                

                if (boardController.getBoard().getTileAt(robot.getPos()) instanceof TileBelt){
                    robot.setPrevPos(robot.getPos());
                    TileBelt nextTileBelt = (TileBelt) boardController.getBoard().getTileAt(robot.getPos());
                    boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
                    pushRobot(robot,nextTileBelt.getdir());

                    try{
                        Thread.sleep(50);
                    }
                    catch(Exception e){System.out.println(e);}
                    robot.robotNotify();
                    try{
                        Thread.sleep(50);
                    }
                    catch(Exception e){System.out.println(e);}

                }
            }
        }
        else{ 
           try{
            //   Thread.sleep(500);
        }
               catch(Exception e){System.out.println(e);}
           pushRobot(robot, this.dir);
        }
       
        robot.robotNotify();

       
    
}

    private void pushRobot(Robot robot,Direction dir){

        if (dir.getId() == 1){robot.getPos().addY(-1);}
            else if (dir.getId() == 2){robot.getPos().addX(1);}
            else if (dir.getId() == 3){robot.getPos().addY(1);}
            else if (dir.getId() == 4){robot.getPos().addX(-1);}
    }
    
}
