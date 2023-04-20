package dtu.logic.models.Board;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Robot.Lazer;
import javafx.scene.image.Image;
public class TileLazer extends TileWall{
    private String name = "LT";
    private Position pos;
    public Position getPos(){
        return pos;
    }
    public TileLazer(TileType Type,Direction dir,Position pos){
        super(Type,dir.getId());
        this.pos = pos;
        this.image = new Image("tiles/Lazer" + dir.getId() + ".png");
        redraw();
    }
    public TileLazer(TileType Type,Direction dir,Position pos,boolean test){
        super(Type,dir.getId(),test);
        this.pos = pos;
    }

    public void FIRE(Board board){
        
        Lazer lazer = new Lazer(new Position(getPos().getColumn(), getPos().getRow()),Direction.getDirById(this.getDirID()));
        lazer.Uturn();
        if (lazer.moveTillHit(board) == true){
            
            Robot hitRob = board.getRobotAt(lazer.getPos());
            hitRob.takeDmg(board);
        }
    }
}
