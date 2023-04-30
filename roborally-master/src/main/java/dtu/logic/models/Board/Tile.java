package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Tile extends Canvas {
    /*
    Main Tile class that other tiles extend from. If the methods are not
    overriden then the default tile is a floor tile.
    */

    public static final int TILE_SIZE = 66;
    private String name = "T";
    private TileType type;
    private Direction direction;
    private String imageString;
	private Image robotImage;
    private int robotDirection;
    private Boolean Ocupied = false;

    public Tile(TileType type) {
		super(TILE_SIZE, TILE_SIZE);
		this.type = type;
		this.imageString = "tiles/floor.png";
	}

    public int getRobotDirection(){
        return this.robotDirection;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public String getImageString(){
        return this.imageString;
    }

    public Image getRobotImage(){
        return this.robotImage;
    }

    public void setImageString(String IS){
        this.imageString = IS;
    }

    public Image getImage() {
        return new Image(this.getImageString());
    }
  
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile t = (Tile) obj;
            return this.type == t.getType();
        }
        return false;
    }
    
    public TileType getType() {
        return this.type;
    }

    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot, BoardController boardController) {}

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
