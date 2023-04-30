package dtu.logic.models.Board;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Robot.Lazer;

public class TileLazer extends TileWall {
    private Position pos;

    public TileLazer(TileType Type,Direction dir,Position pos){
        super(Type,dir.getId());
        this.pos = pos;
        super.setImageString("tiles/Lazer" + dir.getId() + ".png");
    }
 
    public Position getPos(){
        return pos;
    }
    
    public void effect(Robot robot,BoardController boardController){;}

    public void FIRE(BoardController boardController){
        
        Lazer lazer = new Lazer(new Position(getPos().getColumn(), getPos().getRow()),Direction.getDirById(this.getDirID()).opposite());
        
        if (lazer.moveTillHit(boardController) == true){
            
            Robot hitRob = boardController.getRobotAt(lazer.getPos());
            hitRob.takeDmg(boardController);
        }
    }
}
