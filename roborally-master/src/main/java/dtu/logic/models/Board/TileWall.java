package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;

public class TileWall extends Tile{
    private String name = "WT";
    private int DirID;

    public TileWall(TileType type, int dir){
        super(type);
        this.DirID = dir;
        super.setImageString("tiles/wall" + DirID + ".png");
  
	}
    

    @Override
    public void effect(Robot robot,BoardController boardController){;}
    
    public String getname(){return this.name;}

    public int getDirID(){return this.DirID;}
}
