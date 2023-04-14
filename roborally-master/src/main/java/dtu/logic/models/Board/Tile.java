package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Tile extends Canvas{
    public static final int TILE_SIZE = 66;

    private String name = "T";
     protected TileType type;
   	protected boolean containsRobot;
    protected Direction direction;
    protected Image image;
	protected static Image robotImage;

    static {
		robotImage = new Image(Tile.class.getClassLoader().getResourceAsStream("robot.png"));
	}

    public Tile(TileType type) {
		super(TILE_SIZE, TILE_SIZE);
		this.type = type;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
		
		redraw();
	}

    public Tile(int tileSize, int tileSize2) {
    }

    protected void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (containsRobot) {
        	gc.save();
        	gc.transform(new Affine(new Rotate(90*(direction.getId()), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
	}
private Boolean Ocupied = false;
    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot){
    ;
    }

    public String getname(){
        return this.name;
    }

    public void Occupy(){
        this.Ocupied = true;
    }

    public void unOccupy(){
        this.Ocupied = false;
    }

    public boolean isOcupied(){
        return this.Ocupied;
    }
}
