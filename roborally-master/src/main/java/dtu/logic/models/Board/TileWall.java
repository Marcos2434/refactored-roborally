package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;

public class TileWall extends Tile{
    private String name = "WT";
    private int DirID;

    public TileWall(Direction dir){this.DirID = dir.getId();}

    public void effect(Robot robot){;}
    
    public String getname(){return this.name;}

    public int getDirID(){return this.DirID;}
}
