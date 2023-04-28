package dtu.logic.models.Board;

import dtu.logic.models.Direction;
import dtu.logic.models.Robot.Robot;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Tile extends Canvas {
    public static final int TILE_SIZE = 66;

    private String name = "T";
    protected TileType type;
    protected Direction direction;
    protected Image image;
    protected String imageString;
	protected Image robotImage;
    protected int robotDirection;
    protected Boolean Ocupied = false;

    public Tile(TileType type) {
		super(TILE_SIZE, TILE_SIZE);
		this.type = type;
		this.imageString = "tiles/floor.png";
	}

    public void setImage(Image image){
        this.image = image;
    }

    public String getImageString(){
        return this.imageString;
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
