package dtu.roborally.view.widgets;


import dtu.roborally.view.CardinalPoints;
import dtu.roborally.view.TileType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Tile extends Canvas {

	public static final int TILE_SIZE = 66;
	
	private TileType type;
	private boolean containsRobot;
	private CardinalPoints direction;
	private Image image;
	private static Image robotImage;
	
	static {
		robotImage = new Image(Tile.class.getClassLoader().getResourceAsStream("robot.png"));
	}
	
	public Tile(TileType type) {
		super(TILE_SIZE, TILE_SIZE);
		this.type = type;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
		
		redraw();
	}
	
	private void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (containsRobot) {
        	gc.save();
        	gc.transform(new Affine(new Rotate(direction.getAngle(), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
	}
	
	public void setRobot(CardinalPoints direction) {
		this.containsRobot = true;
		this.direction = direction;
		redraw();
	}
	
	public void unsetRobot() {
		this.containsRobot = false;
		redraw();
	}
	
}
