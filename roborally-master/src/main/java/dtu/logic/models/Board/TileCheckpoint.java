package dtu.logic.models.Board;
import dtu.logic.models.Position;
import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class TileCheckpoint extends Tile{
    private String name = "C";
    private int id;
    private Image image;
    private Position position;

    
    @Override
    protected void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (containsRobot) {
        	gc.save();
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

    @Override
    public void effect(Robot robot) {
        robot.setCheckpoint(position);
    }

    @Override
    public String getname(){
    
    return this.name;
    }

}
