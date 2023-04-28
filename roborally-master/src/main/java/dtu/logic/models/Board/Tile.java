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
		
		//redraw();
	}

    public void setImage(Image image){
        this.image = image;
    }

    public String getimageString(){
        return this.imageString;
    }

    public void setimageString(String IS){
        this.imageString = IS;
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
        
    public void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (Ocupied) {
            
        	gc.save();
            gc.transform(new Affine(new Rotate(90*(robotDirection-1), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
	}

    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot, BoardController boardController) {}

    public String getname(){
        return this.name;
    }

    public void Occupy(){
        this.Ocupied = true;
       
        // this.robotImage = robotImage;
        // this.robotDirection = rD;
        // redraw();
        
    }

    public void unOccupy(){
        this.Ocupied = false;

        // this.robotImage = null;
        // this.robotDirection = -1;
        // redraw();
    }

    public boolean isOcupied(){
        return this.Ocupied;
    }
}
