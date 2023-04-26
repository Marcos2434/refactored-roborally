package dtu.logic.models.Board;
import dtu.logic.models.Position;
import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class TileCheckpoint extends Tile {
    private String name = "C";
    private int id;
    private Image image;
    private Position position;

    
    @Override
    protected void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (Ocupied) {
        	gc.save();
            gc.transform(new Affine(new Rotate(90*(robotDirection-1), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
    }
    public TileCheckpoint(TileType type, int id, Position pos) {
	    super(type);
        this.id = id;
        this.image = new Image("tiles/checkpoint" + id + ".png");
        this.position = pos;
        redraw();
	}
    //@overload
    public TileCheckpoint(TileType type, int id, Position pos,boolean test) {
	    super(type);
        this.id = id;
        this.position = pos;
       
	}



    @Override
    public void effect(Robot robot, BoardController boardController) {
        if (robot.getcheckpointCount() == this.id-1){
            robot.addCheckpoint(position);
            robot.CheckpointReached();
        }
        
    }

    @Override
    public String getname(){
    
    return this.name;
    }

   

}
