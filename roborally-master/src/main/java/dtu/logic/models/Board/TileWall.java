package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.image.Image;

public class TileWall extends Tile{
    private String name = "WT";
    private int DirID;

    public TileWall(Direction dir){
        super(TILE_SIZE, TILE_SIZE);
        this.DirID = dir.getId();
        super.type = TileType.HOLE;
		super.image = new Image(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
		
		redraw();
	}

    public void effect(Robot robot){;}
    
    public String getname(){return this.name;}

    public int getDirID(){return this.DirID;}
}
