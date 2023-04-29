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
    private Position position;
    
    public TileCheckpoint(TileType type, int id, Position pos) {
	    super(type);
        this.id = id;
        this.imageString = "tiles/checkpoint" + id + ".png";
        this.position = pos;
       
	}
    //@overload



    @Override
    public void effect(Robot robot, BoardController boardController) {
        
        if (robot.getCheckpointCount() == this.id-1){
            robot.addCheckpoint(position);
            robot.CheckpointReached();
        }
        
        
    }

    @Override
    public String getname(){
    
    return this.name;
    }

   

}
