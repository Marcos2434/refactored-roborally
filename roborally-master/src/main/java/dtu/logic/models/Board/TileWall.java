package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class TileWall extends Tile{
    private String name = "WT";
    private int DirID;

    @Override
    protected void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (containsRobot) {
        	gc.save();
        	gc.transform(new Affine(new Rotate(90*(robotDirection-1), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
    }

    public TileWall(TileType type, int dir){
        super(type);
        this.DirID = dir;
        this.image = new Image("tiles/wall" + DirID + ".png");
        redraw();
	}
    
    public TileWall(TileType type, int dir, Boolean test){
        super(type);
        this.DirID = dir;
        redraw();
	}

    public void effect(Robot robot){;}
    
    public String getname(){return this.name;}

    public int getDirID(){return this.DirID;}
}
