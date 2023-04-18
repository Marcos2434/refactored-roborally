package dtu.logic.models.Board;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Position;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Direction;

public class TileLazer extends TileWall{
    private String name = "LT";
    
    public TileLazer(TileType Type,Direction dir,Position pos){
        super(Type,dir.getId());
        setPos(pos);
    }
    public void FIRE(Board board){
        Lazer lazer = new Lazer(new Position(getPos().getX(), getPos().getY()),Direction.getDirById(this.getDirID()));
        lazer.Uturn();
        if (lazer.moveTillHit(board) == true){
            
            Robot hitRob = board.getRobotAt(lazer.getPos());
            
            hitRob.takeDmg(board);
        }
    } 
}
