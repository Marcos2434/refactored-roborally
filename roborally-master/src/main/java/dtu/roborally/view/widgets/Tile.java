package dtu.roborally.view.widgets;


import dtu.logic.models.Board.TileType;
import dtu.roborally.view.CardinalPoints;
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
	
	public Tile() {
		super(TILE_SIZE, TILE_SIZE);
		this.type = TileType.FLOOR;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
	}
	
	public void setRobot(CardinalPoints direction) {
		this.containsRobot = true;
		this.direction = direction;
	}
	
	public void unsetRobot() {
		this.containsRobot = false;
	}
	
}
