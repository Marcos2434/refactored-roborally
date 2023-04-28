package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class TileWall extends Tile{
    private String name = "WT";
    private int DirID;

    public TileWall(TileType type, int dir){
        super(type);
        this.DirID = dir;
        this.imageString = "tiles/wall" + DirID + ".png";
  
	}
    

    @Override
    public void effect(Robot robot,BoardController boardController){;}
    
    public String getname(){return this.name;}

    public int getDirID(){return this.DirID;}
}
