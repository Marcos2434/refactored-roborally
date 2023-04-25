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
    protected Direction direction;
    protected Image image;
	protected Image robotImage;
    protected int robotDirection;
    protected Boolean Ocupied = false;

    public Tile(TileType type) {
		super(TILE_SIZE, TILE_SIZE);
		this.type = type;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
		
		redraw();
	}

    public Tile(int tileSize, int tileSize2) {
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
        
    protected void redraw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		
        if (Ocupied) {
            System.out.println("Redraw");
        	gc.save();
            gc.transform(new Affine(new Rotate(90*(robotDirection-1), 33, 33)));
			gc.drawImage(robotImage, 0, 0);
			gc.restore();
        }
	}

    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot,Board board){
    ;
    }

    public String getname(){
        return this.name;
    }

    public void Occupy(Image robotImage, int rD){
        this.Ocupied = true;
        System.out.println("Occupy");
        this.robotImage = robotImage;
        this.robotDirection = rD;
        redraw();
        
    }

    public void unOccupy(){
        this.Ocupied = false;
        this.robotImage = null;
        this.robotDirection = -1;
        redraw();
    }

    public boolean isOcupied(){
        return this.Ocupied;
    }
}
