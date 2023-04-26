package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;
public class TurnRight implements ProgramCard{
    private int intensity;
    
    private String image = "Cards/right_turn.png";
    
    @Override
    public String getImage(){
        return this.image;
    }

    public TurnRight(int intensity) {
        this.intensity = intensity;
    }
    public void effect(Robot robot,Board board){
            robot.turn(intensity, board);
        
    }
}
